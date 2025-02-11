package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:16
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsQueryTrackingDTO {
    //request.addApiParameter("logistics_no", "20100810142400000-0700");
    //request.addApiParameter("origin", "ESCROW");
    //request.addApiParameter("out_ref", "1160045240183009");
    //request.addApiParameter("service_name", "UPS");
    //request.addApiParameter("to_area", "DE");
    private String logistics_no;
    private String origin;
    private String out_ref;
    private String service_name;
    private String to_area;
}
