package com.eshop.config;

import okhttp3.*;

import java.io.IOException;

public class DhgateExample3 {
    public static void main(String[] args) {
        // 1. 创建OkHttp客户端实例（线程安全，建议全局复用）
        OkHttpClient client = new OkHttpClient();

        // 2. 构建请求URL并添加查询参数
        HttpUrl url = HttpUrl.parse("http://api.dhgate.com/dop/router").newBuilder()
                .addQueryParameter("access_token", "6PhB1QaQOJ2UgGjqCt00Qm2xofGydKickXtaokIs")
                .addQueryParameter("method", "dh.shipping.typelist")
                .addQueryParameter("timestamp", System.currentTimeMillis()+"")
                .addQueryParameter("v", "2.0")
                .addQueryParameter("locale", "en_US")
                .build();

        // 3. 构建表单请求体（对应PHP的setPostFields）
        RequestBody formBody = new FormBody.Builder()
                .add("data", "{\"time\":\"2025-05-13 01:00:00\",\"pageSize\":\"500\",\"pageNo\":\"2\"}\"")
                .build();

        // 4. 创建请求对象
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)  // 设置为POST方法
                .addHeader("cache-control", "no-cache")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            // 5. 处理响应
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 6. 获取并打印响应体
            System.out.println(response.body().string());
        } catch (IOException e) {
            // 7. 异常处理
            e.printStackTrace();
        }
    }
}
