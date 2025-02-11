package com.eshop.util.platform.api.client.dhgate;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 10:48
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class DhRequest {
    //请求接口
    private String apiName;
    //请求接口版本呢
    private String apiVersion;
    //请求参数
    private JSONObject businessDTO;
}
