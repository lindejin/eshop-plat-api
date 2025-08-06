package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageEditPackageDetailSaveInfoDTO {
    //productSkuId	INTEGER	是	skuId
    private Long productSkuId;
    //skuNum	INTEGER	是	发货sku数目
    private Integer skuNum;

}
