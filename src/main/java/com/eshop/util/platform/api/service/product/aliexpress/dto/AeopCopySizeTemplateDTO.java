package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 10:35
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopCopySizeTemplateDTO {
    //size_template_id	Number	是	被复制的尺码模版ID
    private Number size_template_id;
    //target_leaf_id	Number	是	要复制到的目标叶子类目ID
    private Number target_leaf_id;
}
