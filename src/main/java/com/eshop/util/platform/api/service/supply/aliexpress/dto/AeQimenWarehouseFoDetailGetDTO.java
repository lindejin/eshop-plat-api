package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:40
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseFoDetailGetDTO {
    //        request.addApiParameter("outBizId", "1");
    private String outBizId;
    //        request.addApiParameter("systemType", "1");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "1");
    private String warehouseCustomerId;
    //        request.addApiParameter("wmsOrderId", "1");
    private String wmsOrderId;
    //        request.addApiParameter("goodsOwnerId", "1");
    private String goodsOwnerId;
}
