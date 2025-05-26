package com.eshop.order;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiktokAuthBaseInfoDTO implements Serializable {
    /**
     * 平台应用信息,平台表里面的param_static_json转换成Json穿过来就好
     */
    // @ApiModelProperty(value = "平台应用信息", required = true)
    private JSONObject platformAppInfo;
    //  @ApiModelProperty(value = "店铺授权Token", required = true)
    private String accessToken;
    //   @ApiModelProperty("店铺Id ,通过查询授权店铺获获取的")
    private String shopId;
    //  @ApiModelProperty("店铺密码,通过查询授权店铺获获取的")
    private String shopCipher;
    //  @ApiModelProperty("货币类型,商品上刊的时候需要")
    private String currencyType;
    // @ApiModelProperty("店铺区域")
    private String region;
}
