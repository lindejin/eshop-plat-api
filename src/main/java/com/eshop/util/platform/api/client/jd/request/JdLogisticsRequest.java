package com.eshop.util.platform.api.client.jd.request;

@lombok.Getter
@lombok.Setter
public class JdLogisticsRequest {

    /**
     * 不同对接方案下的API，取值不同，具体取值可查看【控制台-应用管理-管理-对接方案】列表中的“对接方案编码”
     */
    private String domain;

    /**
     * API协议版本号，目前使用2.0
     */
    private String version;

    /**
     * HTTP请求方法，目前开放平台接口只支持POST方法
     */
    private String method;

    /**
     * API接口请求路径
     * 接口调用地址，具体取值请看【接口文档-请求地址-调用路径（path）】
     */
    private String urlPath;

    /**
     * 请求签名算法，根据安全需求自行选择签名算法，如果不填默认使用MD5算法。目前开放平台支持如下算法（代码示例不支持SM3算法，如需SM3代码示例请与我们联系）1. md5-salt2. sm3-salt3. HMacSHA14. HMacSHA2565. HMacSHA5126. HMacMD5
     */
    private String algorithm;

    /**
     * 请求参数
     * 请求报文，根据接口文档组织请求报文
     */
    private String paramJson;
}
