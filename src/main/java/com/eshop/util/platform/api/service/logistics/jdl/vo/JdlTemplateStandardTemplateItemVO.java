package com.eshop.util.platform.api.service.logistics.jdl.vo;

@lombok.Getter
@lombok.Setter
public class JdlTemplateStandardTemplateItemVO {

    //standardTemplateCode	String	jdkd76x130	模板编码，长度2-20
    //standardTemplateName	String	京东快递标准模板76x130	模板名称，长度50
    //standardTemplateUrl	String	https://template-content.jd.com/template-code?tempCode=jdkd76x130	模板URL，长度255

    private String standardTemplateCode;
    private String standardTemplateName;
    private String standardTemplateUrl;
}
