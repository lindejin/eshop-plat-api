package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseCalculateFeeGetDTO {
    //        request.addApiParameter("warehouseCode", "1");
    private String warehouseCode;
    //        request.addApiParameter("height", "1");
    private String height;
    //        request.addApiParameter("goodsOwnerId", "1");
    private String goodsOwnerId;
    //        request.addApiParameter("zipcode", "1");
    private String zipcode;
    //        request.addApiParameter("country", "1");
    private String country;
    //        request.addApiParameter("shippingMethod", "1");
    private String shippingMethod;
    //        request.addApiParameter("systemType", "1");
    private String systemType;
    //        request.addApiParameter("length", "1");
    private String length;
    //        request.addApiParameter("width", "1");
    private String width;
    //        request.addApiParameter("warehouseCustomerId", "1");
    private String warehouseCustomerId;
    //        request.addApiParameter("weight", "1");
    private String weight;
}
