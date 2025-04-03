package com.eshop.config;

import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.BufferedHttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpLoggingInterceptor {
    private static final Logger log = LoggerFactory.getLogger("HTTP-Logger");

    public HttpRequestInterceptor requestInterceptor() {
        return (request, entityDetails, context) -> {
            if (entityDetails instanceof HttpEntity) {
                HttpEntity entity = (HttpEntity) entityDetails;
                try {
                    // 缓存实体并替换
                    HttpEntity bufferedEntity = new BufferedHttpEntity(entity);
                    ((ClassicHttpRequest) request).setEntity(bufferedEntity);
                    String body = EntityUtils.toString(bufferedEntity, StandardCharsets.UTF_8);
                    log.debug("Request Body: {}", body);
                } catch (IOException e) {
                    log.error("Failed to read request entity", e);
                }
            }
        };
    }
    private String truncateBody(String body) {
        return body.length() > 200 ? body.substring(0, 200) : body;
    }

    public HttpResponseInterceptor responseInterceptor() {
        return (response, entityDetails, context) -> {
            if (entityDetails instanceof HttpEntity) {
                HttpEntity entity = (HttpEntity) entityDetails;
                // 3. 处理响应实体
                HttpEntity bufferedEntity = new BufferedHttpEntity(entity);
                ((ClassicHttpResponse) response).setEntity(bufferedEntity);
                String body = EntityUtils.toString(bufferedEntity, StandardCharsets.UTF_8);
                log.debug("Response Body: {}", body);
            }
        };
    }
}