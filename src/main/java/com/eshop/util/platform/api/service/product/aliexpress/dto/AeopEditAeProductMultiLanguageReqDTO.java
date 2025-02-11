package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/28 17:16
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopEditAeProductMultiLanguageReqDTO {
    //名称	类型	是否必须	描述
    //product_id	Number	是	待编辑的商品ID。
    private Number product_id;
    //aeop_a_e_product_multilanguage_info	Object	是	商品多语言信息
    private AeopEditAeProductMultiLanguageDTO aeop_a_e_product_multilanguage_info;
}
