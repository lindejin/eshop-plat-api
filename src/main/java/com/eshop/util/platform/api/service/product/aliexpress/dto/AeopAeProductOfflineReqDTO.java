package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 13:44
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductOfflineReqDTO {
    //名称	类型	是否必须	描述
    //edit_reason	String	否	下架原因，目前仅用于商品诊断优化
    private String edit_reason;
    //product_ids	String	否	需要下架的产品id。多个产品ID用英文分号隔开。
    private String product_ids;

}
