package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageEditPackageInfosDTO {
    //packageDetailSaveInfos	LIST	是	包裹明细
    private List<TemuOrderShipPackageEditPackageDetailSaveInfoDTO> packageDetailSaveInfos;
}
