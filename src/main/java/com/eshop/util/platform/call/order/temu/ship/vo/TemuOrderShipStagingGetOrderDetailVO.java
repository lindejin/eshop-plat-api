package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetOrderDetailVO {

    //productSkuId	INTEGER	货品skuId
    private Long productSkuId;
    //productSkuImgUrlList	LIST	货品SKU图片URL列表
    private List<String> productSkuImgUrlList;
    //color	STRING	颜色
    private String color;
    //size	STRING	尺码
    private String size;
    //skuDeliveryQuantityMaxLimit	INTEGER	发货数量限制最大值
    private Integer skuDeliveryQuantityMaxLimit;
    //productOriginalSkuId	INTEGER	原始skuId
    private Long productOriginalSkuId;
    //productSkuPurchaseQuantity	INTEGER	货品sku下单数量
    private Integer productSkuPurchaseQuantity;
}
