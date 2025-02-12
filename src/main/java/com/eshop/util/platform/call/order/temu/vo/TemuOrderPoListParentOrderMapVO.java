package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoListParentOrderMapVO {
    //parentOrderLabel	LIST	否	PO单订单状态标签
    private List<TemuOrderPoListParentOrderMapParentOrderLabelVO> parentOrderLabel;
    //parentOrderSn	STRING	否	订单号
    private String parentOrderSn;
    //parentOrderStatus	INTEGER	否	订单状态
    private Integer parentOrderStatus;
    //parentOrderTime	INTEGER	否	订单创建时间
    private Long parentOrderTime;
    //parentOrderPendingFinishTime	INTEGER	否	订单结束pending转为自发货时间
    private Long parentOrderPendingFinishTime;
    //expectShipLatestTime	INTEGER	否	要求最晚发货时间
    private Long expectShipLatestTime;
    //parentShippingTime	INTEGER	否	父单发货时间
    private Long parentShippingTime;
    //fulfillmentWarning	LIST	否	履约相关提醒: SUGGEST_SIGNATURE_ON_DELIVERY-建议发货时购买签名服务
    private List<String> fulfillmentWarning;
}
