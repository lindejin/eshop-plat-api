package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 16:50
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAereProductRenewExpireTimeReqDTO {
    //名称	类型	是否必须	描述
    //product_id	Number	否	需要延长有效期的商品id
    private Number product_id;
}
