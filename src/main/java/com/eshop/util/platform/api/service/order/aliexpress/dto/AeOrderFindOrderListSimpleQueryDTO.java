package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:23
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderFindOrderListSimpleQueryDTO {
    //request.addApiParameter("param1", "{\"order_status\":\"PLACE_ORDER_SUCCESS\",\"create_date_end\":\"2015-07-10 00:00:00\",\"create_date_start\":\"2015-07-09 00:00:00\",\"page\":\"1\",\"order_status_list\":[\"PLACE_ORDER_SUCCESS\",\"WAIT_SELLER_SEND_GOODS\"],\"page_size\":\"20\"}");
    private String param1;
}
