package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:38
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseFoCancelPostDTO {
    //request.addApiParameter("goodsOwnerId", "1");
    private String goodsOwnerId;
    //request.addApiParameter("systemType", "1");、
    private String systemType;
    //request.addApiParameter("warehouseCustomerId", "1");
    private String warehouseCustomerId;
    //request.addApiParameter("cancelReason", "1");
    private String cancelReason;
    //request.addApiParameter("wmsOrderId", "1");
    private String wmsOrderId;
}
