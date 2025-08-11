package com.eshop.util.platform.api.service.product.temu.vo.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddSkuSpecVO {

    //specId	INTEGER	Specification ID
    //parentSpecName	STRING	Parent Specification Name
    //parentSpecId	INTEGER	Parent Specification ID
    //specName	STRING	Specification Name

    private Long parentSpecId;
    private String parentSpecName;

    private Long specId;
    private String specName;
}
