package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipDeliveryOrderCreatePackageInfo {

    //packageDetailSaveInfos	LIST	是	包裹明细
    private List<TemuOrderShipDeliveryOrderCreatePackageDetailInfo> packageDetailSaveInfos;
}
