package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:33
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpInventoryLogQueryDTO {
    //        request.addApiParameter("warehouse_inventory_log_query_dto", "{\"store_code\":\"demo\",\"gmt_create_start\":\"1630425600000\",\"biz_type\":\"123\",\"page_index\":\"1\",\"biz_activity_type\":\"demo\",\"biz_trade_id\":\"demo\",\"inventory_type\":\"1\",\"operation_order_id\":\"demo\",\"gmt_create_end\":\"1630425600000\",\"page_size\":\"20\",\"sc_item_id\":\"123\"}");
    private String warehouse_inventory_log_query_dto;
}
