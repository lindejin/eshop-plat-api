package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:24
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductProductDiagnosisPageQueryProblemDTO {
    //request.addApiParameter("operate_status", "0");
    private String operate_status;
    //request.addApiParameter("problem_type_list", "repeat_repost, lack_white_image");
    private String problem_type_list;
    //request.addApiParameter("page_size", "10");\
    private String page_size;
    //request.addApiParameter("current_page", "1");
    private String current_page;

}
