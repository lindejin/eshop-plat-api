package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:02
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductUgcProductVideoUploadDTO {
    //request.addApiParameter("product_id", "123554348908");
    //request.addApiParameter("media_type", "video");
    //request.addApiParameter("video_file_url", "http://ae-cn.alicdn.com/kddd6bep.mp4");
    private String product_id;
    private String media_type;
    private String video_file_url;

}
