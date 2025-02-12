package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoListRespVO {

    //  result
    private TemuOrderPoListResultBaseVO result;
    //  "success": true,
    private Boolean success;
    //	"requestId": "eu-3a1acc45-e040-4538-bfba-55cefec69dec",
    private String requestId;
    //	"errorCode": 1000000,
    private Integer errorCode;
    //	"errorMsg": ""
    private String errorMsg;

    private String respBody;
}
