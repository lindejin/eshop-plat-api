package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushDeliveryRequirements {
    //deliveryType
    //投递时效要求
    //否
    //订单-标记|多标签（部分）
    //订单标签含“淘宝闪购同城配”则推TCPS
    private String deliveryType;

    //scheduleType
    //发货服务类型
    //否
    //订单-标记|多标签（部分）
    //订单标签含“小时达”则推送106；
    //如果是淘宝闪购同城配业务，则固定传“101”当日达
    private Integer scheduleType;
    
}
