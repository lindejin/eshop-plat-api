package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageGetResultVO {

    //packageInfo	LIST	包裹信息
   private List<TemuOrderShipPackageGetPackageInfoVO> packageInfo;
}
