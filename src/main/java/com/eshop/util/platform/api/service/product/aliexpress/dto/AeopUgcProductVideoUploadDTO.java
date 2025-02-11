package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 11:15
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopUgcProductVideoUploadDTO {
    //product_id	Number	是	商品id
    private Number product_id;
    //media_type	String	是	表示更新主图视频
    private String media_type;
    //video_file_url	String	是	视频地址，后缀以视频格式结束，视频大小2G，视频格式wmv,avi,mpg,mpeg,3gp,mov,mp4,flv,f4v,m4v,m2t,mts,rmvb,vob,mkv
    private String video_file_url;
}
