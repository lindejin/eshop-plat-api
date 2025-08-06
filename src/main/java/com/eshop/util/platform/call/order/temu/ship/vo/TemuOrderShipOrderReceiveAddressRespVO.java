package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderReceiveAddressRespVO extends BaseResponseVO {

    // "totalItemNum": 400,
    private TemuOrderShipOrderReceiveAddressResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;
}
