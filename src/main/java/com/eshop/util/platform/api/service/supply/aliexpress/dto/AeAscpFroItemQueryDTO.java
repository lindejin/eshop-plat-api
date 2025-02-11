package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpFroItemQueryDTO {
    //        request.addApiParameter("fulfillment_reverse_order_item_query", "{\"biz_type\":\"123\",\"fulfillment_order_no\":\"123\"}");
    private String fulfillment_reverse_order_item_query;
}
