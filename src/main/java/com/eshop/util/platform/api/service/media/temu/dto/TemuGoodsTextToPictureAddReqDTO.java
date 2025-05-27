package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsTextToPictureAddReqDTO {
    //参数接口	参数类型	是否必填	说明

    //backColor	STRING	否	背景颜色,必须以#开头，后面的数字是十六进制，不指定透明通道的话总共7个字符，指定透明通道的话总共9个字符
    private String backColor;

    //text	STRING	否	文本
    private String text;

    //align	STRING	否	对齐方式,left,center,right
    private String align;

    //fontColor	STRING	否	字体颜色,必须以#开头，后面的数字是十六进制，不指定透明通道的话总共7个字符，指定透明通道的话总共9个字符
    private String fontColor;

    //font	STRING	否	字体,Source Han Sans CN Heavy/Bold/Medium/Regular/Light/Extralight, Source Han Serif Heavy/Bold
    private String font;
}
