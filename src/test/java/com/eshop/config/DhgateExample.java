package com.eshop.config;

import okhttp3.*;

import java.io.IOException;

public class DhgateExample {
    public static void main(String[] args) {
        // 1. 创建OkHttp客户端实例（线程安全，建议全局复用）
        OkHttpClient client = new OkHttpClient();

        // 2. 构建请求URL并添加查询参数
        HttpUrl url = HttpUrl.parse("http://api.dhgate.com/dop/router").newBuilder()
                .addQueryParameter("access_token", "qssPvI2MWGzaPSAF7iOlOWT2n874PR7OUk1rbWhW")
                .addQueryParameter("method", "dh.album.img.delete")
                .addQueryParameter("timestamp", "1566564717143")
                .addQueryParameter("v", "2.0")
                .addQueryParameter("locale", "en_US")
                .build();

        // 3. 构建表单请求体（对应PHP的setPostFields）
        RequestBody formBody = new FormBody.Builder()
                .add("imgId", "ff8080814121374a01425b66ea3b3b73")
                .add("imgMd5", "d9fde376254d81706ecca81be2571316")
                .add("imgUrl", "albu_486897589_00")
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
