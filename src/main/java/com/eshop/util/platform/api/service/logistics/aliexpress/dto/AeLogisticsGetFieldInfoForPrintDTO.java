package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:37
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsGetFieldInfoForPrintDTO {
    //request.addApiParameter("international_logistics_id", "UR837927903YP");
    //request.addApiParameter("id", "3000001");
    private String international_logistics_id;
    private String id;
}
