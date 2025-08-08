package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingMatchRespVO extends BaseResponseVO {

    // "totalItemNum": 400,
    private TemuOrderShipPackingMatchResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;

    //ext
    //shouldAddDeliveryOrderInfoList	LIST	需要勾选的相同发货地址的发货单列表（最多展示50个）
    private List<TemuOrderShipPackingMatchShouldAddInfo> shouldAddDeliveryOrderInfoList;
    //deliveryOrderSnNotPrintBox	LIST	未打印打包标签的发货单列表
    private List<String> deliveryOrderSnNotPrintBox;
    //skuSumWeight	INTEGER	勾选的发货单对应SKU总重量（商品货品侧SKU重） 单位克
    private Long skuSumWeight;

}
