package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetReqDTO {

    //参数接口	参数类型	是否必填	说明
    //deliveryAddressId	INTEGER	是	发货地址
    private Long deliveryAddressId;
    //predictTotalPackageWeight	INTEGER	是	预估总包裹重量，单位g
    private Long predictTotalPackageWeight;
    //urgencyType	INTEGER	否	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //subWarehouseId	INTEGER	是	收货子仓id
    private Long subWarehouseId;
    //totalPackageNum	INTEGER	是	包裹件数
    private Integer totalPackageNum;
    //receiveAddressInfo	OBJECT	是	收货地址
    private TemuOrderShipV3LogisticsMatchReceiveAddressInfoReqDTO receiveAddressInfo;
    //deliveryOrderSns	LIST	是	发货单列表
    private List<String> deliveryOrderSns;
}
