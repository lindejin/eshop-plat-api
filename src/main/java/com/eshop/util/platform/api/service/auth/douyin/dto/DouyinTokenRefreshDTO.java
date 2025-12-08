package com.eshop.util.platform.api.service.auth.douyin.dto;

@lombok.Getter
@lombok.Setter
public class DouyinTokenRefreshDTO {
    //参数名称	参数类型	是否必须	示例值	参数描述
    //refresh_token	String	是	82bdc687-eff1-4f63-8444-0b43086c25fd	用于刷新access_token的刷新令牌；有效期：14 天；
    private String refresh_token;
    //grant_type	String	是	refresh_token1	授权类型；请传入默认值：refresh_token
    private String grant_type;
}
