package com.eshop.util.platform.api.service.order.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoOrderShippingInfoV2RespVO extends BaseResponseVO {

    private TemuOrderPoOrderShippingInfoResultV2VO result;

    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;
}
