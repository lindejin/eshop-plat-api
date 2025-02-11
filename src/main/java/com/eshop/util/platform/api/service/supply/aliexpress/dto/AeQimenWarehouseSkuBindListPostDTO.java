package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:02
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseSkuBindListPostDTO {
    //        request.addApiParameter("systemType", "systemType");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "warehouseCustomerId");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
    private String goodsOwnerId;
    //        request.addApiParameter("skuBindList", "skuBindList");
    private String skuBindList;
}
