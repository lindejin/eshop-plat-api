package com.eshop.util.platform.api.service.logistics.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateReqDTO {

    //sendType	INTEGER	True	SendType 0:All the products in one parent order are shipped in one package with one tracking number 1:Partical products in one parent order are shipped in multiple packages with multiple tracking numbers and all the products in one order should be shipped in one API call. 2:All the products in multiple parent orders are shipped in one package with one tracking number.
    /**
     * 发货类型：0-单个运单发货 1-拆成多个运单发货 2-合并发货
     */
    private Integer sendType;
    //shipLater	BOOLEAN	False	Ship Later TRUE: apply to create the package apply to create the tracking numbers from Temu-integrated carriers online. Mark this package as "ship later". FALSE: apply to create the package. apply to create the tracking numbers from Temu-integrated carriers online. apply to ship the package with these tracking numbers and mark this package as shipped.
    /**
     * 下call成功后是否延迟发货
     * TRUE：下call成功之后延迟发货
     * FALSE/不填：下call成功订单自动流转为已发货
     */
    private Boolean shipLater;
    //shipLaterLimitTime	STRING	False	The deadline for later shipment, with options being: 24, 48, 72, 96,120 hours.
    /**
     * 稍后发货兜底配置时间（单位:h），枚举：
     * 24, 48, 72, 96
     */
    private String shipLaterLimitTime;
    //sendRequestList	OBJECT[]	False	Package List Information
    /**
     * 包裹信息
     */
    private List<TemuLogisticsShipmentCreateSendRequest> sendRequestList;

}
