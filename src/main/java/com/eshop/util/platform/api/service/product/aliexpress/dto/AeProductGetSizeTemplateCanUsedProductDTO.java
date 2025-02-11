package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 11:00
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductGetSizeTemplateCanUsedProductDTO {
    //size_template_id Number 尺码模版ID
    private String size_template_id;
    //current_page Number 	当前页码，从1开始
    private String current_page;
}
