package com.eshop.util.platform.api.client.xiaohongshu.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 小红书应用客户端配置
 */
@Getter
@Setter
public class XiaohongshuAppClientDTO {

    /**
     * 第三方使用小红书开放平台服务的调用地址
     */
    private String apiUrl;
    /**
     * 第三方使用小红书开放平台的appId（同appKey，下同）
     */
    private String appId;
    /**
     * 第三方使用小红书开放平台的appSecret
     */
    private String appSecret;

    /**
     * accessToken
     * 通过code获取的accessToken(无需授权的接口不需要此参数，该字段不参与sign签名运算)
     */
    private String accessToken;

}
