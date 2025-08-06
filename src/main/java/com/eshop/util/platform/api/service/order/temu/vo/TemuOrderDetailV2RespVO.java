package com.eshop.util.platform.api.service.order.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;
import com.eshop.util.platform.call.order.temu.order.vo.TemuOrderPoDetailResultResultVO;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderDetailV2RespVO extends BaseResponseVO {

    private TemuOrderPoDetailResultResultVO result;

    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;
}
