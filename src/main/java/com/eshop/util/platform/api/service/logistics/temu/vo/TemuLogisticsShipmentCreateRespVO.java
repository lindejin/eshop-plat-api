package com.eshop.util.platform.api.service.logistics.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateRespVO extends BaseResponseVO {

    private TemuLogisticsShipmentCreateResultVO result;

    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //vo前移
    private List<String> packageSnList;
    private String shipLaterLimitTime;

}
