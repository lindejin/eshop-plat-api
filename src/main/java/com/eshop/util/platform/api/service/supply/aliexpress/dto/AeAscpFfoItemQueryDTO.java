package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpFfoItemQueryDTO {
    //        request.addApiParameter("fulfillment_forward_order_item_query", "{\"biz_type\":\"123\",\"fulfillment_order_no\":\"123\"}");
    private String fulfillment_forward_order_item_query;
}
