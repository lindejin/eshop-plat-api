package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetReqDTO {

    //参数接口	参数类型	是否必填	说明
    //settlementType	INTEGER	否	结算类型 0-非vmi 1-vmi
    private Integer settlementType;
    //skcExtCode	LIST	否	货号列表
    private List<String> skcExtCode;
    //productSkcIdList	LIST	否	skcId列表
    private List<Long> productSkcIdList;
    //urgencyType	INTEGER	否	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //subWarehouseId	INTEGER	否	收货子仓
    private Long subWarehouseId;
    //isCustomProduct	BOOLEAN	否	是否为定制品
    private Boolean isCustomProduct;
    //pageSize	INTEGER	是	每页记录数不能为空
    private Integer pageSize;
    //purchaseStockType	INTEGER	否	备货类型 0-普通备货 1-jit备货
    private Integer purchaseStockType;
    //inventoryRegion	LIST	否	DOMESTIC(1, "国内备货"), OVERSEAS(2, "海外备货"), BOUNDED_WAREHOUSE(3, "保税仓备货"),
    private List<Integer> inventoryRegion;
    //isJit	BOOLEAN	否	是否是jit，true:jit
    private Boolean isJit;
    //pageNo	INTEGER	是	页号， 从1开始
    private Integer pageNo;
    //isFirstOrder	BOOLEAN	否	是否首单
    private Boolean isFirstOrder;
    //subPurchaseOrderSnList	LIST	否	子采购单号列表
    private List<String> subPurchaseOrderSnList;
}
