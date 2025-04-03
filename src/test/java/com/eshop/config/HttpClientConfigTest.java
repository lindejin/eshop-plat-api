package com.eshop.config;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
public class HttpClientConfigTest {

    @Resource
    private CloseableHttpClient httpClient;

    @Test
    void sendGetRequest() throws Exception {
        String url = "http://httpbin.org/get";
        String s = sendGetRequest(url);
        System.out.println(s);
    }
    public String sendGetRequest(String url) throws Exception {
        ClassicHttpRequest getReq = ClassicRequestBuilder.get(url)
                .addHeader("User-Agent", "HttpClient5")
                .build();

        String responseBody = httpClient.execute(getReq, response -> {
            if (response.getCode() >= 400) {
                throw new IOException("HTTP Error: " + response.getCode());
            }
            return EntityUtils.toString(response.getEntity());
        });
//        System.out.println(responseBody);
        return responseBody;
    }

    public String sendPostRequest(String url, String jsonBody) throws Exception {
        // 1. 构建请求（使用 ClassicRequestBuilder）
        ClassicHttpRequest postRequest = ClassicRequestBuilder.post(url)
                .setEntity(new StringEntity(jsonBody, ContentType.APPLICATION_JSON))
                .build();

        // 2. 发送请求并处理响应（自动资源管理）
        return httpClient.execute(postRequest, response -> {
            // 3. 状态码验证（支持 2xx 范围）
            if (response.getCode() >= HttpStatus.SC_OK && response.getCode() < HttpStatus.SC_MULTIPLE_CHOICES) {
                return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            } else {
                // 4. 自定义异常信息（含状态码和响应体）
                String errorBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                throw new RuntimeException(
                        "请求失败，状态码：" + response.getCode() + "，响应体：" + errorBody
                );
            }
        });
    }
}
