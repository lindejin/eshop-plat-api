package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 16:25
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderGetSolutionOrderListDTO {

//request.addApiParameter("create_date_end", "2017-10-12 12:12:12");
    private String create_date_end;
//request.addApiParameter("create_date_start", "2017-10-12 12:12:12");
    private String create_date_start;
//request.addApiParameter("modified_date_start", "2017-10-12 12:12:12");
    private String modified_date_start;
//request.addApiParameter("order_status_list", "SELLER_PART_SEND_GOODS");
    private String order_status_list;
//request.addApiParameter("buyer_login_id", "test_id");
    private String buyer_login_id;
//request.addApiParameter("page_size", "20");
    private String page_size;
//request.addApiParameter("modified_date_end", "2017-10-12 12:12:12");
    private String modified_date_end;
//request.addApiParameter("current_page", "1");
    private String current_page;
//request.addApiParameter("order_status", "SELLER_PART_SEND_GOODS");
    private String order_status;
}
