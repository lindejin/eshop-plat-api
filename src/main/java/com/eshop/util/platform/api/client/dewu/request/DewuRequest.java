package com.eshop.util.platform.api.client.dewu.request;

import lombok.Data;

import java.util.Map;

@Data
public class DewuRequest {
    private String method;      // API方法名
    private Map<String, Object> params; // 请求参数
}