package com.eshop.util.platform.api.service.product.temu.dto.add;


import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuReqDTO {

    //currencyType	STRING	是	币种 (CNY: 人民币, USD: 美元) (默认人民币)
    //productSkuMultiPackReq	OBJECT	否	货品多包规请求
    //productSkuSuggestedPriceReq	OBJECT	否	货品sku建议价格请求
    //siteSupplierPrices	LIST	否	站点供货价列表，仅半托管场景使用
    //supplierPrice	INTEGER	否	供货价
    //productSkuUsSuggestedPriceReq	OBJECT	否	货品sku美国建议价格请求
    //productSkuStockQuantityReq	OBJECT	否	货品sku库存请求
    //extCode	STRING	是	货品skc外部编码，没有的场景传空字符串
    //productSkuThumbUrlI18nReqs	LIST	否	SKU预览图多语言信息请求
    //productSkuAccessoriesReq	OBJECT	否	货品SKU包装清单，全托管SKU分类选择“混合套装”时必填，从bg.goods.accessories.get获取支持的包装清单物品类型信息
    //thumbUrl	STRING	是	预览图
    //productSkuWhExtAttrReq	OBJECT	是	货品sku扩展属性
    //productSkuSpecReqs	LIST	是	货品sku规格列表

    private String currencyType;
    private TemuGoodsAddProductSkuMultiPackReqDTO productSkuMultiPackReq;
    private TemuGoodsAddProductSkuSuggestedPriceReqDTO productSkuSuggestedPriceReq;
    private List<TemuGoodsAddProductSkuSiteSupplierPriceReqDTO> siteSupplierPrices;
    private Long supplierPrice;
    private TemuGoodsAddProductSkuUsSuggestedPriceReqDTO productSkuUsSuggestedPriceReq;
    private TemuGoodsAddProductSkuStockQuantityReqDTO productSkuStockQuantityReq;
    private String extCode;
    private List<TemuGoodsAddProductSkuThumbUrlI18nReqDTO> productSkuThumbUrlI18nReqs;
    private TemuGoodsAddProductSkuAccessoriesReqDTO productSkuAccessoriesReq;
    private String thumbUrl;
    private TemuGoodsAddProductSkuWhExtAttrReqDTO productSkuWhExtAttrReq;
    private List<TemuGoodsAddProductSkuSpecReqDTO> productSkuSpecReqs;
    
}
