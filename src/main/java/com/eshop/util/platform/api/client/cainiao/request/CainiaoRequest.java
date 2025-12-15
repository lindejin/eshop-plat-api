package com.eshop.util.platform.api.client.cainiao.request;

@lombok.Getter
@lombok.Setter
public class CainiaoRequest {

    /**
     * msg_type	String	true	消息类型
     * 例子
     * CLOUDPRINT_STANDARD_TEMPLATES 这里就是请求方法method
     * isv 通过 link 获取和使用标准面单
     */
    private String msgType;

    /**
     * 请求报文
     */
    private String requestContent;

    /**
     * 请求路径
     */
    private String urlPath;
}
