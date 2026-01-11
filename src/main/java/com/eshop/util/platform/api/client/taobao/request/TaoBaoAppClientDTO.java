package com.eshop.util.platform.api.client.taobao.request;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:01
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoAppClientDTO {

    /**
     * 可替换为您的应用的appKey
     * 淘宝 appKey
     */
    private String appKey;

    /**
     * 可替换为您的应用的appSecret
     * 淘宝 密钥
     */
    private String appSecret;

    /**
     * 必须替换为授权得到的真实有效sessionKey
     * 淘宝token 非必填参数 可以不传
     */
    private String sessionKey;

    /**
     * 淘宝调用地址
     * 淘宝 请求容器URL
     */
    private String apiUrl;

    /*
        奇门参数
     */
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
}