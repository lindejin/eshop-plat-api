package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentResultPackageInfoVO {
    //                "estimatedText": "预估₱71.75; PHP; 3-12 work days送达",
    private String estimatedText;
    //                "estimatedCurrencyCode": "PHP",
    private String estimatedCurrencyCode;
    //                "extendWeight": null,
    private String extendWeight;
    //                "dimensionUnit": "cm",
    private String dimensionUnit;
    //                "packageDeliveryType": 2,
    private Integer packageDeliveryType;
    //                "solutionText": null,
    private String solutionText;
    //                "warehouseName": "NYC-PH",
    private String warehouseName;
    //                "failReasonText": null,
    private String failReasonText;
    //                "reservationSn": null,
    private String reservationSn;
    //                "subPackageSnList": [
    //                ],
    //该包裹下的子包裹列表。
    //当包裹为主包裹时返回关联的子包裹，当包裹为子包裹时返回为空。
    private List<String> subPackageSnList;
    //                "mainPackageSn": "PK-3715182006108310058",
    private String mainPackageSn;
    //                "shipLogisticsType": "standard",
    private String shipLogisticsType;
    //                "signServiceId": null,
    private String signServiceId;
    //                "subPackageType": "MAIN",
    private String subPackageType;
    //                "trackingNumber": "JT0003192713969",
    private String trackingNumber;
    //                "channelId": 613786973679616,
    private Long channelId;
    //                "height": "1.00",
    private String height;
    //                "extendWeightUnit": null,
    private String extendWeightUnit;
    //                "pickupStartTime": null,
    private String pickupStartTime;
    //                "pickupEndTime": null,
    private String pickupEndTime;
    //                "shippingLabelStatus": 1,
    private Integer shippingLabelStatus;
    //                "canChangeToManualSend": true,
    private Boolean canChangeToManualSend;
    //                "packageSn": "PK-3715182006108310058",
    private String packageSn;
    //                "length": "30.00",
    private String length;
    //                "weight": "0.15",
    private String weight;
    //                "warningMessage": [
    //                ],
    // 提醒信息
    private List<String> warningMessage;
    //                "shipCompanyId": 998265498,
    private Long shipCompanyId;
    //                "warehouseId": "WH-10971324948630058",
    private String warehouseId;
    //                "width": "25.00",
    private String width;
    //                "orderSendInfoList": [
    //                    {
    //                        "quantity": 1,
    //                        "orderSn": "160-01121136323192676",
    //                        "goodsId": 601101395075042,
    //                        "parentOrderSn": "PO-160-01121117317752676",
    //                        "skuId": 17599646421135
    //                    }
    //                ],
    private List<TemuLogisticsShipmentResultOrderSendInfoVO> orderSendInfoList;
    //                "shippingCompanyName": "J&T Express (PH)",
    private String shippingCompanyName;
    //                "estimatedAmount": "₱71.75",
    private String estimatedAmount;
    //                "weightUnit": "kg"
    private String weightUnit;
}
