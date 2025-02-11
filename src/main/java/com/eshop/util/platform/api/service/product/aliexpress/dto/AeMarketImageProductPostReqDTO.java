package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeMarketImageProductPostReqDTO
 * @Description 营销图
 * @Author xxs
 * @Date 2024/6/25 14:00
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeMarketImageProductPostReqDTO {
    //image_type	Number	是	1：代表长图，大小为750*1000; 2：代表方图，大小为800*800
    private String image_type;
    //url	String	是	营销图片URL
    private String url;
}
