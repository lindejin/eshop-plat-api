package com.eshop.util.platform.api.service.logistics.taobao.vo;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:14
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvResourcesGetCloudPrintBaseResult {

    //字段名	类型	示例值	说明
    //resource_list	IsvResourceDo[]	data	资源列表
    //error_code	String	102	错误码
    //error_message	String	获取资源信息失败	错误消息
    //success	Boolean	false	状态

    private List<CainiaoCloudprintIsvResourcesGetIsvResourceDo> resource_list;
    private String error_code;
    private String error_message;
    private Boolean success;

}
