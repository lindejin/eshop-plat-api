package com.eshop.util.platform.api.service.logistics.jdl.vo;


@lombok.Getter
@lombok.Setter
public class JdlTemplateCustomTemplateDto {
    //customTemplateCode	String	sales002	模板编码，长度2-20
    //customTemplateName	String	销售出库单002	模板名称，长度50
    //customTemplateUrl	String	https://template-content.jd.com/template-open?templateCode=sales002	模板URL，长度255

    private String customTemplateCode;
    private String customTemplateName;
    private String customTemplateUrl;
}
