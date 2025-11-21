package com.eshop.util.platform.api.client.jushuitan;


import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanRequest;
import com.eshop.util.platform.api.client.jushuitan.response.JushuitanResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 奇门api接口调用通用客户端
 */
@Slf4j
@Service
public class JushuitanClient {


    @Autowired
    private OkHttpClient client;

    private final static int MAX_RETRIES = 3;


    /**
     * 聚水潭请求统一入口
     */
    public JushuitanResponse execute(JushuitanRequest jstRequest, JushuitanAppClientDTO appDTO) throws Exception {
        checkParams(jstRequest, appDTO);

        String apiUrl = appDTO.getApiUrl();

        String accessToken = appDTO.getAccessToken();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String method = jstRequest.getMethod();
        String version = jstRequest.getVersion();
        String charset = jstRequest.getCharset();

        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;


        Map<String, String> params = new HashMap<>();
        params.put("app_key", appKey);
        params.put("access_token", accessToken);
        params.put("timestamp", timestamp + "");
        params.put("charset", charset);
        params.put("version", version);
        params.put("biz", jstRequest.getJsonParams().toJSONString());

        //md5加密签名
        String sign = JushuitanSignUtil.generateSign(params, appSecret);
        params.put("sign", sign);

        // 构建表单请求体
        FormBody.Builder formBuilder = new FormBody.Builder();

        // 添加所有参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formBuilder.add(entry.getKey(), entry.getValue());
        }
        // 构建请求体
        RequestBody body = formBuilder.build();

        String jsonStr = executePostWithRetry(apiUrl + method, body);
        JushuitanResponse response = new JushuitanResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }

    /**
     * POST 请求 发送 JSON 数据（简单重试机制）
     */
    public String executePostWithRetry(String url, RequestBody body) throws IOException {
        IOException lastException = null;

        // 简单循环重试
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
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
    private void checkParams(JushuitanRequest jstRequest, JushuitanAppClientDTO appDTO) throws Exception {
        if (jstRequest == null) {
            throw new AppRuntimeException("JushuitanRequest is null.");

        }
        if (appDTO == null) {
            throw new AppRuntimeException("JushuitanAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();

        String accessToken = appDTO.getAccessToken();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String method = jstRequest.getMethod();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("jushuitan apiUrl is null.");
        }
        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("jushuitan appKey is null.");
        }
        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("jushuitan appSecret is null.");
        }
        if (StringUtils.isBlank(accessToken)) {
            throw new AppRuntimeException("jushuitan accessToken is null.");
        }
        if (StringUtils.isBlank(method)) {
            throw new AppRuntimeException("jushuitan method is null.");
        }
    }

}
