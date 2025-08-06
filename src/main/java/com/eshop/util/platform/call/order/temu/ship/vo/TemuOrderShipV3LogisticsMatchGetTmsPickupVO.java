package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetTmsPickupVO {

    //selfDeliverSiteCompanyCode	STRING	自送网点公司编码
    private String selfDeliverSiteCompanyCode;
    //selfDeliverSitePhone	STRING	自送网点电话
    private String selfDeliverSitePhone;
    //selfDeliverSiteAddress	STRING	自送网点地址
    private String selfDeliverSiteAddress;
    //selfDeliverSiteUserCode	STRING	自送网点用户编码
    private String selfDeliverSiteUserCode;
}
