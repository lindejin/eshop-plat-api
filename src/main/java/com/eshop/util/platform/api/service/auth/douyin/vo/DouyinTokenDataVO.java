package com.eshop.util.platform.api.service.auth.douyin.vo;

@lombok.Getter
@lombok.Setter
public class DouyinTokenDataVO {
    //参数名称	参数类型	字段标签	示例值	参数描述
    //access_token	String	授权基础信息	5a3bd7d0-1b48-46d6-811e-7e05ace08a2f	token值。Tips：
    //1. 在access_token过期前1h之前，ISV使用refresh_token刷新时，会返回原来的access_token和refresh_token，但是二者有效期不会变；
    //2. 在access_token过期前1h之内，ISV使用refresh_token刷新时，会返回新的access_token和refresh_token，但是原来的access_token和refresh_token继续有效一个小时；
    //3. 在access_token过期后，ISV使用refresh_token刷新时，将获得新的access_token和refresh_token，同时原来的access_token和refresh_token失效；
    private String access_token;
    //expires_in	Int64	授权基础信息	412219354	过期时间(秒级时间戳)
    private Long expires_in;
    //refresh_token	String	授权基础信息	50b6ae40-ed8f-4b60-a4af-2ed743a4b903	刷新token值。用于刷新access_token的刷新令牌（有效期：14天）
    private String refresh_token;
    //scope	String	授权基础信息	SCOPE	范围
    private String scope;
    //shop_id	Int64	店铺基础信息	11111172	店铺ID
    private Long shop_id;
    //shop_name	String	店铺基础信息	李飞测试放心花人店一体	店铺名称
    private String shop_name;
    //authority_id	String	授权基础信息	3445403781179769176	授权ID
    private String authority_id;
    //auth_subject_type	String	授权基础信息	WuLiuShang	授权主体类型
    private String auth_subject_type;
    //encrypt_operator	String	授权基础信息	x123xxxxxxxxxx	操作店铺账号（加密），不支持解密
    private String encrypt_operator;
    //operator_name	String	授权基础信息	*磊	操作店铺账号昵称（脱敏）
    private String operator_name;
    //shop_biz_type	Int64	店铺基础信息	0	店铺业务类型。0：普通店铺，1：即时零售连锁店，2：即时零售个体店
    private Integer shop_biz_type;
    //toutiao_id	String	授权基础信息	121212	token生成对应的账号
    private String toutiao_id;
    //token_type	Int64	授权基础信息	0	0表示token是由主账号生成，1表示token由子账号生成
    private Integer token_type;
}
