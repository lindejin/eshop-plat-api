package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:57
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseLogisticsGetDTO {
    //        request.addApiParameter("warehouseCustomerId", "123");
    private String warehouseCustomerId;
    //        request.addApiParameter("warehouseCode", "13");
    private String warehouseCode;
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
}
