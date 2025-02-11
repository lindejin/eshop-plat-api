package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 17:03
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductListReqDTO {
    //名称	类型	是否必须	描述
    //aeop_a_e_product_list_query	Object	否	商品列表查询
    private AeopAeProductListQueryDTO aeop_a_e_product_list_query;
}
