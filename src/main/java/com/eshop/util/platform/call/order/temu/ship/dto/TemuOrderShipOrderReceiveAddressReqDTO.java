package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderReceiveAddressReqDTO {
    //参数接口	参数类型	是否必填	说明
    //subPurchaseOrderSnList	LIST	是	子采购单号列表
    private List<String> subPurchaseOrderSnList;
}
