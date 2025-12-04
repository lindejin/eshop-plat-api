package com.eshop.util.platform.api.service.auth.douyin.dto;

@lombok.Getter
@lombok.Setter
public class DouyinTokenCreateDTO {

    //参数名称	参数类型	是否必须	示例值	参数描述
    //code	String	否	82bdc687-eff1-4f63-8444-0b43086c25fd	授权码；参数必传，工具型应用: 传code值；自用型应用:传""
    private String code;
    //grant_type	String	是	authorization_code	授权类型 ；【工具型应用:authorization_code 自用型应用:authorization_self】，如果自用型应用有授权code，传authorization_code
    private String grant_type;
    //test_shop	String	否	2	判断测试店铺标识 ，非必传，若新增测试店铺传1，若不是则不必传
    private String test_shop;
    //shop_id	String	否	17239	店铺ID，抖店自研应用使用。当auth_subject_type不为空时，该字段请勿传值，请将值传入到auth_id字段中
    private String shop_id;
    //auth_id	String	否	112334	授权id，配合auth_subject_type字段使用。当auth_subject_type不为空时，请使用auth_id字段传值，shop_id请勿使用。
    private String auth_id;
    //auth_subject_type	String	否	WuLiuShang	授权主体类型，配合auth_id字段使用，YunCang -云仓；WuLiuShang -物流商；WLGongYingShang -物流供应商；MiniApp -小程序；MCN-联盟MCN机构；DouKe-联盟抖客 ；Colonel-联盟团长
    private String auth_subject_type;
}
