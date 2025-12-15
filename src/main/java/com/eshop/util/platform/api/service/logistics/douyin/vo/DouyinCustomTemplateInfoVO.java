package com.eshop.util.platform.api.service.logistics.douyin.vo;

@lombok.Getter
@lombok.Setter
public class DouyinCustomTemplateInfoVO {

    //参数名称	参数类型	是否必须	示例值	参数描述
    //custom_template_code	String	否	123	自定义区模板code
    private String custom_template_code;

    //custom_template_name	String	否	muban	自定义区模板名称
    private String custom_template_name;

    //parent_template_code	String	否	1	父模板code(查询标准模板API中返回的template_code)
    private String parent_template_code;

    //custom_template_url	String	否	1	自定义区模板url(URL资源的内容为xml格式的报文)
    private String custom_template_url;

    //custom_template_key_list	List	否	1	customTemplateKeyList（打印项中字段列表）
    private String custom_template_key_list;

    //custom_template_id	Int64	否	1	自定义区模板id
    private Long custom_template_id;

    //parent_template_id	Int64	否	1	父模板id
    private Long parent_template_id;

}
