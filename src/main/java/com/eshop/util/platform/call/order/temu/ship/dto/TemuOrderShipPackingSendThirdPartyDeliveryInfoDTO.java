package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingSendThirdPartyDeliveryInfoDTO {

    //expectPickUpGoodsTime	INTEGER	否	预约取货时间
    private Long expectPickUpGoodsTime;
    //predictTotalPackageWeight	INTEGER	否	预估总包裹重量不能为空,单位克.总量必须大于等于1千克且为整千克值
    private Long predictTotalPackageWeight;
    //expressPackageNum	INTEGER	否	交接给快递公司的包裹数
    private Integer expressPackageNum;
    //pickupMethod	INTEGER	否	揽收方式 : 0代表默认 1代表自送
    private Integer pickupMethod;
    //tmsChannelId	INTEGER	否	TMS快递产品类型ID
    private Long tmsChannelId;
    //selfDeliverSitePhone	STRING	否	自送网点电话(使用平台推荐的自送物流商时必传)
    private String selfDeliverSitePhone;
    //selfDeliverSiteAddress	STRING	否	自送网点地址(使用平台推荐的自送物流商时必传)
    private String selfDeliverSiteAddress;
    //selfDeliverSiteUserCode	STRING	否	自送网点用户编码
    private String selfDeliverSiteUserCode;
    //expressDeliverySn	STRING	否	快递单号
    private String expressDeliverySn;
    //expressCompanyName	STRING	否	快递公司名称
    private String expressCompanyName;
    //predictId	INTEGER	否	预测ID
    private Long predictId;
    //selfDeliverSiteCompanyCode	STRING	否	自送网点公司编码
    private String selfDeliverSiteCompanyCode;
    //standbyExpress	BOOLEAN	否	是否是备用快递公司
    private Boolean standbyExpress;
    //expressCompanyId	INTEGER	否	快递公司Id
    private Long expressCompanyId;
}
