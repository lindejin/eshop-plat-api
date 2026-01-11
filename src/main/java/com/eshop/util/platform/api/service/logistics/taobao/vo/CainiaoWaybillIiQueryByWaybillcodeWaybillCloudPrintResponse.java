package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 22:03
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintResponse {
    //字段名	类型	示例值	说明
    //print_data	String	x	面单信息（通常为打印内容的 Base64 编码或 JSON 格式）
    //waybill_code	String	x	面单号（快递单号）
    //parent_waybill_code	String	x	快运子母件中的母单号（用于关联主单）

    private String print_data;
    private String waybill_code;
    private String parent_waybill_code;
}
