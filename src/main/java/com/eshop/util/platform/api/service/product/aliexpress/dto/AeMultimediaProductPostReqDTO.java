package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rch
 * @date 2024/6/21 14:57
 * @desc 商品模型
 * @Version 1.0
 */
@Getter
@Setter
public class AeMultimediaProductPostReqDTO {

    // 视频信息
    private List<AeVideoProductPostReqDTO> video_list;

    //market_image_list   营销图列表
    private List<AeMarketImageProductPostReqDTO> market_image_list;

    // 商品主图列表
    private String[] main_image_list;
}