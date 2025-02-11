package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:00
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseSalesGetDTO {
    //        request.addApiParameter("shopId", "123");
    private String shopId;
    //        request.addApiParameter("warehouseCustomerId", "123");
    private String warehouseCustomerId;
    //        request.addApiParameter("warehouseCode", "\u4ED3code");
    private String warehouseCode;
    //        request.addApiParameter("goodsOwnerId", "3321");
    private String goodsOwnerId;
    //        request.addApiParameter("startTime", "2021.06.01 12:13:15");
    private String startTime;
    //        request.addApiParameter("endTime", "2021.06.10 12:13:15");
    private String endTime;
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
}
