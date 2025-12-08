package com.eshop.util.platform.api.service.auth.jdl.vo;


@lombok.Getter
@lombok.Setter
public class JdLogisticsTokenVO {
    //参数名称	说明
    //accessExpire	当前accessToken过期时间
    private Long accessExpire;
    //accessToken	当前accessToken值
    private String accessToken;
    //clientId	应用的AppKey，可从【控制台--应用概览】查看
    private String clientId;
    //refreshExpire	refreshToken过期时间
    private Long refreshExpire;
    //refreshToken	refreshToken值
    private String refreshToken;
    //sellerId	授权账号的京东pin
    private String sellerId;
}
