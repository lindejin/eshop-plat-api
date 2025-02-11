package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/11 17:29
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopFindAeProductStatusByIdReqDTO {
    //描述：查询商品状态，商品供三种状态。审核通过:approved;审核中:auditing;审核不通过:refuse
    //名称	类型	是否必须	描述
    //product_id	Number	否	商品ID,每次只能输入一个
    private Number product_id;
}
