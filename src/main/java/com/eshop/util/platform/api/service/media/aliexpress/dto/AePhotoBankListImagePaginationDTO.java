package com.eshop.util.platform.api.service.media.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 11:09
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AePhotoBankListImagePaginationDTO {
    //request.addApiParameter("aeop_image_pagination_request", "{\"group_id\":\"0\",\"current_page\":\"0\",\"location_type\":\"0\",\"page_size\":\"0\"}");
    private String aeop_image_pagination_request;
}
