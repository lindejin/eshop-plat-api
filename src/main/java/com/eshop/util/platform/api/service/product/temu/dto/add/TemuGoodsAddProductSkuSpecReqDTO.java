package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuSpecReqDTO {

    //specId	INTEGER	是	规格id
    //parentSpecName	STRING	是	父规格名称
    //parentSpecId	INTEGER	是	父规格id
    //specName	STRING	是	规格名称

    private Long parentSpecId;
    private String parentSpecName;

    private Long specId;
    private String specName;

}
