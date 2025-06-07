package com.eshop.util.platform.api.service.logistics.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentResultRespVO  extends BaseResponseVO {

    private TemuLogisticsShipmentResultVO result;

    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;

    //
     //运单号
    private String trackingNumber;
}
