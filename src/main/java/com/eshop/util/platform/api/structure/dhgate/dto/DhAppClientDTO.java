package com.eshop.util.platform.api.structure.dhgate.dto;

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
public class DhAppClientDTO {

    private String url;
    private String codeUrl;
    private String tokenUrl;

    private String appKey;
    private String appSecret;

    private String accessToken;
    private String refreshToken;


    /**
     * api接口地址
     */
    public final static String DH_API_URL = "http://api.dhgate.com/dop/router";
    /**
     * 获取Authorization Code 地址
     */
    public final static String CODE_URL = "https://secure.dhgate.com/dop/oauth2/authorize";
    /**
     * Authorization Code获取Access Token 地址
     */
    public final static String TOKEN_URL = "https://secure.dhgate.com/dop/oauth2/access_token";


    public String getUrl() {
        return DH_API_URL;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodeUrl() {
        return CODE_URL;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getTokenUrl() {
        return TOKEN_URL;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }
}
