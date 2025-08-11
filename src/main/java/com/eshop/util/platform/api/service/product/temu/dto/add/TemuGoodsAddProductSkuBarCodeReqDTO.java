package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuBarCodeReqDTO {

    //code	STRING	否	条码
    //codeType	INTEGER	否	条码类型 (1: EAN, 2: UPC, 3: ISBN)

    private String code;
    private Long codeType;
}
