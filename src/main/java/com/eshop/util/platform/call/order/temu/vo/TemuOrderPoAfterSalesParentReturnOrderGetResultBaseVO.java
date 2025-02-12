package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentReturnOrderGetResultBaseVO {

    //logisticsInfoList	LIST	是	退货物流信息
    private List<TemuOrderPoAfterSalesParentReturnOrderGetResultBaseLogisticsInfoListVO> logisticsInfoList;
}
