package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:26
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvtemplatesGetCloudPrintBaseResult {

    //字段名	类型	示例值	说明
    //datas	CustomTemplateResult[]	data	数据列表
    //error_code	String	601	错误码
    //error_message	String	获取模板失败	错误消息
    //success	Boolean	false	是否成功

    private List<CainiaoCloudprintIsvtemplatesGetCustomTemplateResult> datas;
    private String error_code;
    private String error_message;
    private Boolean success;
}
