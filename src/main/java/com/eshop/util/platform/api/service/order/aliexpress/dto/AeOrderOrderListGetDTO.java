package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:20
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderOrderListGetDTO {
    //request.addApiParameter("param_aeop_order_query", "{\"modified_date_start\":\"2017-10-12 12:12:12\",\"modified_date_end\":\"2017-10-12 12:12:12\",\"order_status\":\"SELLER_PART_SEND_GOODS\",\"create_date_end\":\"2017-10-12 12:12:12\",\"create_date_start\":\"2017-10-12 12:12:12\",\"buyer_login_id\":\"test\",\"current_page\":\"1\",\"order_status_list\":[\"SELLER_PART_SEND_GOODS\",\"SELLER_PART_SEND_GOODS\"],\"page_size\":\"20\"}");
    private String param_aeop_order_query;
}
