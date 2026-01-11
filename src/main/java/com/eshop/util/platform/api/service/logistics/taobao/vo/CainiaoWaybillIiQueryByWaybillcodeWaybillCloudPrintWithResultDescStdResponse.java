package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 22:03
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescStdResponse {

    //字段名	类型	示例值	说明
    //error_code	String	x	错误码
    //error_message	String	x	错误信息
    //object_id	String	x	请求ID
    //success	Boolean	x	请求是否成功
    //waybill_cloud_print_response	WaybillCloudPrintResponse	x	面单打印响应结构体


    private String error_code;
    private String error_message;
    private String object_id;
    private Boolean success;
    private CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintResponse waybill_cloud_print_response;

}
