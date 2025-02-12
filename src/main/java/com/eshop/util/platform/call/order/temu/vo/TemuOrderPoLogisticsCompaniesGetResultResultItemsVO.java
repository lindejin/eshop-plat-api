package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsCompaniesGetResultResultItemsVO {

    //logisticsServiceProviderId	INTEGER   	否	服务商ID
    private Long logisticsServiceProviderId;
    //logisticsServiceProviderName	STRING	否	服务商名称
    private String logisticsServiceProviderName;
    //logisticsBrandName	STRING	否	服务品牌名称
    private String logisticsBrandName;
}
