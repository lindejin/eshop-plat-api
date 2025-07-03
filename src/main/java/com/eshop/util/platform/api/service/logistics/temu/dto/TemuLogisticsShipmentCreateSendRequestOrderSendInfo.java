package com.eshop.util.platform.api.service.logistics.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateSendRequestOrderSendInfo {

    //parentOrderSn	STRING	True	Parent Order Number
    /**
     * parentOrderSn
     */
    private String parentOrderSn;
    //orderSn	STRING	True	Order Number
    /**
     * orderSn
     */
    private String orderSn;
    //goodsId	LONG	False	Goods ID
    /**
     * 商品goodsId
     */
    private String goodsId;
    //skuId	LONG	False	SKU ID
    /**
     * 商品skuId
     */
    private Long skuId;
    //quantity	INTEGER	True	Quantity of the product
    /**
     * 发货数量
     */
    private Integer quantity;

}
