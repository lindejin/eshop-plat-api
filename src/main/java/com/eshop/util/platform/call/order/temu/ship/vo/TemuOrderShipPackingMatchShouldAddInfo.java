package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingMatchShouldAddInfo {

    //supplierId	INTEGER	供应商id
    private Long supplierId;
    //deliveryOrderSn	STRING	发货单号
    private String deliveryOrderSn;
}
