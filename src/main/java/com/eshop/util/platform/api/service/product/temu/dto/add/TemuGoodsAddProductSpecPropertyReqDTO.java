package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSpecPropertyReqDTO {

    //vid	INTEGER	是	基础属性值id，没有的情况传0
    //specId	INTEGER	是	规格id
    //valueGroupId	INTEGER	是	属性值组id，没有的情况传o
    //parentSpecId	INTEGER	是	父规格id
    //valueGroupName	STRING	是	属性值组名称，没有的情况传空字符串
    //valueUnit	STRING	是	属性值单位，没有的情况传空字符串
    //pid	INTEGER	是	属性id
    //templatePid	INTEGER	是	模板属性id
    //numberInputValue	STRING	否	数值录入
    //propValue	STRING	是	基础属性值
    //propName	STRING	是	引用属性名
    //refPid	INTEGER	是	引用属性id

    private Long vid;
    private Long specId;
    private Long valueGroupId;
    private Long parentSpecId;
    private String valueGroupName;
    private String valueUnit;
    private Long pid;
    private Long templatePid;
    private String numberInputValue;
    private String propValue;
    private String propName;
    private Long refPid;

}
