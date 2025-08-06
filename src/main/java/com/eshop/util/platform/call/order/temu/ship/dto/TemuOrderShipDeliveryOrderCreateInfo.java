package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipDeliveryOrderCreateInfo {
    //deliveryAddressId	INTEGER	否	发货地址ID 待灰度key_cn_BG_137831全量后 该字段不能为空
    private Long deliveryAddressId;
    //deliverOrderDetailInfos	LIST	是	发货单详情列表
    private List<TemuOrderShipDeliveryOrderCreateDetailInfo> deliverOrderDetailInfos;
    //packageInfos	LIST	是	包裹信息列表
    private List<TemuOrderShipDeliveryOrderCreatePackageInfo> packageInfos;
    //subPurchaseOrderSn	STRING	是	采购子单号
    private String subPurchaseOrderSn;
}
