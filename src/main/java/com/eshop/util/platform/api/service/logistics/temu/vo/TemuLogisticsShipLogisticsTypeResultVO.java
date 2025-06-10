package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipLogisticsTypeResultVO {
    //         "regionId": 160,
    private Long regionId;
    //        "shipLogisticsTypeInfoDTOList": [
    //            {
    //                "shipLogisticsType": "standard",
    //                "shippingCompanyName": "J&T Express (PH)",
    //                "shipCompanyId": 998265498
    //            }
    //        ]
    private List<TemuLogisticsShipLogisticsTypeResultInfoVO> shipLogisticsTypeInfoDTOList;
}
