package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 10:58
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopFindAeProductDetailModuleListDTO {
    //名称	类型	是否必须	描述
    //module_status	String	否	要查询模块的状态，包含：tbd(审核不通过),auditing（审核中）,approved（审核通过）
    private String module_status;
    //type	String	否	要查询模块的类型，包含：custom（自定义模块）,relation（关联模块）
    private String type;
    //page_index	Number	否	要查询当前页码，每页返回50条记录，从1开始
    private Number page_index;
}
