package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadSignRespVO extends BaseResponseVO {

    private Boolean success;
    private String requestId;
    private Integer errorCode;
    private String errorMsg;

    private TemuVideoUploadSignResultVO result;

    //
    private String sign;
}
