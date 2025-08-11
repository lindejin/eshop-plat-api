package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddGoodsLayerDecorationContentReqDTO {

    //imgUrl	STRING	否	图片地址--通用
    //textModuleDetails	OBJECT	否	文字模块详情
    //text	STRING	否	文字信息--文字模块

    //width	INTEGER	否	图片宽度--通用
    //height	INTEGER	否	图片高度--通用

    private String imgUrl;
    private TemuGoodsAddGoodsLayerDecorationTextModuleDetailsReqDTO textModuleDetails;
    private String text;

    private Long width;
    private Long height;
}
