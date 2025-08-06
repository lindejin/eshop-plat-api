package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetMostUsedExpressCompanyVO {

    //servicerCode	STRING	服务商编码
    private String servicerCode;
    //expressCompanyId	INTEGER	快递公司Id
    private Long expressCompanyId;
    //expressCompanyName	STRING	快递公司名称[后续迭代为服务商名称]
    private String expressCompanyName;
    //canSaveChargeAmount	STRING	可节省费用 单位元
    private String canSaveChargeAmount;

}
