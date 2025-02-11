package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:27
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpFfoQueryDTO {
    //        request.addApiParameter("fulfillment_forward_order_query", "{\"customer_order_number_list\":[\"123\",\"123\"],\"biz_type\":\"123\",\"page_index\":\"1\",\"fulfillment_order_no\":\"123\",\"page_size\":\"20\"}");
    private String fulfillment_forward_order_query;
}
