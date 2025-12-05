package com.eshop.util.platform.api.client.jd.request;

@lombok.Getter
@lombok.Setter
public class JdLogisticsAppClientDTO {

    /**
     * 第三方使用 京东物流 开放平台服务的调用地址
     * 物流开放平台调用域名，需要区分生产环境和预发环境，可查看【能力中心-对接方案-API文档-请求地址】确认。
     * 生产环境：https://api.jdl.com预发环境：https://uat-api.jdl.com
     */
    private String apiUrl;

    /**
     * 第三方使用 京东物流 开放平台的appId（同appKey，下同）
     * 应用的appKey，可从【控制台-应用管理-概览】中查看
     */
    private String appKey;

    /**
     * 第三方使用 京东物流 开放平台的appSecret
     * 应用的appSecret，可从【控制台-应用管理-概览】中查看
     */
    private String appSecret;

    /**
     * accessToken
     * 用户授权时获取的令牌，用户授权相关说明请查看https://cloud.jdl.com/#/devSupport/53392，合作伙伴应用计算签名时不需要拼接该参数
     */
    private String accessToken;

}
