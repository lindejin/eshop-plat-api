package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsCompaniesGetResultResultVO {
    //items	OBJECT	否
    private List<TemuOrderPoLogisticsCompaniesGetResultResultItemsVO> items;
}
