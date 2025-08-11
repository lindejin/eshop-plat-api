package com.eshop.util.platform.api.service.product.temu.dto.add;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductOuterPackageReqDTO {

    //packageShape	INTEGER	否	外包装形状)
    //packageType	INTEGER	否	外包装类型

    private Long packageShape;
    private Long packageType;
}
