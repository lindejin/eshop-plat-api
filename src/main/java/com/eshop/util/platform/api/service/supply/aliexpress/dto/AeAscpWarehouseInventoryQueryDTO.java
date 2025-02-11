package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:31
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpWarehouseInventoryQueryDTO {
    //        request.addApiParameter("warehouse_inventory_query_dto", "{\"store_code\":\"AET0001\",\"biz_type\":\"288000\",\"page_index\":\"1\",\"sc_item_id_list\":[\"[1234,345,456]\",\"[1234,345,456]\"],\"inventory_type\":\"1\",\"page_size\":\"20\"}");
    private String warehouse_inventory_query_dto;
}
