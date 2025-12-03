package com.eshop.util.platform.api.client.xiaohongshu;


import com.alibaba.fastjson.JSON;
import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuRequest;
import com.eshop.util.platform.api.client.xiaohongshu.response.XiaohongshuResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 小红书API客户端 - 用于获取访问令牌
 */
@Slf4j
@Service
public class XiaohongshuTokenClient {

    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * 获取小红书访问令牌
     */
    public XiaohongshuResponse getAccessToken(String code, XiaohongshuRequest request, XiaohongshuAppClientDTO appDTO) throws Exception {
        checkParams(code, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appId = appDTO.getAppId();
        String appSecret = appDTO.getAppSecret();

        // 构建请求参数
        Map<String, String> params = buildRequestParams(code, request, appId);

        // 生成签名
        String sign = XiaohongshuSignUtil.generateSign(params, appSecret);
        params.put("sign", sign);

        log.info("小红书请求参数: {}", JSON.toJSONString(params));

        // 构建JSON请求体
        RequestBody body = RequestBody.create(JSON.toJSONString(params), JSON_MEDIA_TYPE);

        // 执行请求
        String responseStr = executePostWithRetry(apiUrl, body);
        log.info("小红书获响应: {}", responseStr);

        // 解析响应
//        XiaohongshuResponse<XiaohongshuResponse> response = JSON.parseObject(
//                responseStr,
//                new com.alibaba.fastjson.TypeReference<XiaohongshuResponse<XiaohongshuResponse>>() {}
//        );
//
//        if (response == null || !response.isSuccess() || response.getErrorCode() != 0) {
//            throw new AppRuntimeException("获取小红书accessToken失败, 错误码: " + response.getErrorCode() +
//                    ", 错误信息: " + response.getErrorMessage());
//        }
        XiaohongshuResponse response = new XiaohongshuResponse();
        response.setGopResponseBody(responseStr);
        return response;
    }

    /**
     * 构建请求参数
     */
    private Map<String, String> buildRequestParams(String code, XiaohongshuRequest request, String appId) {
        Map<String, String> params = new HashMap<>();
        long timestamp = System.currentTimeMillis();

        params.put("appId", appId);
        params.put("version", request.getVersion());
        params.put("timestamp", String.valueOf(timestamp));
        params.put("method", request.getMethod());
        params.put("code", code);

        return params;
    }

    /**
     * POST 请求 (带重试机制)
     */
    private String executePostWithRetry(String url, RequestBody body) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .addHeader("Content-Type", "application/json")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("HTTP " + response.code() + ": " + response.message());
                    }

                    return response.body() != null ? response.body().string() : "";
                }
            } catch (IOException e) {
                lastException = e;
                log.warn("请求小红书API失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

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

        throw new IOException("请求小红书API重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    /**
     * 检查参数
     */
    private void checkParams(String code, XiaohongshuAppClientDTO appDTO) throws Exception {
        if (code == null) {
            throw new AppRuntimeException("Xiaohongshu code is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("XiaohongshuAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();
        String appId = appDTO.getAppId();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("小红书apiUrl不能为空");
        }

        if (StringUtils.isBlank(appId)) {
            throw new AppRuntimeException("小红书appId不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("小红书appSecret不能为空");
        }

        if (StringUtils.isBlank(code)) {
            throw new AppRuntimeException("授权code不能为空");
        }
    }


    /**
     * 刷新小红书访问令牌
     */
    public XiaohongshuResponse refreshToken(String refreshToken, XiaohongshuRequest request, XiaohongshuAppClientDTO appDTO) throws Exception {
        checkParamsByRefresh(refreshToken, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appId = appDTO.getAppId();
        String appSecret = appDTO.getAppSecret();

        // 构建请求参数
        Map<String, String> params = buildRequestParamsByRefresh(refreshToken, request, appId);

        // 生成签名
        String sign = XiaohongshuSignUtil.generateSign(params, appSecret);
        params.put("sign", sign);

        log.info("小红书请求参数: {}", JSON.toJSONString(params));

        // 构建JSON请求体
        RequestBody body = RequestBody.create(JSON.toJSONString(params), JSON_MEDIA_TYPE);

        // 执行请求
        String responseStr = executePostWithRetry(apiUrl, body);
        log.info("小红书获响应: {}", responseStr);
        XiaohongshuResponse response = new XiaohongshuResponse();
        response.setGopResponseBody(responseStr);
        return response;
    }

    /**
     * 检查参数 - 刷新令牌
     */
    private void checkParamsByRefresh(String refreshToken, XiaohongshuAppClientDTO appDTO) throws Exception {
        if (refreshToken == null) {
            throw new AppRuntimeException("Xiaohongshu refreshToken is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("XiaohongshuAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();
        String appId = appDTO.getAppId();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("小红书 apiUrl 不能为空");
        }

        if (StringUtils.isBlank(appId)) {
            throw new AppRuntimeException("小红书 appId 不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("小红书 appSecret 不能为空");
        }

        if (StringUtils.isBlank(refreshToken)) {
            throw new AppRuntimeException("小红书 refreshToken 不能为空");
        }
    }

    /**
     * 构建请求参数
     */
    private Map<String, String> buildRequestParamsByRefresh(String refreshToken, XiaohongshuRequest request, String appId) {
        Map<String, String> params = new HashMap<>();
        long timestamp = System.currentTimeMillis();

        params.put("appId", appId);
        params.put("version", request.getVersion());
        params.put("timestamp", String.valueOf(timestamp));
        params.put("method", request.getMethod());
        params.put("refreshToken", refreshToken);

        return params;
    }

}