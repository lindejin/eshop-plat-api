package com.eshop.util.platform.api.service.logistics.cainiao.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class CainiaoCloudPrintStandardTemplateResultVO {

    //cpCode	string	64	true	YTO	cpCode
    private String cpCode;
    //standardTemplateDOs	List<StandardTemplateDO>	- -	true	- -	cpCode 对应的模板列表
    private List<CainiaoCloudPrintStandardTemplateDO> standardTemplateDOs;
}
