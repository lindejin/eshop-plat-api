package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateResultVO {

    //packageSnList	STRING[]	Package Number List
    private List<String> packageSnList;
    //shipLaterLimitTime	STRING	The deadline for later shipment, with options being: 24, 48, 72, 96 hours.
    private String shipLaterLimitTime;
}
