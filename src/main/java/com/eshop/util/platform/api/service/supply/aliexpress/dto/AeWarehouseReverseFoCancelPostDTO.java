package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:28
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseReverseFoCancelPostDTO {
    //        request.addApiParameter("systemType", "wms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("wmsOrderId", "wmsOrderId");
    private String wmsOrderId;
    //        request.addApiParameter("outBizId", "WH123");
    private String outBizId;
    //        request.addApiParameter("cancelReason", "cancelReason");
    private String cancelReason;
}
