package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsCompaniesGetReqDTO {
    //regionId	INTEGER	是	配送地址的regionId，默认传参211，含义是代表美国站点
    private Long regionId;
}
