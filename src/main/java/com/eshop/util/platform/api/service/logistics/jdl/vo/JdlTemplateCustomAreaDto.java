package com.eshop.util.platform.api.service.logistics.jdl.vo;

@lombok.Getter
@lombok.Setter
public class JdlTemplateCustomAreaDto {

    //standardTemplateCode	String	jdkd76x130	标准区域模板编码，长度2-20
    //standardTemplateName	String	京东快递标准模板76x130	标准区域模板名称，长度50
    //standardTemplateUrl	String	https://template-content.jd.com/template-code?tempCode=jdkd76x130	标准区域模板URL，长度255
    //customAreaCode	String	customer002	自定义区模板编码，长度2-20
    //customAreaName	String	商品清单自定义区002	自定义区模板名称，长度50
    //customAreaUrl	String	https://template-content.jd.com/template-open?templateCode=customer002	自定义区模板URL，长度255


    private String standardTemplateCode;
    private String standardTemplateName;
    private String standardTemplateUrl;
    private String customAreaCode;
    private String customAreaName;
    private String customAreaUrl;
}
