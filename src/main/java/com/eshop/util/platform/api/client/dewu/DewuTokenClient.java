package com.eshop.util.platform.api.client.dewu;

import com.alibaba.fastjson.JSON;
import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.client.dewu.request.DewuRequest;
import com.eshop.util.platform.api.client.dewu.response.DewuResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DewuTokenClient {

    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * 得物请求统一入口
     */
    public DewuResponse getAccessToken(String code, DewuRequest request, DewuAppClientDTO appDTO) throws Exception {
        checkParams(request, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        String method = request.getMethod();

        // 构建请求参数
        Map<String, Object> params = buildRequestParams(code, appKey, appSecret);

        log.info("得物请求参数: {}", JSON.toJSONString(params));

        // 构建JSON请求体
        RequestBody body = RequestBody.create(JSON.toJSONString(params), JSON_MEDIA_TYPE);

        // 执行请求
        String responseStr = executePostWithRetry(apiUrl + method, body);
        log.info("得物响应: {}", responseStr);

        DewuResponse response = new DewuResponse();
        response.setResponseBody(responseStr);
        return response;
    }

    /**
     * 构建请求参数
     */
    private Map<String, Object> buildRequestParams(String code, String appKey, String appSecret) {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", appKey);
        params.put("client_secret", appSecret);
        params.put("authorization_code", code);
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
                log.warn("请求得物API失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

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

        throw new IOException("请求得物API重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    /**
     * 检查参数
     */
    private void checkParams(DewuRequest request, DewuAppClientDTO appDTO) {
        if (request == null) {
            throw new AppRuntimeException("得物 request is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("得物 AppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("得物apiUrl不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("得物appKey不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("得物appSecret不能为空");
        }
    }


    /**
     * 刷新小红书访问令牌
     */
    public DewuResponse refreshToken(String refreshToken, DewuRequest request, DewuAppClientDTO appDTO) throws Exception {
        checkParamsByRefresh(refreshToken, request, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        String method = request.getMethod();

        // 构建请求参数
        Map<String, Object> params = buildRequestParamsByRefresh(refreshToken, appKey, appSecret);

        log.info("得物 请求参数: {}", JSON.toJSONString(params));

        // 构建JSON请求体
        RequestBody body = RequestBody.create(JSON.toJSONString(params), JSON_MEDIA_TYPE);

        // 执行请求
        String responseStr = executePostWithRetry(apiUrl + method, body);
        log.info("得物 获响应: {}", responseStr);
        DewuResponse response = new DewuResponse();
        response.setResponseBody(responseStr);
        return response;
    }

    /**
     * 检查参数
     */
    private void checkParamsByRefresh(String refreshToken, DewuRequest request, DewuAppClientDTO appDTO) {
        if (request == null) {
            throw new AppRuntimeException("得物 request is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("得物 AppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("得物apiUrl不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("得物appKey不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("得物appSecret不能为空");
        }

        if (StringUtils.isBlank(refreshToken)) {
            throw new AppRuntimeException("得物refreshToken不能为空");
        }
    }


    /**
     * 构建请求参数
     */
    private Map<String, Object> buildRequestParamsByRefresh(String refreshToken, String appKey, String appSecret) {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", appKey);
        params.put("client_secret", appSecret);
        params.put("refresh_token", refreshToken);
        return params;
    }
}
