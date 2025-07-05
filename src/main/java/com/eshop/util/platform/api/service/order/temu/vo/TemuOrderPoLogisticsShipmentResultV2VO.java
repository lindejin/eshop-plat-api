package com.eshop.util.platform.api.service.order.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoLogisticsShipmentResultV2VO {

    //shipmentInfoDTO OBJECT[]	shipment result
    private List<TemuOrderPoLogisticsShipmentResultShipmentInfoV2VO> shipmentInfoDTO;
}
