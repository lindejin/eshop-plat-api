package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderV3CreateDeliveryDTO {
    //subWarehouseId	INTEGER	是	子仓id
    private Long subWarehouseId;
    //deliveryOrderCreateInfos	LIST	是	采购单创建信息列表
    private List<TemuOrderShipDeliveryOrderCreateInfo> deliveryOrderCreateInfos;
    //receiveAddressInfo	OBJECT	是	收货地址
    private TemuOrderShipReceiveAddressInfo receiveAddressInfo;
}
