package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:38
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoItemQueryDTO {
    //        request.addApiParameter("purchase_order_item_query", "{\"channel_user_id\":\"1234\",\"biz_type\":\"123\",\"page_index\":\"1\",\"purchase_order_no\":\"PON123\",\"page_size\":\"20\"}");
    private String purchase_order_item_query;
}
