package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:08
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductFindAeProductDetailModuleListByQueryDTO {
    //request.addApiParameter("module_status", "approved");
    //request.addApiParameter("type", "custom");
    //request.addApiParameter("page_index", "1");
    private String module_status;
    private String type;
    private String page_index;

}
