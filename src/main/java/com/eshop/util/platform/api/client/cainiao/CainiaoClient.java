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
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class CainiaoClient {

    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    private static final String CHARSET = "utf-8";

    /**
     * 菜鸟请求统一入口
     */
    public CainiaoResponse execute(CainiaoRequest request, CainiaoAppClientDTO appDTO) throws Exception {
        checkParams(request, appDTO);

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessToken = appDTO.getAccessToken();

        // 构建请求参数
        Map<String, String> params = buildRequestParams(request, accessToken, appSecret);

        log.info("菜鸟请求参数: {}", JSON.toJSONString(params));

        // 构建表单请求体
        FormBody.Builder formBuilder = new FormBody.Builder();

        // 添加所有参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formBuilder.add(entry.getKey(), entry.getValue());
        }
        // 构建请求体
        RequestBody body = formBuilder.build();
        // 执行请求
        String responseStr = executePostWithRetry(apiUrl, body);
        log.info("菜鸟响应: {}", responseStr);

        CainiaoResponse response = new CainiaoResponse();
        response.setGopResponseBody(responseStr);
        return response;
    }

    /**
     * 构建请求参数
     */
    private Map<String, String> buildRequestParams(CainiaoRequest request, String accessToken, String appSecret) {
        // 生成签名
        String digest = CainiaoSignUtil.doSign(request.getRequestContent(), CHARSET, appSecret);

        Map<String, String> params = new HashMap<>();
        //公共参数
        //名称	类型	是否必须	描述
        //msg_type	String	true	消息类型
        params.put("msg_type", request.getMsgType());
        //logistic_provider_id	String	true	来源CP编号(资源code)
        params.put("logistic_provider_id", accessToken);
        //data_digest	String	true	请求签名
        params.put("data_digest", digest);
        //to_code	String	false	目的方编码（可选，如不填使用该msg_type默认目的方）
        //logistics_interface	String	true	请求报文内容
        params.put("logistics_interface", request.getRequestContent());

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
                    return response.body() != null ? JSON.parseObject(response.body().string()).toJSONString() : "";
                }
            } catch (IOException e) {
                lastException = e;
                log.warn("请求菜鸟API失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

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

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();

        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("菜鸟 apiUrl 不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("菜鸟 appKey 不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("菜鸟 appSecret 不能为空");
        }
    }
}