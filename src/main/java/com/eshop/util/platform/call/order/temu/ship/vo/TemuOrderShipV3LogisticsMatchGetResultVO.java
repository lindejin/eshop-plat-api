package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetResultVO {
    //mostUsedExpressCompany	OBJECT	常用物流 可能为空
    private TemuOrderShipV3LogisticsMatchGetMostUsedExpressCompanyVO mostUsedExpressCompany;
    //usePricePrivileges	BOOLEAN	是否使用供价侧权益
    private Boolean usePricePrivileges;
    //list	LIST	TMS平台推荐物流列表
    private List<TemuOrderShipV3LogisticsMatchGetTmsVO> list;

}
