package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageGetPackageInfoVO {

    //packageDetails	LIST	包裹明细
    private List<TemuOrderShipPackageGetPackageDetailVO> packageDetails;

    //skcNum	INTEGER	skc数量
    private Integer skcNum;
    //packageSn	STRING	包裹号
    private String packageSn;
    //productSkcId	INTEGER	skcId
    private Long productSkcId;

}
