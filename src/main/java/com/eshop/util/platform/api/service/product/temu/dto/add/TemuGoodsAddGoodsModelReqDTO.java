package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddGoodsModelReqDTO {
    //modelProfileUrl	STRING	是	模特头像
    //sizeSpecName	STRING	是	试穿尺码规格名称
    //modelId	INTEGER	是	模特id，新增虚拟模特场景不传
    //sizeSpecId	INTEGER	是	试穿尺码规格id
    //modelWaist	STRING	否	模特腰围文本
    //modelType	INTEGER	否	模特类型，1：成衣模特，2：鞋模
    //modelName	STRING	是	模特名称
    //modelHeight	STRING	否	模特身高文本
    //modelFeature	INTEGER	否	模特特性，1：真实模特，2：虚拟模特
    //modelFootWidth	STRING	否	模特脚宽文本
    //modelBust	STRING	否	模特胸围文本
    //modelFootLength	STRING	否	模特脚长文本
    //tryOnResult	INTEGER	否	试穿心得， TRUE_TO_SIZE(1, "舒适"), TOO_SMALL(2, "紧身"), TOO_LARGE(3, "宽松"),
    //modelHip	STRING	否	模特臀围文本

    private String modelProfileUrl;
    private String sizeSpecName;
    private Long modelId;
    private Long sizeSpecId;
    private String modelWaist;
    private Long modelType;
    private String modelName;
    private String modelHeight;
    private Long modelFeature;
    private String modelFootWidth;
    private String modelBust;
    private String modelFootLength;
    private Long tryOnResult;
    private String modelHip;
}
