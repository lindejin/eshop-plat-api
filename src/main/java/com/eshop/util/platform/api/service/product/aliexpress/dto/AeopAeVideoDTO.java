package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeVideoDTO {
    //media_id	Number	否	媒体唯一标识Id
    private Number media_id;
    //media_type	String	否	媒体类型
    private String media_type;
    //poster_url	String	否	媒体封面URL
    private String poster_url;
}
