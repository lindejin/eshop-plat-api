package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageGetPackageDetailVO {

    //productSkuId	INTEGER	skuId
    private Long productSkuId;

    //productOriginalSkuId	INTEGER	原skuId
    private Long productOriginalSkuId;

    //personalText	STRING	定制内容
    private String personalText;

    //skuNum	INTEGER	sku数量
    private Integer skuNum;

}
