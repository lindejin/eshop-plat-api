package com.eshop.util.platform.api.client.douyin;

import com.alibaba.fastjson.JSON;
import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.client.douyin.request.DouyinRequest;
import com.eshop.util.platform.api.client.douyin.response.DouyinResponse;
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
public class DouyinTokenClient {

    @Autowired
    private OkHttpClient client;

    private final static int MAX_RETRIES = 3;


    /**
     * 聚水潭请求统一入口
     */
    public DouyinResponse execute(DouyinRequest jstRequest, DouyinAppClientDTO appDTO) throws Exception {
        checkParams(jstRequest, appDTO);

        String apiUrl = appDTO.getApiUrl();

        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String method = jstRequest.getMethod();
        String urlPath = jstRequest.getUrlPath();
        String version = jstRequest.getVersion();

        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;
        String paramJson = jstRequest.getParamJson();
        //公共参数
        Map<String, String> params = new HashMap<>();
        params.put("method", method);
        params.put("app_key", appKey);
        params.put("param_json",paramJson);
        params.put("timestamp", timestamp+"");
        params.put("v", version);
        params.put("sign_method", "md5");

        //md5加密签名
        String sign = DouyinSignUtil.sign(appKey, appSecret, method, timestamp+"", jstRequest.getParamJsonNot(), "2");
        params.put("sign", sign);
        System.out.println("sign:"+sign);

        log.info("douyin请求参数: {}", JSON.toJSONString(params));
        // 构建表单请求体
        FormBody.Builder formBuilder = new FormBody.Builder();

        // 添加所有参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
            formBuilder.add(entry.getKey(), entry.getValue());
        }
        // 构建请求体
        RequestBody body = formBuilder.build();

        String jsonStr = executePostWithRetry(apiUrl + urlPath, body);
        log.info("douyin响应: {}", jsonStr);

        DouyinResponse response = new DouyinResponse();
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
    private void checkParams(DouyinRequest jstRequest, DouyinAppClientDTO appDTO) throws Exception {
        if (jstRequest == null) {
            throw new AppRuntimeException("DouyinRequest is null.");

        }
        if (appDTO == null) {
            throw new AppRuntimeException("DouyinAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();

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

        if (StringUtils.isBlank(method)) {
            throw new AppRuntimeException("jushuitan method is null.");
        }
    }
}
