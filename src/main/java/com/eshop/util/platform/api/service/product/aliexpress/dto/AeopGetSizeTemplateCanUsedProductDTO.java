package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 11:04
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopGetSizeTemplateCanUsedProductDTO {
    //size_template_id	Number	是	尺码模版ID
    private Number size_template_id;
    //current_page	Number	是	当前页码，从1开始
    private Number current_page;
}
