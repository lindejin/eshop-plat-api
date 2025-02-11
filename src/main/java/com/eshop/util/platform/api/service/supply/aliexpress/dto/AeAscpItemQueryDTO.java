package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:36
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpItemQueryDTO {
    //        request.addApiParameter("sc_item_query", "{\"sc_item_code\":\"123\",\"channel_user_id\":\"1234\",\"biz_type\":\"123\",\"page_index\":\"1\",\"channel\":\"AE_GLOBAL\",\"whc_barcode\":\"123\",\"page_size\":\"20\",\"sc_item_id\":\"123\"}");
    private String sc_item_query;
}
