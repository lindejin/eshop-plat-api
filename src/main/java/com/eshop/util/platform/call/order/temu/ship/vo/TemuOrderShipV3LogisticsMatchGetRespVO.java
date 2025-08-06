package com.eshop.util.platform.call.order.temu.ship.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetRespVO extends BaseResponseVO {
    // "totalItemNum": 400,
    private TemuOrderShipV3LogisticsMatchGetResultVO result;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;



    //ext
    //mostUsedExpressCompany	OBJECT	常用物流 可能为空
    private TemuOrderShipV3LogisticsMatchGetMostUsedExpressCompanyVO mostUsedExpressCompany;
    //usePricePrivileges	BOOLEAN	是否使用供价侧权益
    private Boolean usePricePrivileges;
    //list	LIST	TMS平台推荐物流列表
    private List<TemuOrderShipV3LogisticsMatchGetTmsVO> list;
}
