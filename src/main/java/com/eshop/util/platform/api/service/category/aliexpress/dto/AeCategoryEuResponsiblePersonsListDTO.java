package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 10:07
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryEuResponsiblePersonsListDTO {
//        request.addApiParameter("category_id", "39050508");
    private String category_id;
//        request.addApiParameter("channel", "AE_GLOBAL");
    private String channel;
//        request.addApiParameter("channel_seller_id", "2671514005");
    private String channel_seller_id;
}
