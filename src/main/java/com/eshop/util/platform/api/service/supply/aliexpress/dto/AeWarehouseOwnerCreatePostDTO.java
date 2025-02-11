package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:49
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseOwnerCreatePostDTO {

    //        request.addApiParameter("systemType", "wms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("shopName", "shop123");
    private String shopName;
    //        request.addApiParameter("method", "sign");
    private String method;
    //        request.addApiParameter("requestTime", "12312412412");
    private String requestTime;
    //        request.addApiParameter("requestId", "fghwei23");
    private String requestId;

}
