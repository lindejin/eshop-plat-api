package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:43
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsGetOnlineLogisticsInfoDTO {
   //request.addApiParameter("logistics_order_code", "LP00038357949881");
    //request.addApiParameter("china_logistics_id", "SF0000000000");
    //request.addApiParameter("international_logistics_id", "LC051733827CN");
    //request.addApiParameter("logistics_status", "CLOSED");
    //request.addApiParameter("gmt_create_end_str", "2016-06-27 18:15:00");
    //request.addApiParameter("page_size", "10");
    //request.addApiParameter("query_express_order", "false");
    //request.addApiParameter("current_page", "1");
    //request.addApiParameter("order_id", "60015640573917");
    //request.addApiParameter("gmt_create_start_str", "2016-06-27 18:20:00");
    //request.addApiParameter("logistics_order_id", "12424222");
    private String logistics_order_code;
    private String china_logistics_id;
    private String international_logistics_id;
    private String logistics_status;
    private String gmt_create_end_str;
    private String page_size;
    private String query_express_order;
    private String current_page;
    private String order_id;
    private String gmt_create_start_str;
    private String logistics_order_id;
}
