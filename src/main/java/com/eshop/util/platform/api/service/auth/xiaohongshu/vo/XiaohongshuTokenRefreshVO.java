package com.eshop.util.platform.api.service.auth.xiaohongshu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class XiaohongshuTokenRefreshVO extends BaseResponseVO {

    //参数名称	参数类型	参数描述
    //error_code	number	返回值code
    private Integer error_code;
    //success	boolean	请求是否成功
    private Boolean success;
    //error_msg	string	错误信息
    private String error_msg;
    //data	object	-
    private XiaohongshuTokenVO data;

    /**
     * 提取到外面方便处理
     */
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
