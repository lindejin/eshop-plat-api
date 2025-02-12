package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoListParentOrderMapParentOrderLabelVO {
    //name STRING 否标签名称，具体枚举如下
    // soon_to_be_overdue-即将逾期、
    // past_due-已逾期、
    // pending_buyer_cancellation-买家取消待确认订单、
    // pending_buyer_address_change-买家改地址待确认订单
    private String name;
    //value INTEGER 是否有标签：0=无标签，1=有标签
    private Integer label;
}
