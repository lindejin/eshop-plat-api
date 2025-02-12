package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoDetailParentOrderMapVO {

    //parentOrderLabel List PO单订单状态标签
    private List<TemuOrderPoDetailParentOrderMapParentOrderLabelVO> parentOrderLabel;
    //parentOrderSn	STRING	否	父单号
    private String parentOrderSn;
    //parentOrderStatus	INTEGER	否	父单状态
    private Integer parentOrderStatus;
    //parentOrderTime	INTEGER	否	父单下单时间
    private Long parentOrderTime;
    //expectShipLatestTime	INTEGER	否	最晚发货时间
    private Long expectShipLatestTime;
    //parentShippingTime	INTEGER	否	时间发货时间
    private Long parentShippingTime;
    //parentOrderPendingFinishTime	INTEGER	否	PO单结束pending，转为待发货时间
    private Long parentOrderPendingFinishTime;
    //regionId 区域ID
    private Long regionId;
    //siteId 站点ID
    private Long siteId;
    //额外

    //latestDeliveryTime
    //fulfillmentWarning 履约相关提醒:

    //hasShippingFee
}
