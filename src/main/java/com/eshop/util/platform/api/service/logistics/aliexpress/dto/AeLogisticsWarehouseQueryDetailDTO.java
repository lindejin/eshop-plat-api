package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:02
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsWarehouseQueryDetailDTO {
    //        request.addApiParameter("consign_type", "DOMESTIC");
    //        request.addApiParameter("current_page", "1");
    //        request.addApiParameter("domestic_logistics_num", "CN123456789RU");
    //        request.addApiParameter("gmt_create_end_str", "2016-09-09 00:00:00");
    //        request.addApiParameter("gmt_create_start_str", "2016-09-09 00:00:00");
    //        request.addApiParameter("international_logistics_num", "CN98989898US");
    //        request.addApiParameter("logistics_status", "pickup_success");
    //        request.addApiParameter("page_size", "20");
    //        request.addApiParameter("trade_order_id", "8972343764328");
    //        request.addApiParameter("warehouse_carrier_service", "E_PACKET");
    private String consign_type;
    private String current_page;
    private String domestic_logistics_num;
    private String gmt_create_end_str;
    private String gmt_create_start_str;
    private String international_logistics_num;
    private String logistics_status;
    private String page_size;
    private String trade_order_id;
    private String warehouse_carrier_service;
}
