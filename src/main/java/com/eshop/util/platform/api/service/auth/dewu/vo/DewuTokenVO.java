package com.eshop.util.platform.api.service.auth.dewu.vo;

import java.util.Set;

@lombok.Getter
@lombok.Setter
public class DewuTokenVO {
    //    access_token	access_token
    //    access_token_expires_in	有效期（秒）
    //    refresh_token	refresh_token	在有效期内可以用刷新令牌重新刷新access_token
    //    refresh_token_expires_in	有效期（秒）
    //    scope	范围	这里没有实际作用
    //    open_id	open_id	该应用下多次授权都是同一个openId

    private String open_id;
    private String access_token;
    private String refresh_token;
    private Long access_token_expires_in;
    private Long refresh_token_expires_in;
    private Set<String> scope;
}
