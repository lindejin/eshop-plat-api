package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:03
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseSkuListInfoGetDTO {
    //        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
    private String goodsOwnerId;
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
    //        request.addApiParameter("skuIdList", "[\"wms_sku_id1\", \"wms_sku_id2\", \"wms_sku_id3\"]");
    private String skuIdList;
    //        request.addApiParameter("warehouseCode", "warehouseCode");
    private String warehouseCode;
    //        request.addApiParameter("pageSize", "20");
    private String pageSize;
    //        request.addApiParameter("pageNo", "1");
    private String pageNo;
}
