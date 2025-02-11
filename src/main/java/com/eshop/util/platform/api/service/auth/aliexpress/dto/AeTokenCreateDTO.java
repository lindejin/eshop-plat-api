package com.eshop.util.platform.api.service.auth.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 9:27
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeTokenCreateDTO {
    //request.addApiParameter("code", "0_2DL4DV3jcU1UOT7WGI1A4rY91");
    //request.addApiParameter("uuid", "uuid");
    private String code;
    private String uuid;
}
