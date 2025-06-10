package com.eshop.util.platform.api.service.logistics.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipLogisticsTypeResultInfoVO {
    //          {
    //                "shipLogisticsType": "standard",
    /**
     * 物流类型
     */
    private String shipLogisticsType;
    //                "shippingCompanyName": "J&T Express (PH)",
    /**
     * 物流公司名称
     */
    private String shippingCompanyName;

    //                "shipCompanyId": 998265498
    /**
     * 物流公司编号
     */
    private Long shipCompanyId;

    //            }
}
