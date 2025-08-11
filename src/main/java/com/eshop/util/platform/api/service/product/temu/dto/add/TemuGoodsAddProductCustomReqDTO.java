package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductCustomReqDTO {

    //goodsLabelName	STRING	否	商品标签
    //isRecommendedTag	BOOLEAN	是	是否选择的推荐标签

    private String goodsLabelName;
    private Boolean isRecommendedTag;
}
