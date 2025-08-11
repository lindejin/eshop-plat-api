package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkcReqDTO {

    //extCode	STRING	是	货品skc外部编码，没有的场景传空字符串
    //productSkuReqs	LIST	是	货品sku列表（服饰类目最多10个）
    //mainProductSkuSpecReqs	LIST	是	主销售规格列表
    //previewImgUrls	LIST	是	预览图列表，非服饰类目不用传
    //productSkcCarouselImageI18nReqs	LIST	否	SKC轮播图多语言信息请求
    //isBasePlate	INTEGER	否	是否底板
    //colorImageUrl	STRING	否	SKC色块图

    private String extCode;
    private List<TemuGoodsAddProductSkuReqDTO> productSkuReqs;
    private List<TemuGoodsAddMainProductSkuSpecReqDTO> mainProductSkuSpecReqs;
    private List<String> previewImgUrls;
    private List<TemuGoodsAddProductSkcCarouselImageI18nReqDTO> productSkcCarouselImageI18nReqs;
    private Long isBasePlate;
    private String colorImageUrl;
}
