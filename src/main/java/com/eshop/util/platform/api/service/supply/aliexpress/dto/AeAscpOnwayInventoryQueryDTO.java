package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:32
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpOnwayInventoryQueryDTO {
    //        request.addApiParameter("on_way_inventory_query_dto", "{\"outbound_store_code\":\"demo\",\"inbound_store_code\":\"demo\",\"biz_type\":\"123\",\"sc_item_id_list\":[\"demo\",\"demo\"],\"inventory_type\":\"1\"}");
    private String on_way_inventory_query_dto;
}
