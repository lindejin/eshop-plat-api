package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadResultRespVO extends BaseResponseVO {
    //{
    //    "result": {
    //        "vid": "goods-video-tag#hzv72wppszu0tjfielsj6m3v8gc4o16o",
    //        "coverUrl": "https://img.cdnfe.com/product/8a173218ed5aff8b72302990eff62e91b4d5f654.goods.000001.jpeg",
    //        "videoUrl": "https://goods-vod.cdnfe.com/goods-video/077a01916b8c8558cfa82057788a848b07d0d815.f30.mp4",
    //        "width": 1280,
    //        "height": 720
    //    },
    private TemuVideoUploadResultVO result;
    //    "success": true,
    private Boolean success;
    //    "requestId": "cn-24121f37-7e6c-48b6-9f47-79ea29846ac3",
    private String requestId;
    //    "errorCode": 1000000,
    private Integer errorCode;
    //    "errorMsg": ""
    private String errorMsg;
    //}


    //额外处理返回结果
    private String vid;
    private String coverUrl;
    private String videoUrl;
    private Integer width;
    private Integer height;
}
