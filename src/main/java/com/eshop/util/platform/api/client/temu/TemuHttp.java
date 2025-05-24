package com.eshop.util.platform.api.client.temu;

import okhttp3.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class TemuHttp {

    // 推荐重用 OkHttpClient 实例（线程安全）
    @Resource
    private OkHttpClient client;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * POST 请求 发送 JSON 数据
     */
    public String execute(String url, String json) throws IOException {
        // 构建请求体
        RequestBody body = RequestBody.create(json, JSON);

        // 构建请求
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Accept", "application/json")
                .build();

        // 执行请求
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // 获取响应体（自动处理 UTF-8 解码）
            return response.body() != null ? response.body().string() : "";
        }
    }
}
