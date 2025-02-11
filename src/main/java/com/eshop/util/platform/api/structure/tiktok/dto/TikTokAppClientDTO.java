package com.eshop.util.platform.api.structure.tiktok.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/13 15:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class TikTokAppClientDTO {

    private String url;
    private String codeUrl;
    private String tokenUrl;

    private String appKey;
    private String serviceId;
    private String appSecret;

    private String accessToken;
    private String refreshToken;
    //授权域名
    public static final String DOMAIN_NAME = "https://auth.tiktok-shops.com";
    //生成服务授权URL
    public static final String AUTHORIZE_URL = "/open/authorize";
    //获取access_token URl
    public static final String GET_ACCESS_TOKEN_URL = DOMAIN_NAME + "/api/v2/token/get";
    //刷新Token  URL
    public static final String REFRESH_TOKEN_URL = DOMAIN_NAME + "/api/v2/token/refresh";
    //获取授权店铺信息URL
    public static final String GET_AUTHORIZED_SHOP_INFO_URL = "/api/shop/get_authorized_shop";


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }
}
