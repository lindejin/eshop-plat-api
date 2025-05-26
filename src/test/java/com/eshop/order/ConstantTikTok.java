package com.eshop.order;

/**
 * Tiktok常量类
 *
 * @author sheng
 * @date 2023-09-13 13:19
 */
public final class ConstantTikTok {

    ////tilTok 授权域名(沙盒)
    //public static final String DOMAIN_NAME = "https://auth-sandbox.tiktok-shops.com";
    ////tilTok 业务域名(沙盒)
    //public static final String OPEN_API = "https://open-api-sandbox.tiktokglobalshop.com";
    //tilTok 授权域名 (正式)
    public static final String DOMAIN_NAME = "https://auth.tiktok-shops.com";
    //tilTok 业务域名(正式)
    public static final String OPEN_API = "https://open-api.tiktokglobalshop.com";
    //TK 代理域名
    //public static final String OPEN_API = "https://us.vogocmerp.com/tiktokglobalshop";

    //接口版本号
    public static final String VERSION = "202212";
    //生成服务授权URL
    public static final String AUTHORIZE_URL = DOMAIN_NAME + "/oauth/authorize";
    //获取access_token URl
    public static final String GET_ACCESS_TOKEN_URL = DOMAIN_NAME + "/api/v2/token/get";
    //刷新Token  URL
    public static final String REFRESH_TOKEN_URL = DOMAIN_NAME + "/api/v2/token/refresh";
    //获取授权店铺信息URL
    public static final String GET_AUTHORIZED_SHOP_INFO_URL = "/api/shop/get_authorized_shop";
}
