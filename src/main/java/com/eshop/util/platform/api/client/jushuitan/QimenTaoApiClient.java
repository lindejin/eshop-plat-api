package com.eshop.util.platform.api.client.jushuitan;


import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomRequest;
import com.eshop.util.platform.api.client.jushuitan.response.QimenCustomResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 奇门自定义接口调用客户端（jushuitan）- 纯JSON版
 * 完全移除XML，只支持JSON格式请求
 */
@Slf4j
@Service
public class QimenTaoApiClient {

    @Autowired
    private OkHttpClient client;

    private final static int MAX_RETRIES = 3;
    private static final String CHARSET_UTF8 = "utf-8";
    private static final String SIGN_METHOD_MD5 = "md5";
    private static final String SIGN_METHOD_HMAC = "hmac";

    /**
     * 淘宝奇门API标准调用方法 (JSON格式)
     */
    public QimenCustomResponse executeTaoBao(QimenCustomRequest jstRequest, QimenCustomAppClientDTO appDTO) throws Exception {
        checkParams(jstRequest, appDTO);
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String timestamp = "2026-01-18 18:19:43"; // 实际使用时应该用当前时间

        // 1. 系统必需参数 (放在URL查询参数中)
        Map<String, String> protocalMustParams = new TreeMap<>(); // 必须排序
        protocalMustParams.put("method", jstRequest.getMethod());
        protocalMustParams.put("v", jstRequest.getVersion() != null ? jstRequest.getVersion() : "2.0");
        protocalMustParams.put("app_key", appDTO.getAppKey());
        protocalMustParams.put("timestamp",timestamp );

        // 2. 系统可选参数 (放在URL查询参数中)
        Map<String, String> protocalOptParams = new TreeMap<>(); // 必须排序
        // 强制设置为JSON格式
        protocalOptParams.put("format", "json");
        protocalOptParams.put("sign_method", jstRequest.getSignMethod() != null ? jstRequest.getSignMethod() : "md5");

        // 非必填参数
        if (StringUtils.isNotBlank(appDTO.getSessionKey())) {
            protocalOptParams.put("session", appDTO.getSessionKey());
        }
        if (StringUtils.isNotBlank(appDTO.getTargetAppKey())) {
            protocalOptParams.put("target_app_key", appDTO.getTargetAppKey());
        }
        if (StringUtils.isNotBlank(appDTO.getCustomerId())) {
            protocalOptParams.put("customerId", appDTO.getCustomerId());
        }

        // 4. 计算签名 (基于系统参数 + 请求体内容)
        String sign = signTopRequestWithBody(protocalMustParams, protocalOptParams, jstRequest.getParams(),
                appDTO.getAppSecret(), protocalOptParams.get("sign_method"));
        protocalMustParams.put("sign", sign);

        // 5. 构建完整URL
        String fullUrl = buildFullUrl(appDTO.getApiUrl(), protocalMustParams, protocalOptParams,null);

        // 构建表单数据
        FormBody.Builder formBuilder = new FormBody.Builder(StandardCharsets.UTF_8);
        for (Entry<String, String> entry : jstRequest.getParams().entrySet()) {
            if (StringUtils.isNotEmpty(entry.getKey()) && StringUtils.isNotEmpty(entry.getValue())) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        log.info("淘宝奇门fullUrl: {}", fullUrl);
        // 构建请求体
        RequestBody body = formBuilder.build();
        String jsonStr = executePostWithRetryTaoBao(fullUrl, body,"json");
        log.info("淘宝奇门获响应: {}", jsonStr);
        QimenCustomResponse response = new QimenCustomResponse();
        response.setGopResponseBody(jsonStr);

        return response;
    }

    /**
     * 基于系统参数和请求体内容计算签名
     * 严格遵循淘宝签名算法
     */
    private String signTopRequestWithBody(Map<String, String> protocalMustParams,
                                          Map<String, String> protocalOptParams,
                                          Map<String, String> paramsTeMp,
                                          String appSecret,
                                          String signMethod) throws Exception {

        // 1. 合并所有系统参数
        TreeMap<String, String> params = new TreeMap<>();
        params.putAll(protocalMustParams);
        params.putAll(protocalOptParams);
        params.putAll(paramsTeMp);

        // 2. 构建待签名字符串
        StringBuilder sb = new StringBuilder(appSecret); // MD5签名时secret放在开头

        // 按字母顺序拼接所有参数
        for (Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isNotEmpty(value)) {
                sb.append(key).append(value);
            }
        }

        // 3. 拼接请求体内容 (确保使用原始字符串，不进行额外处理)
//        sb.append(apiBody);
        sb.append(appSecret); // MD5签名时secret也放在结尾

        log.debug("待签名字符串: {}", sb.toString());

        // 4. 生成签名
        if (SIGN_METHOD_HMAC.equals(signMethod)) {
            return byte2hex(encryptHMAC(sb.toString(), appSecret)).toUpperCase();
        } else {
            return byte2hex(encryptMD5(sb.toString())).toUpperCase();
        }
    }

    /**
     * 构建完整URL (包含所有查询参数)
     */
    private String buildFullUrl(String baseUrl, Map<String, String> mustParams, Map<String, String> optParams,Map<String, String> busParams) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder(baseUrl);

        // 检查是否已有查询参数
        boolean hasQuery = baseUrl.contains("?");

        // 添加必需参数
        for (Entry<String, String> entry : mustParams.entrySet()) {
            if (StringUtils.isEmpty(entry.getValue())) continue;

            if (!hasQuery) {
                url.append("?");
                hasQuery = true;
            } else {
                url.append("&");
            }
            url.append(URLEncoder.encode(entry.getKey(), CHARSET_UTF8))
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), CHARSET_UTF8));
        }

        // 添加可选参数
        for (Entry<String, String> entry : optParams.entrySet()) {
            if (StringUtils.isEmpty(entry.getValue())) continue;

            url.append("&")
                    .append(URLEncoder.encode(entry.getKey(), CHARSET_UTF8))
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), CHARSET_UTF8));
        }
        // 添加可选参数
        if (MapUtils.isNotEmpty(busParams)) {
            for (Entry<String, String> entry : busParams.entrySet()) {
                if (StringUtils.isEmpty(entry.getValue())) continue;

                url.append("&")
                        .append(URLEncoder.encode(entry.getKey(), CHARSET_UTF8))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), CHARSET_UTF8));
            }
        }


        return url.toString();
    }

    /**
     * 发送POST请求 (带重试机制)
     */
    private String executePostWithRetryTaoBao(String url, RequestBody requestBody, String format) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                return sendRequest(url, requestBody, format);
            } catch (IOException e) {
                lastException = e;
                log.warn("请求失败，第 {} 次重试。URL: {}", (i + 1), url);
                log.warn("请求体: {}", requestBody.toString());

                if (i < MAX_RETRIES - 1) {
                    try {
                        Thread.sleep(1000 * (i + 1));
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new IOException("重试被中断", ie);
                    }
                }
            }
        }

        throw new IOException("重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    /**
     * 发送HTTP请求
     */
    private String sendRequest(String url, RequestBody requestBody, String format) throws IOException {
        // 设置正确的Content-Type (始终为JSON)
        String contentType = "application/json;charset=utf-8";
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("User-Agent", "top-sdk-java")
                .addHeader("Content-Type", contentType);

        // 添加Accept-Encoding头，支持gzip压缩
//        requestBuilder.addHeader("Accept-Encoding", "gzip");

        Request request = requestBuilder.build();

        log.debug("发送请求到: {}", url);
        log.debug("请求头: {}", request.headers());
        log.debug("请求体: {}", requestBody);

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorMsg = response.body() != null ? response.body().string() : "";
                log.error("请求失败，HTTP状态码: {}，响应内容: {}", response.code(), errorMsg);
                throw new IOException("HTTP " + response.code() + ": " + response.message() +
                        (StringUtils.isNotEmpty(errorMsg) ? " - " + errorMsg : ""));
            }

            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return "";
            }

            String responseStr = responseBody.string();
            log.debug("响应内容: {}", responseStr);

            return responseStr;
        }
    }

    // 以下是签名相关工具方法

    /**
     * 对字节流进行HMAC_MD5摘要。
     */
    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
    }

    /**
     * 对字符串采用UTF-8编码后，用MD5进行摘要。
     */
    private static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 对字节流进行MD5摘要。
     */
    private static byte[] encryptMD5(byte[] data) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
    }

    /**
     * 把字节流转换为十六进制表示方式。
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }

    // 保留原始方法，但建议弃用
    public QimenCustomResponse execute(QimenCustomRequest jstRequest, QimenCustomAppClientDTO appDTO) throws Exception {
        log.warn("警告: execute() 方法已弃用，请使用 executeTaoBao() 方法");
        return executeTaoBao(jstRequest, appDTO);
    }

    /**
     * 检查参数 (保持原有逻辑)
     */
    private void checkParams(QimenCustomRequest qmRequest, QimenCustomAppClientDTO appDTO) throws Exception {
        if (qmRequest == null) {
            throw new AppRuntimeException("QimenRequest is null.");
        }
        if (appDTO == null) {
            throw new AppRuntimeException("QimenAppClientDTO is null.");
        }

        if (StringUtils.isBlank(appDTO.getApiUrl())) {
            throw new AppRuntimeException("奇门 apiUrl is null.");
        }
        if (StringUtils.isBlank(appDTO.getAppKey())) {
            throw new AppRuntimeException("奇门 appKey is null.");
        }
        if (StringUtils.isBlank(qmRequest.getMethod())) {
            throw new AppRuntimeException("奇门 method is null.");
        }
    }
}