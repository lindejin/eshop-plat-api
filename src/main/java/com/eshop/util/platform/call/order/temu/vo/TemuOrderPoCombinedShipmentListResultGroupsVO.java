package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoCombinedShipmentListResultGroupsVO {
    //combinedShippingGroup	LIST	可合并发货的PO单组合
    private List<TemuOrderPoCombinedShipmentListResultGroupVO> combinedShippingGroup;
}
