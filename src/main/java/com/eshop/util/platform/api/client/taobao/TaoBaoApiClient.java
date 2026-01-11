package com.eshop.util.platform.api.client.taobao;

import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoRequest;
import com.eshop.util.platform.api.client.taobao.response.TaoBaoResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 奇门自定义接口调用客户端（jushuitan）
 */
@Slf4j
@Service
public class TaoBaoApiClient {

    @Autowired
    private OkHttpClient client;

    private final static int MAX_RETRIES = 3;


    /**
     * 奇门请求统一入口 - 聚水潭
     */
    public TaoBaoResponse execute(TaoBaoRequest jstRequest, TaoBaoAppClientDTO appDTO) throws Exception {
        checkParams(jstRequest, appDTO);

        String apiUrl = appDTO.getApiUrl();

        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String sessionKey = appDTO.getSessionKey();
        String targetAppKey = appDTO.getTargetAppKey();
        String customerId = appDTO.getCustomerId();

        String method = jstRequest.getMethod();
        //这里默认 2.0
        String version = jstRequest.getVersion();
        //这里默认json
        String format = jstRequest.getFormat();
        //这里默认md5
        String signMethod = jstRequest.getSignMethod();

        //时间戳，格式为yyyy-MM-dd HH:mm:ss，时区为GMT+8，例如：2016-01-01 12:00:00。淘宝API服务端允许客户端请求最大时间误差为10分钟。
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Map<String, String> param = jstRequest.getParams();
        // 添加API系统参数
        param.put("method", method);

        param.put("app_key", appKey);
        param.put("session", sessionKey != null ? sessionKey : ""); // 非必填
        param.put("timestamp", timestamp);

        param.put("format", format);
        param.put("v", version);
        param.put("sign_method", signMethod);

        if (StringUtils.isNotBlank(targetAppKey)) {
            // 申请奇门自定义场景的target_app_key
            param.put("target_app_key", targetAppKey);
        }
        if (StringUtils.isNotBlank(customerId)) {
            // 申请奇门自定义场景的customer_id
            param.put("customer_id", customerId);
        }


        // 签名参数
        param.put("sign", signTopRequest(param, appSecret, SIGN_METHOD_HMAC));

        // 构建表单数据
        FormBody.Builder formBuilder = new FormBody.Builder(StandardCharsets.UTF_8);
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (StringUtils.isNotEmpty(entry.getKey()) && StringUtils.isNotEmpty(entry.getValue())) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        // 构建请求体
        RequestBody body = formBuilder.build();
        String jsonStr = executePostWithRetry(apiUrl, body);
        TaoBaoResponse response = new TaoBaoResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }

    /**
     * POST 请求 发送 JSON 数据（简单重试机制）
     */
    private String executePostWithRetry(String url, RequestBody body) throws IOException {
        IOException lastException = null;

        // 简单循环重试
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
//                .addHeader("Host", url.getHost())
                        .addHeader("Accept", "text/xml,text/javascript")
                        .addHeader("User-Agent", "top-sdk-java")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET_UTF8)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("HTTP " + response.code() + ": " + response.message());
                    }

                    return response.body() != null ? response.body().string() : "";
                }

            } catch (IOException e) {
                lastException = e;
                System.out.println("请求失败，第 " + (i + 1) + " 次重试");

                // 如果不是最后一次，等待后重试
                if (i < MAX_RETRIES - 1) {
                    try {
                        Thread.sleep(1000 * (i + 1)); // 简单的递增等待：1秒、2秒、3秒
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new IOException("重试被中断", ie);
                    }
                }
            }
        }

        // 所有重试都失败
        throw new IOException("重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }


    /**
     * 检查参数
     */
    private void checkParams(TaoBaoRequest qmRequest, TaoBaoAppClientDTO appDTO) throws Exception {
        if (qmRequest == null) {
            throw new AppRuntimeException("QimenRequest is null.");

        }
        if (appDTO == null) {
            throw new AppRuntimeException("QimenAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();

        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String sessionKey = appDTO.getSessionKey();

        String method = qmRequest.getMethod();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("奇门 apiUrl is null.");
        }
        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("奇门 appKey is null.");
        }
//        if (StringUtils.isBlank(appSecret)) {
//            throw new AppRuntimeException("奇门 appSecret is null.");
//        }
//        if (StringUtils.isBlank(sessionKey)) {
//            throw new AppRuntimeException("奇门 sessionKey is null.");
//        }
        if (StringUtils.isBlank(method)) {
            throw new AppRuntimeException("奇门 method is null.");
        }
    }

    private static final String SIGN_METHOD_MD5 = "md5";
    private static final String SIGN_METHOD_HMAC = "hmac";
    private static final String CHARSET_UTF8 = "utf-8";
    private static final String CONTENT_ENCODING_GZIP = "gzip";

    /**
     * 对TOP请求进行签名。
     */
    private static String signTopRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        if (SIGN_METHOD_MD5.equals(signMethod)) {
            query.append(secret);
        }
        for (String key : keys) {
            String value = params.get(key);
            if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
                query.append(key).append(value);
            }
        }

        // 第三步：使用MD5/HMAC加密
        byte[] bytes;
        if (SIGN_METHOD_HMAC.equals(signMethod)) {
            bytes = encryptHMAC(query.toString(), secret);
        } else {
            query.append(secret);
            bytes = encryptMD5(query.toString());
        }

        // 第四步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    /**
     * 对字节流进行HMAC_MD5摘要。
     */
    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 对字符串采用UTF-8编码后，用MD5进行摘要。
     */
    private static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes(CHARSET_UTF8));
    }

    /**
     * 对字节流进行MD5摘要。
     */
    private static byte[] encryptMD5(byte[] data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 把字节流转换为十六进制表示方式。
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
