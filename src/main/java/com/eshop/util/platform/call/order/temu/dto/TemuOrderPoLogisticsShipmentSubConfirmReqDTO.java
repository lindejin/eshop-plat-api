package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentSubConfirmReqDTO {

    //gatewayContext	OBJECT	否	网关参数
    private String gatewayContext;
    //mainPackageSn	STRING	是	主包裹号，前置已经发货的包裹号，可通过 bg.logistics.shipment.get接口获取
    private String mainPackageSn;
    //sendSubRequestList	LIST	否	需要补充的包裹信息
    private List<TemuOrderPoLogisticsShipmentSubConfirmSendSubRequestDTO> subRequestList;
}
