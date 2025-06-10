package com.eshop.util.platform.api.service.logistics.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipLogisticsTypeRespVO extends BaseResponseVO {

    private TemuLogisticsShipLogisticsTypeResultVO result;

    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //         "regionId"
    private Long regionId;
    //        "shipLogisticsTypeInfoDTOList"
    private List<TemuLogisticsShipLogisticsTypeResultInfoVO> shipLogisticsTypeInfoDTOList;
}
