package com.eshop.util.platform.api.structure.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 11:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAppClientDTO {

    private String url;

    private String appKey;
    private String appSecret;

    private String accessToken;
    private String refreshToken;

    public String getUrl() {
        return "https://api-sg.aliexpress.com";
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
