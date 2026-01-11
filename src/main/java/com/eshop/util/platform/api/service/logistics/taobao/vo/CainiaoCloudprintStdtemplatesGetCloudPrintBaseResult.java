package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 21:39
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintStdtemplatesGetCloudPrintBaseResult {

    //字段名	类型	示例值	说明
    //datas	StandardTemplateResult[]	-	所有cp的标准模板
    //error_code	String	ERROR_GET	错误码
    //error_message	String	获取面单失败	错误信息
    //success	Boolean	false	是否成功


    private CainiaoCloudprintStdtemplatesGetStandardTemplateResult datas;
    private String error_code;
    private String error_message;
    private Boolean success;
}
