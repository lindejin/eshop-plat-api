package com.eshop.util.platform.api.service.logistics.taobao.dto;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:31
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest {

    //  cp_code	String	true	POSTB	快递公司code（如：POSTB=邮政）
    private String cp_code;
    //  object_id	String	true	1	请求id（用于幂等性控制）
    private String object_id;
    //  waybill_code	String	true	9890000066001	电子面单号（运单号）
    private String waybill_code;
}
