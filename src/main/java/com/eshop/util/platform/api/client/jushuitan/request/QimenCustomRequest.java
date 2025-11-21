package com.eshop.util.platform.api.client.jushuitan.request;

import java.util.Map;

@lombok.Setter
@lombok.Getter
public class QimenCustomRequest {

    /**
     * API名称（如："jushuitan.order.list.query"）
     * 具体API接口名称，例：taobao.item.seller.get
     */
    private String method;

    /**
     * 返回内容响应格式。不传默认为xml格式，可选值：xml，json。
     */
    private String format;

    /**
     * API协议版本，可选值：2.0
     */
    private String version;

    /**
     * 签名的摘要算法，可选值为：hmac，md5，hmac-sha256。
     */
    private String signMethod;

    /**
     * 请求参数
     */
    private Map<String, String> params;
}
