package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingAddRespVO extends BaseResponseVO {
    // "totalItemNum": 400,
    private TemuOrderShipStagingAddResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //ext
    //existJoinErrorSubPurchase	BOOLEAN	是否存在加入发货台失败的发货单
    private Boolean existJoinErrorSubPurchase;
    //joinErrorList	LIST	加入发货台失败的备货单明细列表
    private List<TemuOrderShipStagingAddJoinErrortVO> joinErrorList;
}
