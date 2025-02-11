package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:52
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsSellerShipmentDTO {
    //  request.addApiParameter("sub_trade_order_list", "[{\"send_type\":\"part\",\"ioss\":\"XX1234567890\",\"sub_trade_order_index\":\"1\",\"shipment_list\":[{\"tracking_web_site\":\"www.baidu.com\",\"logistics_no\":\"LT123456789CN\",\"service_name\":\"CAINIAO_STANDARD\"},{\"tracking_web_site\":\"www.baidu.com\",\"logistics_no\":\"LT123456789CN\",\"service_name\":\"CAINIAO_STANDARD\"}]}]");
    //        request.addApiParameter("trade_order_id", "778824234234");
    private String sub_trade_order_list;
    private String trade_order_id;
}
