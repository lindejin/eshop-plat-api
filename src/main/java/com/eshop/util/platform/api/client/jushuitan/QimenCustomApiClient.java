package com.eshop.util.platform.api.client.jushuitan;

import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomRequest;
import com.eshop.util.platform.api.client.jushuitan.response.QimenCustomResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 奇门自定义接口调用客户端（jushuitan）
 */
@Slf4j
@Service
public class QimenCustomApiClient {

    @Autowired
    private OkHttpClient client;

    private final static int MAX_RETRIES = 3;


    /**
     * 奇门请求统一入口 - 聚水潭
     */
    public QimenCustomResponse execute(QimenCustomRequest jstRequest, QimenCustomAppClientDTO appDTO) throws Exception {
        checkParams(jstRequest, appDTO);

        String apiUrl = appDTO.getApiUrl();

        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String sessionKey = appDTO.getSessionKey();
        String targetAppKey = appDTO.getTargetAppKey();

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
        param.put("app_key", appKey);
        param.put("session", sessionKey != null ? sessionKey : ""); // 非必填
        param.put("timestamp", timestamp);

        param.put("format", format);
        param.put("v", version);
        param.put("sign_method", signMethod);

        param.put("method", method);

        // 申请奇门自定义场景的target_app_key
        param.put("target_app_key", targetAppKey);
        // 申请奇门自定义场景的customer_id
        param.put("customer_id", "");


        //md5加密签名
        String sign = QimenCustomSignUtil.createSign(param, appSecret);
        System.out.println("sign: " + sign);
        System.out.println("sign2: " + QimenCustomSignUtil2.createSign(param, appSecret));
        param.put("sign", sign);

        // 构建表单请求体
        FormBody.Builder formBuilder = new FormBody.Builder();

        // 添加所有参数
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getValue() != null) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }else {
                log.info(entry.getKey() + ":" + entry.getValue());
            }
        }
        // 构建请求体
        RequestBody body = formBuilder.build();

        String jsonStr = executePostWithRetry(apiUrl, body);
        QimenCustomResponse response = new QimenCustomResponse();
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
    private void checkParams(QimenCustomRequest qmRequest, QimenCustomAppClientDTO appDTO) throws Exception {
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
}
