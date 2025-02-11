package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:05
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseSubscribeGetDTO {
    //        request.addApiParameter("shopId", "123");
    private String shopId;
    //        request.addApiParameter("warehouseCustomerId", "123");
    private String warehouseCustomerId;
    //        request.addApiParameter("warehouseCode", "123");
    private String warehouseCode;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
}
