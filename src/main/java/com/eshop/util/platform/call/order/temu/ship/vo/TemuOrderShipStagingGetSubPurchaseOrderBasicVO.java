package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetSubPurchaseOrderBasicVO {
    //supplierId	INTEGER	供应商id
    private Long supplierId;
    //isCustomProduct	BOOLEAN	是否为定制品
    private Boolean isCustomProduct;
    //expectLatestArrivalTimeOrDefault	INTEGER	要求最晚到达时间带默认值（时间戳 单位：毫秒）
    private Long expectLatestArrivalTimeOrDefault;
    //productSkcPicture	STRING	货品图片
    private String productSkcPicture;
    //productName	STRING	商品名
    private String productName;
    //isFirst	BOOLEAN	是否首单
    private Boolean isFirst;
    //purchaseStockType	INTEGER	备货类型 0-普通备货 1-jit备货
    private Integer purchaseStockType;
    //deliverUpcomingDelayTimeMillis	INTEGER	剩余发货时间不足XX，则统计为即将逾期，前端展示标红 单位：毫秒 默认12 * 3600 * 1000
    private Long deliverUpcomingDelayTimeMillis;
    //isClothCategory	BOOLEAN	是否服饰类目
    private Boolean isClothCategory;
    //productSkcId	INTEGER	skcId
    private Long productSkcId;
    //settlementType	INTEGER	结算类型 0-非vmi 1-vmi
    private Integer settlementType;
    //skcExtCode	STRING	货号
    private String skcExtCode;
    //deliverDisplayCountdownMillis	INTEGER	剩余发货时间不足XX，则前端开始读秒 单位：毫秒 默认1小时
    private Long deliverDisplayCountdownMillis;
    //urgencyType	INTEGER	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //subWarehouseId	INTEGER	子仓id
    private Long subWarehouseId;
    //productInventoryRegion	INTEGER	备货类型
    private Integer productInventoryRegion;
    //expectLatestDeliverTimeOrDefault	INTEGER	要求最晚发货时间带默认值（时间戳 单位：毫秒）
    private Long expectLatestDeliverTimeOrDefault;
    //receiveAddressInfo	OBJECT	收货仓详细地址
    private TemuOrderShipStagingGetReceiveAddressInfoVO receiveAddressInfo;
    //arrivalUpcomingDelayTimeMillis	INTEGER	剩余到货时间不足XX，则统计为即将逾期，前端展示标红 单位：毫秒 默认6 * 3600 * 1000
    private Long arrivalUpcomingDelayTimeMillis;
    //autoRemoveFromDeliveryPlatformTime	INTEGER	自动移出发货台倒计时时间,毫秒
    private Long autoRemoveFromDeliveryPlatformTime;
    //arrivalDisplayCountdownMillis	INTEGER	剩余到货时间不足XX，则前端开始读秒 单位：毫秒 默认1小时
    private Long arrivalDisplayCountdownMillis;
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
