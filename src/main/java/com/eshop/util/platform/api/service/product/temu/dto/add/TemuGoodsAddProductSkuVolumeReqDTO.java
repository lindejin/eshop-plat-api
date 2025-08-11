package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuVolumeReqDTO {

    //inputUnit	STRING	否	输入的单位
    //len	INTEGER	是	长，单位mm
    //inputLen	STRING	否	输入的最长边
    //width	INTEGER	是	宽，单位mm
    //inputWidth	STRING	否	输入的次长边
    //height	INTEGER	是	高，单位mm
    //inputHeight	STRING	否	输入的最短边


    private String inputUnit;
    private Long len;
    private String inputLen;
    private Long width;
    private String inputWidth;
    private Long height;
    private String inputHeight;


}
