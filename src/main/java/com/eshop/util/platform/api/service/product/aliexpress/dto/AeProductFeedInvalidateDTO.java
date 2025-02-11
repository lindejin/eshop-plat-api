package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:47
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductFeedInvalidateDTO {
    //request.addApiParameter("job_id_list", "200000099310034475;200000099110014475;200000014009554475");
    private String job_id_list;
}
