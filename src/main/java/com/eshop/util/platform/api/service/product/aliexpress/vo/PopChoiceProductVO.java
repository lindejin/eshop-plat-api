package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/3/4 16:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class PopChoiceProductVO {
    //@ApiModelProperty(value = "修改时间")
    private String modifiedTime;
    //@ApiModelProperty(value = "商品主图")
    private String productImage;
    //@ApiModelProperty(value = "商品id")
    private Long productId;
    //@ApiModelProperty(value = "创建时间")
    private String createTime;
    //@ApiModelProperty(value = "商品下库存总数")
    private String totalStocks;
    //@ApiModelProperty(value = "最大SKU价格")
    private String maxSkuPrice;
    //@ApiModelProperty(value = "最小SKU价格")
    private String minSkuPrice;
    //@ApiModelProperty(value = "商品标题")
    private String title;
    //@ApiModelProperty(value = "货币币种")
    private String currencyCode;
    //@ApiModelProperty(value = "商品状态")
    private String productStatus;
}
