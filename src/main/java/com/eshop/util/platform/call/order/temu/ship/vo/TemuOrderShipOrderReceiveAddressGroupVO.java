package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderReceiveAddressGroupVO {
    //subWarehouseId	INTEGER	子仓id
    private Long subWarehouseId;
    //receiveAddressInfo	OBJECT	收货地址信息
    private TemuOrderShipOrderReceiveAddressAddressInfoVO receiveAddressInfo;
    //subPurchaseOrderSnList	LIST	子采购单号列表
    private List<String> subPurchaseOrderSnList;
}
