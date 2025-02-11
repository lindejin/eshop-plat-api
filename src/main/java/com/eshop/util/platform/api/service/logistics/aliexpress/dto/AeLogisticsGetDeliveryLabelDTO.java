package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsGetDeliveryLabelDTO {
    //request.addApiParameter("international_logistics_id", "RE700150389CN");
    private String international_logistics_id;
}
