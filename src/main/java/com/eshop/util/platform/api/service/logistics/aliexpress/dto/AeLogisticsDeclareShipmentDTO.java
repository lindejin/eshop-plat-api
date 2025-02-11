package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:48
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsDeclareShipmentDTO {
    //request.addApiParameter("param_aeop_seller_shipment_sub_trade_order_request", "{\"sub_trade_order_list\":[{\"send_type\":\"part\",\"ioss\":\"ioss\",\"shipment_list\":[{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"},{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"}],\"sub_trade_order_index\":\"12345601\"},{\"send_type\":\"part\",\"ioss\":\"ioss\",\"shipment_list\":[{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"},{\"actual_carrier\":\"EMS\",\"tracking_web_site\":\"https://www.sf-express.com/cn/sc/dynamic_function/waybill/#search/bill-number/SF7551234567890\",\"logistics_no\":\"SF7551234567890\",\"service_name\":\"CAINIAO_STANDARD\",\"package_type\":\"\u5305\u88F9\u7C7B\u578B\"}],\"sub_trade_order_index\":\"12345601\"}],\"trade_order_id\":\"123456\"}");
    private String param_aeop_seller_shipment_sub_trade_order_request;

}
