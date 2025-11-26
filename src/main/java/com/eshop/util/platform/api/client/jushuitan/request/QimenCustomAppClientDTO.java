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
     * 接口需要额外带上customer_id,传不同的customer_id来路由不同的商家链接
     * customer_id
     */
    private String customerId;

    /**
     * 奇门调用地址
     * 聚水潭注释 请求容器URL
     */
    private String apiUrl;


    /*
    名词解释
        appkey：调用方的appkey。

        targetAppkey：被调方，也就是服务提供方的appkey。

        授权：调用的许可，如果没有对调用方的appkey授权那么对方是不可以调用服务的。

        验签：为了防止接口被人乱掉用，需要在服务端做验签的逻辑，校验请求的合法性。
     */
}
