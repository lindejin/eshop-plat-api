package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoListOrderListProductListVO {
    //productSkuId	INTEGER	否	货品skuId
    private Long productSkuId;
    //soldFactor	INTEGER	否	商品和货品数量转换系数，商品数量(quantity)乘以转换系数，代表货品数量
    private Long soldFactor;
    //productId	LONG	否	货品Id
    private Long productId;
    //extCode	STRING	否	货品编码
    private String extCode;
}
