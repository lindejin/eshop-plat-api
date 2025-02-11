package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 15:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeQimenWarehouseInventoryGetDTO {
    //        request.addApiParameter("systemType", "oms");
    private String systemType;
    //        request.addApiParameter("warehouseCustomerId", "test");
    private String warehouseCustomerId;
    //        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
    private String goodsOwnerId;
    //        request.addApiParameter("warehouseCodeList", "[\"\u4ED3code1\", \"\u4ED3code2\", \"\u4ED3code3\"],");
    private String warehouseCodeList;
    //        request.addApiParameter("skuIdList", "[\"wms_sku_id1\", \"wms_sku_id2\", \"wms_sku_id3\"]");
    private String skuIdList;
    //        request.addApiParameter("pageSize", "10");
    private String pageSize;
    //        request.addApiParameter("pageNo", "1");
    private String pageNo;
}
