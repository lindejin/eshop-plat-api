package com.eshop.util.platform.api.client.jushuitan.request;

import com.alibaba.fastjson.JSONObject;

@lombok.Setter
@lombok.Getter
public class JushuitanRequest {

    /**
     * 接口类型（如："/open/orders/single/query"）
     */
    private String method;

    /**
     * 字符编码（固定值：utf-8）
     */
    private String charset;

    /**
     * 版本号，固定传2
     */
    private String version;

    /**
     * 请求参数
     */
    private JSONObject jsonParams;
}
