package com.eshop.util.platform.api.service.product.temu.vo.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddSkuVO {

    //productSkuId	INTEGER	sku id
    //extCode	STRING	Sku External Code
    //skuSpecList	LIST	Sku Specification
    //productSkcId	INTEGER	skc id

    private Long productSkuId;
    private Long productSkcId;

    private String extCode;
    private List<TemuGoodsAddSkuSpecVO> skuSpecList;
}
