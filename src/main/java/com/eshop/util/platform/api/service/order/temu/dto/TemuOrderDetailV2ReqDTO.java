package com.eshop.util.platform.api.service.order.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderDetailV2ReqDTO {

    //parentOrderSn	INTEGER	是	父单号
    private String parentOrderSn;

    //fulfillmentTypeList  	STRING[]	否	子订单履约类型
    //支持枚举值：fulfillBySeller/fulfillByCooperativeWarehouse
    //1. 数组只传入fulfillBySeller，只返回卖家履约子订单列表
    //2. 数组只传入fulfillByCooperativeWarehouse，只返回合作仓履约子订单列表
    //3. 数组传入 fulfillBySeller 和 fulfillByCooperativeWarehouse ，返回卖家履约子订单列表+合作仓履约子订单列表
    //4. fulfillmentTypeList不传或者传了为空，默认返回卖家履约子订单列表
    private List<String> fulfillmentTypeList;
}
