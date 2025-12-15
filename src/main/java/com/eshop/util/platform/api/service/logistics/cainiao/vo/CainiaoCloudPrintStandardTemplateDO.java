package com.eshop.util.platform.api.service.logistics.cainiao.vo;

@lombok.Getter
@lombok.Setter
public class CainiaoCloudPrintStandardTemplateDO {

    //standardTemplateUrl	string	256	true	https://cloudprint.daily.taobao.net/template/standard/82907/155	模板url
    private String standardTemplateUrl;
    //standardTemplateName	string	64	true	中通快递标准模板	模板名称
    private String standardTemplateName;
    //standardWaybillType	int	11	true	1	显示完整字段描述
    private Long standardWaybillType;
    //brandCode	string	64	false	SF	品牌字段
    private String brandCode;

}
