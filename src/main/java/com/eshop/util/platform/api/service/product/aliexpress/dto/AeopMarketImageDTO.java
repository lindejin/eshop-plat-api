package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopMarketImageDTO {
    //url	String	否	营销图片URL。图片格式只允许jpg、png、jpeg这3种格式
    private String url;
    //image_type	Number	否	1：代表长图，大小为750*1000; 2：代表方图，大小为800*800
    private Number image_type;
}
