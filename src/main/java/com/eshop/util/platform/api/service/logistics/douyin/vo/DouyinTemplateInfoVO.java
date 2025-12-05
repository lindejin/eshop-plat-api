package com.eshop.util.platform.api.service.logistics.douyin.vo;

@lombok.Getter
@lombok.Setter
public class DouyinTemplateInfoVO {

    //字段名	类型	示例值	描述
    //template_id	Int64	14	模版id
    private Long template_id;
    //template_code	String	ems_100_180	模版编码
    private String template_code;
    //template_name	String	EMS二联单	模版名称
    private String template_name;
    //template_url	String	https://lf3-cm.ecombdstatic.com/obj/logistics-davinci/template/template_ems100.xml	模版URL
    private String template_url;
    //version	Int16	1	版本
    private Integer version;
    //template_type	Int16	2	模版类型； 1-一联单 2-二联单
    private Integer template_type;
    //perview_url	String	https://lf9-cm.ecombdstatic.com/obj/logistics-davinci/preview/jt_100_180.png	预览URL
    private String perview_url;
}
