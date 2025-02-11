package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/4 17:25
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopQueryPromiseTemplateDTO {
    //名称	类型	是否必须	描述
    //template_id	Number	否	输入服务模板编号。注：输入为-1时，获取所有服务模板列表。
    private Number template_id;
}
