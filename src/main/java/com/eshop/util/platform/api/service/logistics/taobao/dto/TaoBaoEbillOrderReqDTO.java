package com.eshop.util.platform.api.service.logistics.taobao.dto;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:13
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoEbillOrderReqDTO {
    //param_list	WaybillDetailQueryByWaybillCodeRequest[]	false	-	系统自动生成，包含具体查询参数
    private List<TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest> param_list;
    //  cp_code	String	true	POSTB	快递公司code（如：POSTB=邮政）
    //  object_id	String	true	1	请求id（用于幂等性控制）
    //  waybill_code	String	true	9890000066001	电子面单号（运单号）
}
