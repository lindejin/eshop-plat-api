package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:07
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsOrderDeliveryInfoDTO {
    //request.addApiParameter("single_order_query", "{\"order_id\":\"3006413871042162\"}");
    private String single_order_query;
}
