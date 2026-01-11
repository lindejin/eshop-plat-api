package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:50
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintCustomaresGetCloudPrintBaseResult {

    //字段名	类型	示例值	说明
    //datas	CustomAreaResult[]	数据	数据列表
    //error_code	String	ERROR_GET	系统自动生成
    //error_message	String	获取自定义区失败	系统自动生成
    //success	Boolean	false	系统自动生成

    //
    private List<CainiaoCloudprintCustomaresGetCustomAreaResult> datas;
    private String error_code;
    private String error_message;
    private Boolean success;
}
