package com.eshop.config;

import okhttp3.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OkHttpTest {
    private MockWebServer mockWebServer;

    @Resource
    private OkHttpClient client;

    @BeforeEach
    void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
//        client = new OkHttpConfig().okHttpClient();
    }

    @Test
    void testGetRequest() throws Exception {
        // 模拟响应
        mockWebServer.enqueue(new MockResponse()
                .setBody("{\"status\":\"OK\"}")
                .addHeader("Content-Type", "application/json"));

        Request request = new Request.Builder()
                .url(mockWebServer.url("/api/data"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(200, response.code());
            assertTrue(response.body().string().contains("OK"));
        }
    }

    @Test
    void testPostWithTimeout() {
        mockWebServer.enqueue(new MockResponse()
                .setBodyDelay(2, TimeUnit.SECONDS) // 模拟延迟
                .setBody("{}"));

        Request request = new Request.Builder()
                .url(mockWebServer.url("/slow-api"))
                .post(RequestBody.create("", MediaType.get("text/plain")))
                .build();

        assertThrows(SocketTimeoutException.class, () -> {
            client.newCall(request).execute();
        });
    }

    @Test
    void testRetryMechanism() {
        // 首次返回500错误，第二次成功
        mockWebServer.enqueue(new MockResponse().setResponseCode(500));
        mockWebServer.enqueue(new MockResponse().setBody("OK"));

        Request request = new Request.Builder()
                .url(mockWebServer.url("/retry-test"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            assertEquals(200, response.code());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void teardown() throws IOException {
        mockWebServer.shutdown();
    }
}
