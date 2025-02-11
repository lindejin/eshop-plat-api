package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:11
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseAddressGetDTO {
    //        request.addApiParameter("systemType", "wms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("warehouseCode", "warehouseCode");
    private String warehouseCode;
    //        request.addApiParameter("locale", "en");
    private String locale;
    //        request.addApiParameter("addressType", "reverse");
    private String addressType;
}
