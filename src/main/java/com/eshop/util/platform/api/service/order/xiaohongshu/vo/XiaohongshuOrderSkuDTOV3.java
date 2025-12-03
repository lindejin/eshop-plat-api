package com.eshop.util.platform.api.service.order.xiaohongshu.vo;


import java.util.List;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderSkuDTOV3 {

    //  skuId	string	商品id
    //	skuName	string	商品名称
    //	erpcode	string	商家编码(若为组合品，暂不支持组合品的商家编码，但skuDetailList会返回子商品商家编码)
    //	skuSpec	string	规格
    //	skuImage	string	商品图片url
    //	skuQuantity	integer	商品数量
    //	skuDetailList	array	商品sku信息列表,单品非渠道商品为自身信息，组合品为子商品信息，多包组和渠道商品为其对应非渠道单品信息）
    //	totalPaidAmount	integer	总支付金额（考虑总件数）商品总实付
    //	totalMerchantDiscount	integer	商家承担总优惠
    //	totalRedDiscount	integer	平台承担总优惠
    //	totalTaxAmount	integer	商品税金
    //	totalNetWeight	integer	商品总净重
    //	skuTag	integer	是否赠品，1 赠品 0 普通商品
    //	isChannel	boolean	是否是渠道商品
    //	deliveryMode	integer	是否支持无物流发货, 1: 支持无物流发货 0：不支持无物流发货
    //	kolId	string	达人id(通过直播间下单 或者达人主页小清单下单才有值,直播间商品加到购物车下单 此字段为空)
    //	kolName	string	达人名称(通过直播间下单 或者达人主页小清单下单才有值,直播间商品加到购物车下单 此字段为空)
    //	skuAfterSaleStatus	integer	Sku售后状态 1无售后 2售后处理中 3售后完成 4售后拒绝 5售后关闭 6平台介入中 7售后取消
    //	skuIdentifyCodeInfo	object	商品序列号等信息，仅部分类目的国补订单存在
    //	itemId	string	商品ID
    //	itemName	string	商品名称

    private String skuId;
    private String skuName;
    private String erpcode;
    private String skuSpec;
    private String skuImage;
    private Integer skuQuantity;
    private List<XiaohongshuOrderSkuDetailDTO> skuDetailList;
    private Long totalPaidAmount;
    private Long totalMerchantDiscount;
    private Long totalRedDiscount;
    private Long totalTaxAmount;
    private Long totalNetWeight;
    private Integer skuTag;
    private Boolean isChannel;
    private Integer deliveryMode;
    private String kolId;
    private String kolName;
    private Integer skuAfterSaleStatus;
    private XiaohongshuOrderSkuIdentifyCodeInfo skuIdentifyCodeInfo;
    private String itemId;
    private String itemName;

}
