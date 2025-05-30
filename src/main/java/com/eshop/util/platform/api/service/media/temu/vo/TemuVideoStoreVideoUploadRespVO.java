package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoStoreVideoUploadRespVO extends BaseResponseVO {


    //{
    //    "url": "https://goods-vod.cdnfe.com/goods-video/201365d8925/048f2cec1f0ebd24d68420ad7109a2d7.mp4",
    //    "etag": "82e3db40b29b4d84259800c6cbd25b27",
    //    "vid": "goods-video-tag#ekn2ebahywmzx0kt3eag6m35qwqcx5vk"
    //}
    /**
     * 上传视频地址
     */
    private String url;
    /**
     *
     */
    private String etag;
    /**
     * 上传视频文件对应vid，后续查询转码结果使用
     */
    private String vid;

    /**
     * 成功时不返回
     */
    private Integer error_code;

    /**
     * 错误消息
     */
    private String error_msg;

}
