package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderV3CreateRespVO extends BaseResponseVO {

    // "totalItemNum": 400,
    private TemuOrderShipOrderV3CreateResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //ext
    //cancelUrgencyTypeSubPurchaseOrderSnList	LIST	取消急采标的采购单列表
    private List<String> cancelUrgencyTypeSubPurchaseOrderSnList;
    //deliveryOrders	LIST	创建成功的发货单列表
    private List<String> deliveryOrders;
    //isUrgencyType	BOOLEAN	是否是急采
    private Boolean isUrgencyType;
    //cancelUrgencyType	BOOLEAN	是否有取消急采标
    private Boolean cancelUrgencyType;
}
