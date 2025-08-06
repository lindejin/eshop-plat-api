package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipOrderV3CreateReqDTO {

    //参数接口	参数类型	是否必填	说明
    //deliveryOrderCreateGroupList	LIST	是	发货单创建组列表
    private List<TemuOrderShipOrderV3CreateDeliveryDTO> deliveryOrderCreateGroupList;
}
