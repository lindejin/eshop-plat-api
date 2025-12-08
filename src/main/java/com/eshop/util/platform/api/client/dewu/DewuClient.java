package com.eshop.util.platform.api.client.dewu;

import com.alibaba.fastjson.JSON;
import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.client.dewu.request.DewuRequest;
import com.eshop.util.platform.api.client.dewu.response.DewuResponse;
import com.eshop.util.platform.api.client.dewu.util.JsonUtil;
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
public class DewuClient {

    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    /**
     * 得物请求统一入口
     */
    public DewuResponse execute(DewuRequest request, DewuAppClientDTO appDTO) throws Exception {
        checkParams(request, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessToken = appDTO.getAccessToken();

        String method = request.getMethod();

        // 构建请求参数
        Map<String, Object> params = buildRequestParams(request, appKey);
        // 如果是ISV，需要添加access_token
        if (StringUtils.isNotBlank(accessToken)) {
            params.put("access_token", accessToken);
        }
        // 生成签名
        String sign = DewuSignUtil.createNewSign(params, appSecret);
        params.put("sign", sign);


        log.info("得物请求参数: {}", JSON.toJSONString(params));

        // 构建JSON请求体
        String  jsonParam = JsonUtil.obj2String(params);
        byte[] data = jsonParam.getBytes();
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, data);
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
    private Map<String, Object> buildRequestParams(DewuRequest request, String appKey) {
        Map<String, Object> params = new HashMap<>(request.getParams());
        long timestamp = System.currentTimeMillis();

        params.put("app_key", appKey);
        params.put("timestamp", timestamp + "");

        return params;
    }

    /**
     * POST 请求 (带重试机制)
     */
    private String executePostWithRetry(String url, RequestBody body) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                Request.Builder requestBuilder = (new Request.Builder()).url(url).post(body);
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

        throw new IOException("请求API重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
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
            throw new AppRuntimeException("得物 apiUrl不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("得物appKey不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("得物appSecret不能为空");
        }
    }
}