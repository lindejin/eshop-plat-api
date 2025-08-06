package com.eshop.util.platform.call.order.temu.order.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentResultResultVO {

    //shipmentInfoDTO	LIST 	否
    private List<TemuOrderPoLogisticsShipmentShipmentInfoDTOVO> shipmentInfoDTO;
}
