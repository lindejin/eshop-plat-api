package com.eshop.util.platform.api.client.jd;

import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.client.jd.response.JdLogisticsResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

@Slf4j
@Service
public class JdLogisticsTokenClient {

    private static final String HEX_CHARACTERS = "0123456789ABCDEF";

    private static final int MAX_RETRIES = 3;

    @Autowired
    private OkHttpClient client;

    public JdLogisticsResponse tokenRefresh(String refreshToken, String oauthUrl, JdLogisticsAppClientDTO appDTO) throws Exception {
        String appKey = appDTO.getAppKey();
        String appSecret = appDTO.getAppSecret();
        String accessToken = appDTO.getAccessToken();

        // 1. 生成东八区时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String timestamp = sdf.format(new Date());

        // 2. 构建参数
        Map<String, String> params = new TreeMap<>();
        params.put("app_key", appKey);
        params.put("refresh_token", refreshToken);
        params.put("timestamp", timestamp);
        params.put("timezone", "8"); // 东八区

        // 3. 生成签名
        String content = appSecret + "app_key" + appKey + "refresh_token" + refreshToken + "timestamp" + timestamp + appSecret;
        String sign = sign(content.getBytes(java.nio.charset.StandardCharsets.UTF_8));

        params.put("sign", sign);

        // 4. 使用HttpUrl.Builder构建规范URL
        String baseUrl = oauthUrl;
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + "/oauth/refresh").newBuilder();

        // 添加查询参数（自动处理编码）
        for (Map.Entry<String, String> param : params.entrySet()) {
            urlBuilder.addQueryParameter(param.getKey(), param.getValue());
        }

        String url = urlBuilder.build().toString();

        log.info("京东物流请求参数 apiUrl: {} ", url);
        // 5. 发送请求

        String responseStr = executeGetWithRetry(url);

        log.info("京东物流获得响应: {}", responseStr);
        JdLogisticsResponse response = new JdLogisticsResponse();
        response.setGopResponseBody(responseStr);
        return response;

    }

    /**
     * get请求刷新token
     */
    private String executeGetWithRetry(String url) throws IOException {
        IOException lastException = null;

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                // 获取时区偏移量

                Request request = new Request.Builder()
                        .url(url)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        String msg = response.body() != null ? response.body().string() : "";
                        String exceptionMsg = "HTTP " + response.code() + ": " + response.message();
                        if (!msg.isEmpty()) {
                            exceptionMsg += ", Response: " + msg;
                        }
                        throw new IOException(exceptionMsg);
                    }

                    // 注意：response.body().string()只能调用一次，需要保存结果
                    return response.body() != null ? response.body().string() : "";
                }
            } catch (IOException e) {
                lastException = e;
                log.warn("请求失败, 第 {} 次重试, URL: {}", (i + 1), url, e);

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

        throw new IOException("请求重试 " + MAX_RETRIES + " 次后仍然失败", lastException);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(HEX_CHARACTERS.charAt((b >>> 4) & 0x0F));
            stringBuilder.append(HEX_CHARACTERS.charAt(b & 0x0F));
        }
        return stringBuilder.toString();
    }

    private static String sign(byte[] data) throws java.security.GeneralSecurityException {
        return bytesToHex(java.security.MessageDigest.getInstance("md5").digest(data));
    }
}
