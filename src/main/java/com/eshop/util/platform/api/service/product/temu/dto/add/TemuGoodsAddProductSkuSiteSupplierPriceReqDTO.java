package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuSiteSupplierPriceReqDTO {

    //siteId	INTEGER	是	申报价格站点id
    //supplierPrice	INTEGER	是	站点申报价格，单位 人民币：分，美元：美分

    private Long siteId;
    private Long supplierPrice;
}
