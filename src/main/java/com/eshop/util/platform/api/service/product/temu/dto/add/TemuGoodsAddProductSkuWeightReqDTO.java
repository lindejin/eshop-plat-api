package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuWeightReqDTO {

    //inputUnit	STRING	否	输入的单位
    //inputValue	STRING	否	输入的重量值
    //value	INTEGER	是	重量值，单位mg

    private String inputUnit;
    private String inputValue;
    private Long value;
}
