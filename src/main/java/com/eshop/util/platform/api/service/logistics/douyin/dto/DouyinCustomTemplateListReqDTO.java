package com.eshop.util.platform.api.service.logistics.douyin.dto;

@lombok.Getter
@lombok.Setter
public class DouyinCustomTemplateListReqDTO {

    //参数名称	参数类型	是否必须	示例值	参数描述
    //logistics_code	String	否	shunfeng	物流服务商编码（若为空代表查询全部）
    private String logistics_code;
}
