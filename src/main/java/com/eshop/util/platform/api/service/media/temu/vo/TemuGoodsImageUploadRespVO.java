package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsImageUploadRespVO extends BaseResponseVO {

    private TemuGoodsImageUploadResultVO result;

    private Boolean success;
    private String requestId;
    private Integer errorCode;
    private String errorMsg;

    //额外处理返回结果

    /**
     * 原图链接
     */
    private String imageUrl;
    /**
     * 单张AI裁图链接
     */
    private String url;
    /**
     * 多张AI裁图链接
     */
    private List<String> urls;
}
