package com.eshop.util.platform.api.client.jushuitan.request;

@lombok.Getter
@lombok.Setter
public class QimenCustomAppClientDTO {

    /**
     * 可替换为您的应用的appKey
     * 聚水潭注释 奇门的appKey
     */
    private String appKey;

    /**
     * 可替换为您的应用的appSecret
     * 聚水潭注释 奇门的密钥
     */
    private String appSecret;

    /**
     * 必须替换为授权得到的真实有效sessionKey
     * 聚水潭注释 非必填参数 可以不传
     */
    private String sessionKey;

    /**
     * 用户需要透传的targetAppkey，主要用于安全验签，
     * 验签的目的是防止黑客恶意调用你的服务，确保服务发起来源来自奇门云网关。
     */
    private String targetAppKey;

    /**
     * 奇门调用地址
     * 聚水潭注释 请求容器URL
     */
    private String apiUrl;
}
