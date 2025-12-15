package com.eshop.util.platform.api.client.cainiao;

import com.alibaba.fastjson.JSON;
import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoAppClientDTO;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoRequest;
import com.eshop.util.platform.api.client.cainiao.response.CainiaoResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;

@Slf4j
@Service
public class CainiaoTokenClient {


    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    private static final String CHARSET = "utf-8";

    public CainiaoResponse execute(CainiaoRequest request, CainiaoAppClientDTO appDTO) throws Exception {
        //授权参数校验
        checkParams(request, appDTO);

        String oauthUrl = appDTO.getOauthUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessCode = appDTO.getAccessCode();

        String urlPath = request.getUrlPath();

        String baseUrl = oauthUrl + urlPath;

        String apiUrl = buildAccessTokenUrl(baseUrl, appKey, appSecret, accessCode);
        log.info("菜鸟请求: {}", apiUrl);
        // 执行请求
        String responseStr = executeGetWithRetry(apiUrl);
        log.info("菜鸟响应: {}", responseStr);

        CainiaoResponse response = new CainiaoResponse();
        response.setGopResponseBody(responseStr);
        return response;
    }


    public static String buildAccessTokenUrl(String baseUrl, String appKey, String appSecret, String accessCode) {
        // 生成签名
        String sign = generateSign(accessCode, appKey, appSecret);

        // 使用HttpUrl.Builder分开添加参数
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();

        // 分开添加每个参数
        urlBuilder.addQueryParameter("accessCode", accessCode);
        urlBuilder.addQueryParameter("isvAppKey", appKey);
        urlBuilder.addQueryParameter("sign", sign);

        // 构建完整URL
        String url = urlBuilder.build().toString();

        return urlBuilder.build().toString();
    }

    /**
     * GET 请求 (带重试机制)
     */
    private String executeGetWithRetry(String url) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                Request.Builder requestBuilder = new Request.Builder().url(url).get();
                Request request = requestBuilder.build();
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        String msg = response.body() != null ? response.body().string() : "";
                        String exceptionMsg = "HTTP " + response.code() + ": " + response.message();
                        if (msg != null && !msg.isEmpty()) {
                            exceptionMsg += ", Response: " + msg;
                        }
                        throw new IOException(exceptionMsg);
                    }
                    return response.body() != null ? JSON.parseObject(response.body().string()).toJSONString() : "";
                }
            } catch (IOException e) {
                lastException = e;
                log.warn("请求API失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

                // 如果不是最后一次，等待后重试
                if (i < MAX_RETRIES - 1) {
                    try {
                        Thread.sleep(1000 * (i + 1)); // 递增等待: 1s, 2s, 3s
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new IOException("重试被中断", ie);
                    }
                }
            }
        }

        throw new IOException("请求API重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    /**
     * 检查参数
     */
    private void checkParams(CainiaoRequest request, CainiaoAppClientDTO appDTO) {
        if (request == null) {
            throw new AppRuntimeException("菜鸟 request is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("菜鸟 AppClientDTO is null.");
        }

        String oauthUrl = appDTO.getOauthUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(oauthUrl)) {
            throw new AppRuntimeException("菜鸟 oauthUrl 不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("菜鸟 appKey 不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("菜鸟 appSecret 不能为空");
        }
    }

    /**
     * 生成签名
     * 签名规则：md5(accessCode + "," + appKey + "," + appSecret)
     *
     * @param accessCode 授权码
     * @param appKey     应用Key
     * @param appSecret  应用密钥
     * @return MD5签名的十六进制字符串
     */
    public static String generateSign(String accessCode, String appKey, String appSecret) {
        String content = accessCode + "," + appKey + "," + appSecret;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(content.getBytes("UTF-8"));
            return bytesToHex(digest);
        } catch (Exception e) {
            throw new RuntimeException("生成签名失败", e);
        }
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * 生成授权code 获取地址
     *
     * @param baseUrl
     * @param appKey
     * @param extInfo
     * @param redirectUrl
     * @return
     */
    public static String buildAuthorizationUrl(String baseUrl, String appKey, String extInfo, String redirectUrl) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();

        // 添加必需的isvAppKey参数
        urlBuilder.addQueryParameter("isvAppKey", appKey);

        // 添加可选的ext参数 (如果提供)
        if (extInfo != null && !extInfo.isEmpty()) {
            urlBuilder.addQueryParameter("ext", extInfo);
        }

        // 添加重定向URL
        urlBuilder.addQueryParameter("redirectUrl", redirectUrl);

        return urlBuilder.build().toString();
    }
}
