package com.eshop.util.platform.api.service.auth.xiaohongshu.vo;

@lombok.Getter
@lombok.Setter
public class XiaohongshuTokenVO {

    //参数名称	示例值	参数释义
    //accessToken	21d600****be8de0	访问令牌
    private String accessToken;
    //accessTokenExpiresAt	1612239430773	访问令牌过期时间(ms)
    private Long accessTokenExpiresAt;
    //refreshToken	867105****e77ff0bafb0	刷新令牌
    private String refreshToken;
    //refreshTokenExpiresAt	1612239430773	刷新令牌过期时间(ms)
    private Long refreshTokenExpiresAt;
    //sellerId	5a151****ee832	商家编码
    private String sellerId;
    //sellerName	开放平台测试店1专卖店	商家名
    private String sellerName;
    
}
