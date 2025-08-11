package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuWhExtAttrReqDTO {

    //productSkuWeightReq	OBJECT	是	货品sku重量
    //productSkuSameReferPriceReq	OBJECT	否	同款参考
    //productSkuSensitiveLimitReq	OBJECT	是	货品sku敏感属性限制请求
    //productSkuVolumeReq	OBJECT	是	货品sku体积
    //productSkuBarCodeReqs	LIST	否	货品sku条码
    //productSkuSensitiveAttrReq	OBJECT	是	货品sku敏感属性请求

    private TemuGoodsAddProductSkuWeightReqDTO productSkuWeightReq;
    private TemuGoodsAddProductSkuSameReferPriceReqDTO productSkuSameReferPriceReq;
    private TemuGoodsAddProductSkuSensitiveLimitReqDTO productSkuSensitiveLimitReq;
    private TemuGoodsAddProductSkuVolumeReqDTO productSkuVolumeReq;
    private List<TemuGoodsAddProductSkuBarCodeReqDTO> productSkuBarCodeReqs;
    private TemuGoodsAddProductSkuSensitiveAttrReqDTO productSkuSensitiveAttrReq;

}
