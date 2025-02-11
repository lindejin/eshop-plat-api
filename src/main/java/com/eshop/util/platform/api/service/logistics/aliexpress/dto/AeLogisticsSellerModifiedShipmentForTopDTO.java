package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:10
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsSellerModifiedShipmentForTopDTO {
    //    request.addApiParameter("tracking_website", "www.17track.com");
    //        request.addApiParameter("old_service_name", "EMS");
    //        request.addApiParameter("new_service_name", "EMS");
    //        request.addApiParameter("old_logistics_no", "LA111166611CN");
    //        request.addApiParameter("description", "memo");
    //        request.addApiParameter("new_logistics_no", "LA11111111CN");
    //        request.addApiParameter("send_type", "part");
    //        request.addApiParameter("out_ref", "60769040695804");
    //        request.addApiParameter("package_type", "consolidation");
    //        request.addApiParameter("actual_carrier", "tnt");
    //        request.addApiParameter("locale", "ae_ES");
    private String tracking_website;
    private String old_service_name;
    private String new_service_name;
    private String old_logistics_no;
    private String description;
    private String new_logistics_no;
    private String send_type;
    private String out_ref;
    private String package_type;
    private String actual_carrier;
    private String locale;
}
