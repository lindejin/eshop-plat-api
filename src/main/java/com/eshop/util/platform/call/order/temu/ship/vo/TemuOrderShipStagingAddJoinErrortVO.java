package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.Map;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingAddJoinErrortVO {
    //joinErrorSubPurchaseOrderSn	STRING	加入发货台失败的发货单号
    private String joinErrorSubPurchaseOrderSn;
    //extraInfoMap	MAP	附加信息字段
    private Map<Object, Object> extraInfoMap;
    //errorCode	INTEGER	错误码
    private Integer errorCode;
    //errorMsg	STRING	错误信息
    private String errorMsg;
}
