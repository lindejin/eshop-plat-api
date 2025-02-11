package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author rch
 * @date 2024/3/16 17:57
 * @Description: ...
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeFullSizeTemplateDTO {
    //名称	类型	是否必须	描述
    private String channelSellerId;

    private String channel;

    private Number leafCategoryId;

    private Number currentPage;

}
