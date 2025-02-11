package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:46
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpRoItemQueryDTO {
    //        request.addApiParameter("return_order_item_query", "{\"return_order_no\":\"Ro123\",\"biz_type\":\"123\",\"page_index\":\"1\",\"page_size\":\"20\"}");
    private String return_order_item_query;
}
