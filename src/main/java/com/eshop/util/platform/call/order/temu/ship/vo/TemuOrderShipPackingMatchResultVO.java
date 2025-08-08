package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingMatchResultVO {
    //shouldAddDeliveryOrderInfoList	LIST	需要勾选的相同发货地址的发货单列表（最多展示50个）
    private List<TemuOrderShipPackingMatchShouldAddInfo> shouldAddDeliveryOrderInfoList;
    //deliveryOrderSnNotPrintBox	LIST	未打印打包标签的发货单列表
    private List<String> deliveryOrderSnNotPrintBox;
    //skuSumWeight	INTEGER	勾选的发货单对应SKU总重量（商品货品侧SKU重） 单位克
    private Long skuSumWeight;
}
