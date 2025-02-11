package com.eshop.util.platform.api.client.temu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class TemuHttp {

    @Resource
    private RestTemplate restTemplate;

    /**
     * post请求  发送json数据
     */
    public  String postForJson(String url, String json) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(json, headers);
        String body = restTemplate.postForEntity(url, formEntity, String.class).getBody();
        return body;
    }
}
