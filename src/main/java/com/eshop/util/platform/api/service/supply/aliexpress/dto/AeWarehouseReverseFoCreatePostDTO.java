package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:30
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeWarehouseReverseFoCreatePostDTO {
    //        request.addApiParameter("systemType", "wms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "123");
    private String goodsOwnerId;
    //        request.addApiParameter("aeTradeOrderId", "aeTradeOrderId");
    private String aeTradeOrderId;
    //        request.addApiParameter("shopName", "123");
    private String shopName;
    //        request.addApiParameter("outBizId", "outBizId");
    private String outBizId;
    //        request.addApiParameter("warehouseCode", "warehouseCode");
    private String warehouseCode;
    //        request.addApiParameter("senderParam", "senderParam");
    private String senderParam;
    //        request.addApiParameter("receiverParam", "receiverParam");
    private String receiverParam;
    //        request.addApiParameter("itemList", "itemList");
    private String itemList;
    //        request.addApiParameter("logisticParam", "logisticParam");
    private String logisticParam;
    //        request.addApiParameter("extendParam", "extendParam");
    private String extendParam;
}
