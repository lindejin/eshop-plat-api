package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingSendThirdPartyExpressDeliveryInfoDTO {

    //expressPackageNum	INTEGER	否	发货总箱数
    private Integer expressPackageNum;
    //expressCompanyId	INTEGER	是	快递公司Id
    private Long expressCompanyId;
    //expressDeliverySn	STRING	是	快递单号
    private String expressDeliverySn;
    //expressCompanyName	STRING	是	快递公司名称
    private String expressCompanyName;
}
