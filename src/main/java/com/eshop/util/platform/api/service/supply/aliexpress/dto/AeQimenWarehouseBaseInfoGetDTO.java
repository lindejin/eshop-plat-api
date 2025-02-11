package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:33
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseBaseInfoGetDTO {
    //        request.addApiParameter("country", "123");
    private String country;
    //        request.addApiParameter("warehouseCustomerId", "123");
    private String warehouseCustomerId;
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
}
