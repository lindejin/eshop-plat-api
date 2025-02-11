package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 11:20
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductEditReqDTO {
    //名称	类型	是否必须	描述
    //aeop_a_e_product	Object	是	产品信息
    private AeopAeProductEditDTO aeop_a_e_product;
}
