package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingSendRespVO extends BaseResponseVO {

    //
    private TemuOrderShipPackingSendResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //ext
    //expressBatchSn	STRING	创建生成的发货批次号
    private String expressBatchSn;

}
