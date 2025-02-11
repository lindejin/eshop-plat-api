package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 11:10
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryTreeListDTO {
//    request.addApiParameter("channel_seller_id", "2671514005");
    private String channel_seller_id;
//    request.addApiParameter("only_with_permission", "true");
    private String only_with_permission;
//    request.addApiParameter("channel", "AE_GLOBAL");
    private String channel;
//    request.addApiParameter("category_id", "0");
    private String category_id;
}
