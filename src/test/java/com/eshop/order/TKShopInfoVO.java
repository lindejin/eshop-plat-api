package com.eshop.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class TKShopInfoVO implements Serializable {
    //    @ApiModelProperty("店铺id")
    private String id;
    //    @ApiModelProperty("店铺名称")
    private String name;
    //    @ApiModelProperty("跨境商店区域")
    private String region;
    //    @ApiModelProperty(value = "店铺类型", notes = "CROSS_BORDER:跨境店铺,LOCAL:本土店铺")
    private String sellerType;
    //    @ApiModelProperty("店铺密码")
    private String cipher;
    //    @ApiModelProperty("店铺编号")
    private String code;

}
