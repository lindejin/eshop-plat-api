package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 17:36
 * @Description: 将指定的尺码模版信息复制到具有相同的模型的目标叶子类目下面
 * @Version 1.0
 */
@Getter
@Setter
public class AeopProductCopySizeTemplateDTO {
    //名称	类型	是否必须	描述
    //size_template_id	Number	是	被复制的尺码模版ID
    private Number size_template_id;
    //target_leaf_id	Number	是	要复制到的目标叶子类目ID
    private Number target_leaf_id;
}
