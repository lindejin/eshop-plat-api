package com.eshop.util.platform.api.client.temu;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Getter
@Setter
public class TemuRequest {

    /**
     * 请求接口 API接口名，形如：bg.*
     */
    private String type;

    /**
     * API版本，默认为V1，无要求不传此参数
     */
    private String version;

    /**
     * 请求返回的数据格式，可选参数固定为JSON
     */
    private String dataType;

    /**
     * 请求参数
     */
    private Map<String, Object> mapParams;
    private JSONObject jsonParams;
    private MultiValueMap<String, Object> muMapParams;
}
