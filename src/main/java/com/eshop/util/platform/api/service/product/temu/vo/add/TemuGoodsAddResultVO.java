package com.eshop.util.platform.api.service.product.temu.vo.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddResultVO {

    //productSkuList	LIST	SKU List
    //productId	INTEGER	Product ID
    //productSkcList	LIST	SKC List

    private List<TemuGoodsAddSkuVO> productSkuList;
    private Long productId;
    private List<TemuGoodsAddSkcVO> productSkcList;
}
