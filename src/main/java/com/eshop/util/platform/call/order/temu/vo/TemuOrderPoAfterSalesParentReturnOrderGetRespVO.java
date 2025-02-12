package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentReturnOrderGetRespVO {

    private TemuOrderPoAfterSalesParentReturnOrderGetResultBaseVO result;

    //  "success": true,
    private Boolean success;
    //	"requestId": "eu-3a1acc45-e040-4538-bfba-55cefec69dec",
    private String requestId;
    //	"errorCode": 1000000,
    private Integer errorCode;
    //	"errorMsg": ""
    private String errorMsg;

    //返回总数据Body
    private String respBody;
}
