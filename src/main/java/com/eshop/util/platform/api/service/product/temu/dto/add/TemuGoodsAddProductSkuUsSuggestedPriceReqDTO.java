package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuUsSuggestedPriceReqDTO {

    //suggestedPriceCurrencyType	STRING	否	建议价格币种
    //suggestedPrice	INTEGER	否	建议价格
    //specialSuggestedPrice	STRING	否	特殊的建议价格

    private String suggestedPriceCurrencyType;
    private Long suggestedPrice;
    private String specialSuggestedPrice;
}
