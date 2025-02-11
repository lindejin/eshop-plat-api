package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:14
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAidcPickupCostEstimateDTO {
    //        request.addApiParameter("param0", "{\"estimated_volume\":\"0.01\",\"channel_user_id\":\"123\",\"biz_type\":\"5110000\",\"estimated_weight\":\"0.01\",\"city_code\":\"330300\",\"estimated_box_number\":\"1\",\"estimated_pickup_time\":\"2024-04-10\",\"order_type\":\"1\",\"related_order_number_list\":[\"[\\\"PO123876534\\\"]\",\"[\\\"PO123876534\\\"]\"]}");
    private String param0;
}
