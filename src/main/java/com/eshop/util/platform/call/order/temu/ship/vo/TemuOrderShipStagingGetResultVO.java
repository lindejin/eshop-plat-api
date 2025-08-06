package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetResultVO {
    //total	INTEGER	-
    private Integer total;
    //list	LIST	-
    private List<TemuOrderShipStagingGetVO> list;
}
