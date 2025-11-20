package com.eshop.util.platform.api.client.jushuitan.request;

@lombok.Getter
@lombok.Setter
public class JushuitanAppClientDTO {
    /**
     * app_key 已创建成功的应用标志app_key，联系对接运营颁发
     */
    private String appKey;

    /**
     * app_secret 已创建成功的应用标志app_secret，联系对接运营颁发
     */
    private String appSecret;

    /**
     * 用户授权令牌access_token，卖家中心—授权管理获取即可，运营会颁发对应线上测试店铺token
     */
    private String accessToken;


    private String apiUrl;
}
