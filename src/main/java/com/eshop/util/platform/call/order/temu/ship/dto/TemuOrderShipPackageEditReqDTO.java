package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageEditReqDTO {
    //参数接口	参数类型	是否必填	说明
    //deliverOrderDetailInfos	LIST	是	发货单详情列表
    private List<TemuOrderShipPackageEditDeliverOrderDetailInfoDTO> deliverOrderDetailInfos;
    //packageInfos	LIST	是	包裹信息列表
    private List<TemuOrderShipPackageEditPackageInfosDTO> packageInfos;
    //deliveryOrderSn	STRING	是	发货单号
    private String deliveryOrderSn;

}
