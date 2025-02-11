package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/6/21 14:57
 * @desc 商品模型
 * @Version 1.0
 */
@Getter
@Setter
public class AeVideoProductPostReqDTO {

    // 视频封面
    private String poster_url;

    // 视频类型 ：MAIN_IMAGE_VIDEO
    private String media_type;

    // 媒体id，通过媒体中心接口获取
    private Number media_id;
}