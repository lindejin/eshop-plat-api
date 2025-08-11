package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductPropertyReqDTO {

    //vid	INTEGER	是	基础属性值id，没有的情况传0
    //valueUnit	STRING	是	属性值单位，没有的情况传空字符串
    //pid	INTEGER	是	属性id
    //templatePid	INTEGER	是	模板属性id
    //numberInputValue	STRING	否	数值录入
    //propValue	STRING	是	基础属性值
    //propName	STRING	是	引用属性名
    //refPid	INTEGER	是	引用属性id

    private Long vid;
    private String valueUnit;
    private Long pid;
    private Long templatePid;
    private String numberInputValue;
    private String propValue;
    private String propName;
    private Long refPid;
}
