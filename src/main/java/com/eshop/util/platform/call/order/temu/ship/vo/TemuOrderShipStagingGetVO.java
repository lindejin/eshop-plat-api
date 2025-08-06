package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetVO {
    //orderDetailVOList	LIST	子订单详情信息
    private List<TemuOrderShipStagingGetOrderDetailVO> orderDetailVOList;
    //subPurchaseOrderBasicVO	OBJECT	子订单基本信息
    private TemuOrderShipStagingGetSubPurchaseOrderBasicVO subPurchaseOrderBasicVO;
}
