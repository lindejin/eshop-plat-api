package com.eshop.util.platform.api.service.order.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoV2LogisticsShipmentConfirmSendInfoDTO {

    //parentOrderSn	STRING	True	Parent Order Number.
    private String parentOrderSn;

    //orderSn	STRING	True	Order Number.
    private String orderSn;

    //goodsId	LONG	False	Goods ID.
    private Long goodsId;

    //skuId	LONG	False	SKU ID.
    private Long skuId;

    //quantity	INTEGER	True	Quantity of the product.
    private Integer quantity;

}
