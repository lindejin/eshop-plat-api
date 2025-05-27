package com.eshop.api;


import com.eshop.config.http.OkHttpConfig;
import com.eshop.config.http.OkLogInterceptor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class TiktokDemo {
    private static final String ACCESS_TOKEN = "ROW_apI9RAAAAACNw5-WtMhKFuQwHtaCkAr9-OdDldhgi3a3RmW9g0LWS3cTrMfknDcLRIh0ze1XeRhK-UDPYaKRC2PLbcCN9d_qkn2490ymuiSKeIK8ReSGeyl5S5bL6FGEjtkyLhNW3EB5RLAwcSPeqI7CsZQRTcnJQKRKUsfMtCumPDPFhjltow";
    private static final String PATH = "/open_api/v1.3/user/info/";
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String ENV_GL = "https://us.vogocmerp.com/openapi_tiktok_business_api";
    /**
     * 构建带参数的完整请求 URL
     *
     * @param path   请求路径（如 "/api/v1/query"）
     * @param params URL 查询参数（键值对）
     * @return 完整的 OkHttp HttpUrl 对象
     * @throws IllegalArgumentException 如果 URL 格式无效
     */
    public static HttpUrl buildUrlWithParams(String path, Map<String, Object> params) {
        // 1. 构建基础 URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(ENV_GL + path)
                .newBuilder();

        // 2. 添加查询参数
        params.forEach((key, value) -> {
            try {
                String paramValue = (value instanceof String)
                        ? (String) value
                        : mapper.writeValueAsString(value);
                urlBuilder.addQueryParameter(key, paramValue);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("参数序列化失败: " + key, e);
            }
        });

        return urlBuilder.build();
    }
    /**
     * Send GET request
     *
     * @param jsonStr:Args in JSON format
     * @return Response in JSON format
     */
    private static String get(String jsonStr) throws IOException, URISyntaxException {

        Map<String, Object> map = mapper.readValue(jsonStr, Map.class);

        HttpUrl httpUrl = buildUrlWithParams(PATH, map);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new OkHttpConfig.LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .addHeader("Access-Token", ACCESS_TOKEN)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        // Args in JSON format
        String myArgs = String.format("{}");
        System.out.println(get(myArgs));
    }
}

