package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV2GetPackageReceiveInfoVO {

    //receiveTime	INTEGER	收货时间
    private Long receiveTime;
    //packageSn	STRING	包裹号
    private String packageSn;
}
