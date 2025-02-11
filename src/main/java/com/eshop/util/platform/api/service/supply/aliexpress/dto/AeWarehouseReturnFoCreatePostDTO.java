package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:24
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseReturnFoCreatePostDTO {
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "4px");
    private String warehouseCustomerId;
    //        request.addApiParameter("outBizId", "RWO123redsf2");
    private String outBizId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("warehouseCode", "warehouseCode");
    private String warehouseCode;
    //        request.addApiParameter("realExecuteTime", "123123");
    private String realExecuteTime;
    //        request.addApiParameter("pickingProvider", "pickingProvider");
    private String pickingProvider;
    //        request.addApiParameter("pickingOrderNumber", "pickingOrderNumber");
    private String pickingOrderNumber;
    //        request.addApiParameter("pickingOrderUrl", "url");
    private String pickingOrderUrl;
    //        request.addApiParameter("pickingCode", "123412");
    private String pickingCode;
    //        request.addApiParameter("contactPhone", "1231421");
    private String contactPhone;
    //        request.addApiParameter("contactName", "name");
    private String contactName;
    //        request.addApiParameter("method", "destory");
    private String method;
    //        request.addApiParameter("items", "items");
    private String items;
    //        request.addApiParameter("requestTime", "123214");
    private String requestTime;
    //        request.addApiParameter("requestId", "asdfafwe");
    private String requestId;
}
