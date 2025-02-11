package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Getter
@Setter
public class AePopChoiceProductRespVO {
    private String respBody;
    //product_id	Number	新商品的ID
    private Long productId;
}
