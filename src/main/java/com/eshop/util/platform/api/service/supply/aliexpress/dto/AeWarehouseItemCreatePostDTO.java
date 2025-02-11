package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:17
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseItemCreatePostDTO {
    //        request.addApiParameter("systemType", "wms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("warehouseCode", "warehouseCode");
    private String warehouseCode;
    //        request.addApiParameter("requestTime", "12312312431");
    private String requestTime;
    //        request.addApiParameter("requestId", "asdfasdf123");
    private String requestId;
    //        request.addApiParameter("scItems", "scItems");
    private String scItems;
}
