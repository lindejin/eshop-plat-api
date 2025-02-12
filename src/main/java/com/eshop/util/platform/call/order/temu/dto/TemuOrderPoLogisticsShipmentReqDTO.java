package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentReqDTO {
    //parentOrderSn	STRING	是	父单号
    private String parentOrderSn;
    //orderSn	STRING	是	子单号
    private String orderSn;
}
