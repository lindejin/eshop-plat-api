package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddReqDTO {

    //参数接口	参数类型	是否必填	说明
    //productSemiManagedReq	OBJECT	否	半托管相关信息
    private TemuGoodsAddProductSemiManagedReqDTO productSemiManagedReq;
    //productCarouseVideoReqList	LIST	否	轮播视频
    private List<TemuGoodsAddProductCarouseVideoReqDTO> productCarouseVideoReqList;
    //goodsLayerDecorationReqs	LIST	否	商详装饰
    private List<TemuGoodsAddGoodsLayerDecorationReqDTO> goodsLayerDecorationReqs;
    //productPropertyReqs	LIST	是	货品属性
    private List<TemuGoodsAddProductPropertyReqDTO> productPropertyReqs;
    //carouselImageUrls	LIST	是	货品轮播图，服饰类目不用传，会从skc上聚合
    private List<String> carouselImageUrls;
    //productOuterPackageImageReqs	LIST	否	外包装图片
    private List<TemuGoodsAddProductOuterPackageImageReqDTO> productOuterPackageImageReqs;
    //copyFromProductId	INTEGER	否	复制来源货品id
    private Long copyFromProductId;
    //source	INTEGER	否	货品来源
    private Long source;
    //productGuideFileReqs	LIST	否	货品说明书文件多语言
    private List<TemuGoodsAddProductGuideFileReqDTO> productGuideFileReqs;
    //productName	STRING	是	货品名称
    private String productName;
    //materialMultiLanguages	LIST	否	图片多语言列表
    private List<String> materialMultiLanguages;
    //productI18nReqs	LIST	否	货品多语言信息请求
    private List<TemuGoodsAddProductI18nReqDTO> productI18nReqs;
    //productWarehouseRouteReq	OBJECT	否	货品仓库路由请求
    private TemuGoodsAddProductWarehouseRouteReqDTO productWarehouseRouteReq;
    //goodsModelReqs	LIST	否	商品模特列表请求
    private List<TemuGoodsAddGoodsModelReqDTO> goodsModelReqs;
    //sizeTemplateId	INTEGER	否	尺码表模板id
    private Long sizeTemplateId;
    //productOuterPackageReq	OBJECT	否	货品外包装信息
    private TemuGoodsAddProductOuterPackageReqDTO productOuterPackageReq;
    //productShipmentReq	OBJECT	否	货品配送信息请求
    private TemuGoodsAddProductShipmentReqDTO productShipmentReq;
    //sourceInvitationId	INTEGER	否	Source Invitation ID
    private Long sourceInvitationId;
    //sensitiveTransNormalFileReqs	LIST	否	敏感品转普证明文件列表
    private List<TemuGoodsAddSensitiveTransNormalFileReqDTO> sensitiveTransNormalFileReqs;

    //sellOutProductId	STRING	否	售罄货品id
    private String sellOutProductId;

    //cat1Id	INTEGER	是	一级类目id
    private Long cat1Id;
    //cat2Id	INTEGER	是	二级类目id，没有的情况传0
    private Long cat2Id;
    //cat3Id	INTEGER	是	三级类目id，没有的情况传0
    private Long cat3Id;
    //cat4Id	INTEGER	是	四级类目id，没有的情况传0
    private Long cat4Id;
    //cat5Id	INTEGER	是	五级类目id，没有的情况传0
    private Long cat5Id;
    //cat6Id	INTEGER	是	六级类目id，没有的情况传0
    private Long cat6Id;
    //cat7Id	INTEGER	是	七级类目id，没有的情况传0
    private Long cat7Id;
    //cat8Id	INTEGER	是	八级类目id，没有的情况传0
    private Long cat8Id;
    //cat9Id	INTEGER	是	九级类目id，没有的情况传0
    private Long cat9Id;
    //cat10Id	INTEGER	是	十级类目id，没有的情况传0
    private Long cat10Id;

    //materialImgUrl	STRING	是	素材图
    private String materialImgUrl;

    //sizeTemplateIds	LIST	否	尺码表模板id列表
    private List<Long> sizeTemplateIds;
    //showSizeTemplateIds	LIST	否	重点展示尺码表模板id列表
    private List<Long> showSizeTemplateIds;

    //personalizationSwitch	INTEGER	否	是否支持定制品模板，0：不支持，1：支持
    private Long personalizationSwitch;

    //carouselImageI18nReqs	LIST	否	货品轮播图多语言信息请求
    private List<TemuGoodsAddCarouselImageI18nReqDTO> carouselImageI18nReqs;

    //productSpecPropertyReqs	LIST	是	货品规格属性
    private List<TemuGoodsAddProductSpecPropertyReqDTO> productSpecPropertyReqs;
    //productWhExtAttrReq	OBJECT	否	货品仓配供应链侧扩展属性请求
    private TemuGoodsAddProductWhExtAttrReqDTO productWhExtAttrReq;
    //productSkcReqs	LIST	是	货品skc列表
    private List<TemuGoodsAddProductSkcReqDTO> productSkcReqs;
    //productSaleExtAttrReq	OBJECT	否	货品销售域扩展属性请求
    private TemuGoodsAddProductSaleExtAttrReqDTO productSaleExtAttrReq;

    //productCustomReq	OBJECT	否	货品关务信息
    private TemuGoodsAddProductCustomReqDTO productCustomReq;
    //vehicleLibraryRelationReqList	LIST	否	车型库配置列表
    private List<TemuGoodsAddVehicleLibraryRelationReqDTO> vehicleLibraryRelationReqList;


    //productComplianceStatementReq	OBJECT	否	合规签署协议
    private TemuGoodsAddProductComplianceStatementReqDTO productComplianceStatementReq;
}
