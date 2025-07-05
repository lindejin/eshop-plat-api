package com.eshop.util.platform.api.service.order.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoLogisticsShipmentV2RespVO extends BaseResponseVO {

    //"requestId": "gl-7fdc0798-ab27-40c7-ad93-6683d4bb1abd",
    private String requestId;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;

    private TemuOrderPoLogisticsShipmentResultV2VO result;

}
