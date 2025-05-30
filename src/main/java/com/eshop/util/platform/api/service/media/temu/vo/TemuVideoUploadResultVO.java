package com.eshop.util.platform.api.service.media.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadResultVO {
    //        "vid": "goods-video-tag#hzv72wppszu0tjfielsj6m3v8gc4o16o",
    //        "coverUrl": "https://img.cdnfe.com/product/8a173218ed5aff8b72302990eff62e91b4d5f654.goods.000001.jpeg",
    //        "videoUrl": "https://goods-vod.cdnfe.com/goods-video/077a01916b8c8558cfa82057788a848b07d0d815.f30.mp4",
    //        "width": 1280,
    //        "height": 720
        private String vid;
        private String coverUrl;
        private String videoUrl;
        private Integer width;
        private Integer height;
}
