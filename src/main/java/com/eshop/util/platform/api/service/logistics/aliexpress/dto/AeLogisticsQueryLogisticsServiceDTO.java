package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:22
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsQueryLogisticsServiceDTO {
    //request.addApiParameter("interface_request", "{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"sub_order_list\":[{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"locale\":\"zh_CN\",\"order_id\":\"8001498863155804\",\"goods_weight\":\"0.1\"},{\"goods_length\":\"1\",\"goods_height\":\"1\",\"goods_width\":\"1\",\"locale\":\"zh_CN\",\"order_id\":\"8001498863155804\",\"goods_weight\":\"0.1\"}],\"locale\":\"zh_CN\",\"order_id\":\"8001498863145804\",\"goods_weight\":\"0.1\"}");
    private String interface_request;
}
