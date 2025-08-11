package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuMultiPackReqDTO {

    //numberOfPieces	INTEGER	否	sku分类单品数量，sku分类为单品的默认是1，sku分类为混合套装时，单品数量需要等于包装清单物品数量之和
    //individuallyPacked	INTEGER	否	是否独立包装，当sku分类为同款多件装或混合套装时，必填
    //productSkuNetContentReq	OBJECT	否	净含量请求，传空对象表示清除
    //skuClassification	INTEGER	否	sku分类，1：单品，2：同款多件装，3：混合套装
    //pieceUnitCode	INTEGER	否	单件单位，1：件，2：双，3：包

    private Long numberOfPieces;
    private Long individuallyPacked;
    private TemuGoodsAddProductSkuNetContentReqDTO productSkuNetContentReq;
    private Long skuClassification;
    private Long pieceUnitCode;
}
