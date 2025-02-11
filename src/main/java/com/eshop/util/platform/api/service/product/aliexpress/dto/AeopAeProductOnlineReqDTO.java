package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 13:43
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductOnlineReqDTO {
    //名称	类型	是否必须	描述
    //product_ids	String	否	需要上架的产品id列表。可输入多个，之前用半角分号分割。
    private String product_ids;
}
