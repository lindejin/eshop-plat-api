package com.eshop.api4;


@lombok.Setter
@lombok.Getter
public class TemuPurchasePackageVO {

    //包裹号 - temu
    private String packageSn;
    //包裹skcId - temu
    private Long productSkcId;
    //包裹skuId - temu
    private Long productSkuId;
    //包裹商品数量 - temu
    private Integer num;
}
