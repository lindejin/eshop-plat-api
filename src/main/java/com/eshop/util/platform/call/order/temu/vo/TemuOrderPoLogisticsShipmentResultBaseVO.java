package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentResultBaseVO {

    private TemuOrderPoLogisticsShipmentResultResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;
}
