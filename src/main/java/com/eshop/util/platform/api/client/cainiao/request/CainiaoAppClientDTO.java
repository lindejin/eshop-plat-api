package com.eshop.util.platform.api.client.cainiao.request;

@lombok.Getter
@lombok.Setter
public class CainiaoAppClientDTO {

    /**
     * 第三方使用Cainiao开放平台服务的调用地址
     */
    private String apiUrl;


    /**
     * 授权地址
     */
    private String oauthUrl;

    /**
     * 第三方使用Cainiao开放平台的appId（同appKey，下同）
     */
    private String appKey;

    /**
     * 第三方使用Cainiao开放平台的appSecret
     */
    private String appSecret;

    /**
     * accessToken
     * 通过code获取的accessToken(无需授权的接口不需要此参数，该字段不参与sign签名运算)
     */
    private String accessToken;

    /**
     * 授权时使用的 鉴权code
     */
    private String accessCode;
}
