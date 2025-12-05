package com.eshop.util.platform.api.client.jd;

import com.eshop.exception.AppRuntimeException;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsRequest;
import com.eshop.util.platform.api.client.jd.response.JdLogisticsResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 京东物流
 * api接口调用通用客户端
 */
@Slf4j
@Service
public class JdLogisticsClient {

    @Autowired
    private OkHttpClient client;

    private static final int MAX_RETRIES = 3;
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 京东物流请求统一入口
     */
    public JdLogisticsResponse execute(JdLogisticsRequest request, JdLogisticsAppClientDTO appDTO) throws Exception {
        checkParams(request, appDTO);

        String timestamp = DATE_TIME_FORMATTER.format(LocalDateTime.now());

        String baseUri = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessToken = appDTO.getAccessToken();

        String domain = request.getDomain();
        String version = request.getVersion();
        String method = request.getMethod();
        String urlPath = request.getUrlPath();
        String paramJson = request.getParamJson();

        String algorithm = "md5-salt";


        String content = String.join("", new String[]{
                appSecret,
                "access_token", accessToken,
                "app_key", appKey,
                "method", urlPath,
                "param_json", paramJson,
                "timestamp", timestamp,
                "v", version,
                appSecret});
        // 生成签名
        String sign = JdLogisticsSignUtil.sign(algorithm, content.getBytes(UTF_8), appSecret.getBytes(UTF_8));


        // 构建JSON请求体
        RequestBody body = RequestBody.create(paramJson, JSON_MEDIA_TYPE);

        // 构建URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUri + urlPath).newBuilder();
        urlBuilder.addQueryParameter("LOP-DN", domain);
        urlBuilder.addQueryParameter("app_key", appKey);
        urlBuilder.addQueryParameter("access_token", accessToken);
        urlBuilder.addQueryParameter("timestamp", timestamp);
        urlBuilder.addQueryParameter("v", version);
        urlBuilder.addQueryParameter("sign", sign);
        urlBuilder.addQueryParameter("algorithm", algorithm);

        // 生成最终URL
        String apiUrl = urlBuilder.build().toString();
        log.info("京东物流请求参数 apiUrl: {} ,paramJson:{}", apiUrl, paramJson);

        String responseStr = executePostWithRetry(apiUrl, body);
        log.info("京东物流获得响应: {}", responseStr);

        JdLogisticsResponse response = new JdLogisticsResponse();
        response.setGopResponseBody(responseStr);
        return response;
    }

    /**
     * POST 请求 (带重试机制)
     */
    private String executePostWithRetry(String url, RequestBody body) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                int offset = OffsetTime.now().getOffset().getTotalSeconds() / 3600;

                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
//                        .addHeader("Content-Type", "application/json")
                        .addHeader("lop-tz", String.valueOf(offset))
                        .addHeader("User-Agent", "lop-http/java")
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
                log.warn("请求京东物流API失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

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

        throw new IOException("请求京东物流API重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    /**
     * 检查参数
     */
    private void checkParams(JdLogisticsRequest request, JdLogisticsAppClientDTO appDTO) {
        if (request == null) {
            throw new AppRuntimeException("JdLogistics request is null.");
        }

        if (appDTO == null) {
            throw new AppRuntimeException("JdLogisticsAppClientDTO is null.");
        }

        String apiUrl = appDTO.getApiUrl();
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessToken = appDTO.getAccessToken();
        if (StringUtils.isBlank(apiUrl)) {
            throw new AppRuntimeException("京东物流apiUrl不能为空");
        }

        if (StringUtils.isBlank(appKey)) {
            throw new AppRuntimeException("京东物流appId不能为空");
        }

        if (StringUtils.isBlank(appSecret)) {
            throw new AppRuntimeException("京东物流appSecret不能为空");
        }

        if (StringUtils.isBlank(accessToken)) {
            throw new AppRuntimeException("京东物流accessToken不能为空");
        }
    }

    public static String httpBuildQuery(Map<String, String> query) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (!first) {
                stringBuilder.append("&");
            } else {
                first = false;
            }
            stringBuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), UTF_8.name()));
        }
        return stringBuilder.toString();
    }
}
