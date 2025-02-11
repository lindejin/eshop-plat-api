package com.eshop.util.platform.api.client.shopee;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author ldj
 * @date 2024/3/12 13:50
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class ShopeeRequest {

    /**
     * 请求类型 1.get 2.post-json 3.post-file 4 post-map_json
     */
    private Integer mediaType;

    /**
     * 加密类型 1.公共 2.店铺 3.商户
     */
    private Integer secretType;

    //请求接口
    private String apiName;


    /**
     * 请求参数
     */
    private Map<String, Object> mapParams;
    private JSONObject jsonParams;
    private MultiValueMap<String, Object> muMapParams;
}
