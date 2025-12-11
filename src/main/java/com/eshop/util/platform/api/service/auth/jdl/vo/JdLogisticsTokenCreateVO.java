package com.eshop.util.platform.api.service.auth.jdl.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
public class JdLogisticsTokenCreateVO extends BaseResponseVO {

    /**
     * 提取到外面方便处理
     */

    /**
     * "{
     * "accessExpire":"2022-11-30 16:09:18",
     * "accessToken":"85c8bb203a5d4afe873aec7fff8a46fb",
     * "clientId":"514827fb288844d0a87bc106da4bc676",
     * "code":"569baa267f1746f8a7c36dcb183d56d7",
     * "refreshExpire":"2022-11-30 16:09:18",
     * "refreshToken":"d2be7f5aef8043b9b40338aebfab3223",
     * "sellerId":"forever_swh"
     * }"
     */
    //参数名称	说明
    //accessExpire	当前accessToken过期时间
    private String accessExpire;
    //accessToken	当前accessToken值
    private String accessToken;
    //clientId	应用的AppKey，可从【控制台--应用概览】查看
    private String clientId;
    //refreshExpire	refreshToken过期时间
    private String refreshExpire;
    //refreshToken	refreshToken值
    private String refreshToken;
    //sellerId	授权账号的京东pin
    private String sellerId;
}
