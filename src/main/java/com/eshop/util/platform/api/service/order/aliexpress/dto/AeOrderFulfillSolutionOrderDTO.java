package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 16:32
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderFulfillSolutionOrderDTO {

    //        request.addApiParameter("service_name", "EMS");
    private String service_name;
    //        request.addApiParameter("tracking_website", "www.17track.com");
    private String tracking_website;
    //        request.addApiParameter("out_ref", "888877779999");
    private String out_ref;
    //        request.addApiParameter("send_type", "part");
    private String send_type;
    //        request.addApiParameter("description", "memo");
    private String description;
    //        request.addApiParameter("logistics_no", "LA88887777CN");
    private String logistics_no;
}
