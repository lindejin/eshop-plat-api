package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackageGetReqDTO {

    //请求参数说明
    //参数接口	参数类型	是否必填	说明
    //deliveryOrderSn	STRING	是	发货单号
    private String deliveryOrderSn;
}
