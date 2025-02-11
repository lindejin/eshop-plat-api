package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:54
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsSellerModifiedShipmentDTO {
    //request.addApiParameter("sub_trade_order_list", "[{\"send_type\":\"part\",\"shipment_list\":[{\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\"},{\"tracking_web_site\":\"http://ems.com\",\"logistics_no\":\"LV87654321CN\",\"service_name\":\"EMS\"}],\"sub_trade_order_index\":\"1\"}]");
    //request.addApiParameter("old_logistics_no", "LV87654321CN");
    //request.addApiParameter("trade_order_id", "888887777766");
    //request.addApiParameter("old_service_name", "EMS");
    private String sub_trade_order_list;
    private String old_logistics_no;
    private String trade_order_id;
    private String old_service_name;
}
