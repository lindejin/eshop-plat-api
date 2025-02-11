package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:42
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsSellerShipmentForTopDTO {
    //request.addApiParameter("logistics_no", "LA88887777CN");
    private String logistics_no;
    //request.addApiParameter("description", "memo");
    private String description;
    //request.addApiParameter("send_type", "part");
    private String send_type;
    //request.addApiParameter("out_ref", "888877779999");
    private String out_ref;
    //request.addApiParameter("tracking_website", "www.17track.com");
    private String tracking_website;
    //request.addApiParameter("service_name", "EMS");
    private String service_name;
    //request.addApiParameter("package_type", "consolidation");
    private String package_type;
    //request.addApiParameter("actual_carrier", "tnt");
    private String actual_carrier;
    //request.addApiParameter("ioss", "XX1234567890");
    private String ioss;
    //request.addApiParameter("locale", "es_ES");
    private String locale;
}
