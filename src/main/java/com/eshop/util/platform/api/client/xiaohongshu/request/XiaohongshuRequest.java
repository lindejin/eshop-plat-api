package com.eshop.util.platform.api.client.xiaohongshu.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 *
 */
@Getter
@Setter
public class XiaohongshuRequest {

    /**
     * API协议版本号，目前使用2.0
     */
    private String version;

    /**
     * API接口名称
     */
    private String method;

    /**
     * 请求参数
     */
    private Map<String, String> params;
}
