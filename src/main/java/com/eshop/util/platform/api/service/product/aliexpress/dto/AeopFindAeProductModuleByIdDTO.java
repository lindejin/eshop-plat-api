package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 11:04
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopFindAeProductModuleByIdDTO {
    //名称	类型	是否必须	描述
    //module_id	Number	否	moduleId 对应商品详情中的kse标签中的id属性;如: id="1004"
    private Number module_id;
}
