package com.eshop.util.platform.api.service.order.xiaohongshu.vo;


@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderSkuDetailDTO {

    //  skuId	string	单品商品Id(渠道商品为生成渠道商品的原商品单品id，组合商品为各个子商品的单品id，多包组为对应单包组商品id,商家编码同理)
    //	erpCode	string	商家编码
    //	barcode	string	商品条码
    //	scSkuCode	string	小红书编码，即将废弃
    //	quantity	integer	购买数量
    //	registerName	string	商品备案名称
    //	skuName	string	商品名
    //	pricePerSku	integer	单个sku价格（也叫申报价，不含税）
    //	taxPerSku	integer	单个sku税金
    //	paidAmountPerSku	integer	单个sku实付
    //	depositAmountPerSku	integer	单个sku定金
    //	merchantDiscountPerSku	integer	单个sku商家承担优惠
    //	redDiscountPerSku	integer	单个sku平台承担优惠
    //	rawPricePerSku	integer	单个sku原价（商品发布时设置的售价，是否含税取决于商品发布时的设置）

    private String skuId;
    private String erpCode;
    private String barcode;
    private String scSkuCode;
    private Integer quantity;
    private String registerName;
    private String skuName;
    private Long pricePerSku;
    private Long taxPerSku;
    private Long paidAmountPerSku;
    private Long depositAmountPerSku;
    private Long merchantDiscountPerSku;
    private Long redDiscountPerSku;
    private Long rawPricePerSku;


}
