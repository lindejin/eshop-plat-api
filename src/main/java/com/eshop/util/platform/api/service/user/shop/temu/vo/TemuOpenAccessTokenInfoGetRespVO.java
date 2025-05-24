package com.eshop.util.platform.api.service.user.shop.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOpenAccessTokenInfoGetRespVO extends BaseResponseVO {

    private TemuOpenAccessTokenInfoGetResultBaseVO result;

    //  "success": true,
    private Boolean success;
    //	"requestId": "eu-3a1acc45-e040-4538-bfba-55cefec69dec",
    private String requestId;
    //	"errorCode": 1000000,
    private Integer errorCode;
    //	"errorMsg": ""
    private String errorMsg;

}
