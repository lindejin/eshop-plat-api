package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderReceiveAddressResultVO {

    //subPurchaseReceiveAddressGroups	LIST	子采购单收货地址分组信息列表
    private List<TemuOrderShipOrderReceiveAddressGroupVO> subPurchaseReceiveAddressGroups;
}
