package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TemuOrderPoCombinedShipmentListResultResultVO {

    //combinedShippingGroups	LIST	可合并发货的PO单组合列表
    private List<TemuOrderPoCombinedShipmentListResultGroupsVO> combinedShippingGroups;
}
