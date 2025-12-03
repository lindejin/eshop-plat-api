package com.eshop.util.platform.api.client.dewu.request;

import lombok.Data;

@Data
public class DewuAppClientDTO {
    private String apiUrl;      // API地址
    private String appKey;      // 应用key
    private String appSecret;   // 应用密钥
    private String accessToken; // 访问令牌（ISV必填）
}