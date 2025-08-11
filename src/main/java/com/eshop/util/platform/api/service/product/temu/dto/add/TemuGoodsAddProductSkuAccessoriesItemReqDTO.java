package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuAccessoriesItemReqDTO {

    //vid	INTEGER	是	属性值id
    //num	INTEGER	是	物品数量（支持1~1000）
    //unitCode	INTEGER	是	单位

    private Long vid;
    private Long num;
    private Long unitCode;

}
