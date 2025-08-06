package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetTmsVO {

    //maxSupplierChargeAmount	STRING	最大预估商家承担运费（单位元）
    private String maxSupplierChargeAmount;
    //advantageDescList	LIST	该物流相比常用物流的优势点 可能为空
    private List<String> advantageDescList;
    //hasUsedThisLogistics	BOOLEAN	供应商是否使用过该物流
    private Boolean hasUsedThisLogistics;
    //tmsPickupVOList	LIST	揽收信息列表
    private List<TemuOrderShipV3LogisticsMatchGetTmsPickupVO> tmsPickupVOList;

    //carrierAttention	STRING	承运注意事项
    private String carrierAttention;

    //promisedDeliveryHourTime	STRING	承诺送达时间
    private String promisedDeliveryHourTime;
    //minSupplierChargeAmount	STRING	最小预估商家承担运费（单位元）
    private String minSupplierChargeAmount;

    //channelScheduleTimeList	LIST	可预约揽收时间
    private List<TemuOrderShipV3LogisticsMatchGetChannelScheduleTimeVO> channelScheduleTimeList;

    //pickupMethod	INTEGER	揽收方式 : 0代表默认 1代表自送
    private Integer pickupMethod;

    //expressCompanyId	INTEGER	快递公司Id
    private Long expressCompanyId;
    //expressCompanyName	STRING	快递公司名称
    private String expressCompanyName;

    //predictId	INTEGER	预测ID
    private Long predictId;
}
