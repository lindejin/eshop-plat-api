package com.eshop.util.platform.api.client.douyin.request;

import com.alibaba.fastjson.JSONObject;

@lombok.Getter
@lombok.Setter
public class DouyinRequest {

    /**
     * API协议版本号，目前使用2.0
     */
    private String version;

    /**
     * API接口名称
     */
    private String method;

    private String urlPath;

    /**
     * 请求参数
     */
    private String paramJson;

    /**
     * 请求参数
     * 取消了小数点
     */
    private String paramJsonNot;
}
