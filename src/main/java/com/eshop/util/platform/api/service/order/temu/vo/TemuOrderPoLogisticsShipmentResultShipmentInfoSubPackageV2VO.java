package com.eshop.util.platform.api.service.order.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoLogisticsShipmentResultShipmentInfoSubPackageV2VO {
    //trackingNumber	STRING	否	运单号
    private String trackingNumber;
    //carrierId	LONG	否	物流公司ID
    private Long carrierId;
    //carrierName	STRING		物流公司名称
    private String carrierName;
    //packageSn	STRING	否	包裹号
    private String packageSn;
    //packageDeliveryType	INTEGER	否	发货包裹履约类型，新增枚举值3和4
    //● 1：导入运单发货
    //● 2：在线下单发货
    //● 3：合作对接仓导入运单发货
    //● 4：合作对接仓在线下单发货
    private Integer packageDeliveryType;
}
