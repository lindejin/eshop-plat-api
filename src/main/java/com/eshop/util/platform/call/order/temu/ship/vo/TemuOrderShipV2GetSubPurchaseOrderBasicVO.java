package com.eshop.util.platform.call.order.temu.ship.vo;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV2GetSubPurchaseOrderBasicVO {
    //supplierId	INTEGER	供应商id
    private Long supplierId;
    //isCustomProduct	BOOLEAN	是否为定制品
    private Boolean isCustomProduct;
    //productSkcPicture	STRING	货品图片
    private String productSkcPicture;
    //isFirst	BOOLEAN	是否首单
    private Boolean isFirst;
    //purchaseStockType	INTEGER	备货类型 0-普通备货 1-jit备货
    private Integer purchaseStockType;
    //isClothCategory	BOOLEAN	是否服饰类目
    private Boolean isClothCategory;
    //productSkcId	INTEGER	skcId
    private Long productSkcId;
    //settlementType	INTEGER	结算类型 0-非vmi 1-vmi
    private Integer settlementType;
    //skcExtCode	STRING	货号
    private String skcExtCode;
    //urgencyType	INTEGER	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //subWarehouseId	INTEGER	子仓id
    private Long subWarehouseId;
    //fragileTag	BOOLEAN	易碎品打标
    private Boolean fragileTag;
    //purchaseQuantity	INTEGER	下单数量
    private Integer purchaseQuantity;
    //subWarehouseName	STRING	子仓名称
    private String subWarehouseName;
    //subPurchaseOrderSn	STRING	采购子单号
    private String subPurchaseOrderSn;
    //purchaseTime	INTEGER	下单时间：毫秒
    private Long purchaseTime;
}
