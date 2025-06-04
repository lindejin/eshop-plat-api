package com.eshop.util.platform.api.service.order.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;
import com.eshop.util.platform.call.order.temu.vo.TemuOrderPoListResultResultVO;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderListV2RespVO extends BaseResponseVO {
    // "totalItemNum": 400,
    private TemuOrderPoListResultResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;
}
