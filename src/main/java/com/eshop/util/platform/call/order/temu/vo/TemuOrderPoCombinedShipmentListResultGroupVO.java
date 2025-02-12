package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoCombinedShipmentListResultGroupVO {

    //parentOrderSn	STRING	PO单号
    private String parentOrderSn;
    //parentOrderStatus	INTEGER	PO单状态
    private Integer parentOrderStatus;
    //parentOrderTime	INTEGER	PO单下单时间
    private Long parentOrderTime;
}
