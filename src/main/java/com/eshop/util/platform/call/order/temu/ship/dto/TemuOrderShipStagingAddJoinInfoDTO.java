package com.eshop.util.platform.call.order.temu.ship.dto;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingAddJoinInfoDTO {
    //deliveryAddressType	INTEGER	是	发货地址类型 1-内地 2-香港
    private Integer deliveryAddressType;
    //subPurchaseOrderSn	STRING	是	备货子单号
    private String subPurchaseOrderSn;
}
