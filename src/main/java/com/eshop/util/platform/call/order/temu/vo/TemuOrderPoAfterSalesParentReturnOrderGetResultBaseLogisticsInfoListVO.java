package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentReturnOrderGetResultBaseLogisticsInfoListVO {

    //carrierName	STRING	是	物流公司名称
    private String carrierName;
    //returnWarehouseType	INTEGER	是	返回退货仓类型1:平台仓2:商家仓
    private Integer returnWarehouseType;
    //returnWarehouseRegion1Name	STRING	是	退货仓所在国家地区名称
    private String returnWarehouseRegion1Name;
    //trackingNumber	STRING	是	逆向运单号
    private String trackingNumber;
}
