package com.eshop.util.platform.api.service.order.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoLogisticsShipmentV2ReqDTO {
    //parentOrderSn	STRING	True	Parent Order Number.
    private String parentOrderSn;
    //orderSn	STRING	True	Order Number.
    private String orderSn;

}
