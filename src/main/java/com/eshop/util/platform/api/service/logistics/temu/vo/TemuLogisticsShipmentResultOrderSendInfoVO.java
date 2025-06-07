package com.eshop.util.platform.api.service.logistics.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentResultOrderSendInfoVO {
    //parentOrderSn PO单号
    private String parentOrderSn;
    //orderSn O单号
    private String orderSn;

    //goodsId
    private Long goodsId;

    //skuId
    private Long skuId;

    //quantity
    private Long quantity;

}
