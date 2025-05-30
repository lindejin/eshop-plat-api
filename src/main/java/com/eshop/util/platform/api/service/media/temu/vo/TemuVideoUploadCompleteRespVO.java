package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadCompleteRespVO extends BaseResponseVO {
    /**
     * 上传视频文件对应vid，后续查询转码结果使用
     */
    private String vid;

}
