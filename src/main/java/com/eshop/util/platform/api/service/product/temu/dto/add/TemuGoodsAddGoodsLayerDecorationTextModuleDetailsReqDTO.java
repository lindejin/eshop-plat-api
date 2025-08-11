package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddGoodsLayerDecorationTextModuleDetailsReqDTO {
    //backgroundColor	STRING	是	背景颜色
    //fontFamily	INTEGER	否	字体类型
    //fontSize	INTEGER	是	文字模块字体大小
    //align	STRING	是	文字对齐方式，left--左对齐；right--右对齐；center--居中；justify--两端对齐
    //fontColor	STRING	是	文字颜色

    private String backgroundColor;
    private Long fontFamily;
    private Long fontSize;
    private String align;
    private String fontColor;
}
