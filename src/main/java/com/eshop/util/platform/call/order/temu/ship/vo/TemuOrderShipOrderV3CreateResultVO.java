package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderV3CreateResultVO {

    //cancelUrgencyTypeSubPurchaseOrderSnList	LIST	取消急采标的采购单列表
    private List<String> cancelUrgencyTypeSubPurchaseOrderSnList;
    //deliveryOrders	LIST	创建成功的发货单列表
    private List<String> deliveryOrders;
    //isUrgencyType	BOOLEAN	是否是急采
    private Boolean isUrgencyType;
    //cancelUrgencyType	BOOLEAN	是否有取消急采标
    private Boolean cancelUrgencyType;
}
