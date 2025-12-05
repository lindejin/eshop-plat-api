package com.eshop.jd;

import okhttp3.HttpUrl;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JdOAuthHelper {

    private static String clientId = "AB743CB2EF26BC86270A24F78B3ED232";

    private static String redirectUri = "https://218.85.121.66:2677/auth/authorize/jst/authcallback";

    private static String environment = "prod";


    // 构建授权URL
    public static String buildAuthorizationUrl() {
        // 获取环境对应的域名
        String baseUrl = "prod".equals(environment) ?
                "https://oauth.jdl.com/oauth/authorize" :
                "https://uat-oauth.jdl.com/oauth/authorize";

        String state = "ccc";
        // 使用OkHttp的HttpUrl.Builder确保URL安全构建
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("oauth.jdl.com") // 先使用固定host，后面根据环境替换
                .addPathSegment("oauth")
                .addPathSegment("authorize")
                .addQueryParameter("client_id", clientId)
                .addQueryParameter("redirect_uri", redirectUri)
                .addQueryParameter("response_type", "code")
                .addQueryParameter("state", state)
                .build();

        // 根据环境替换域名
        String finalUrl = url.toString().replace("oauth.jdl.com",
                "prod".equals(environment) ? "oauth.jdl.com" : "uat-oauth.jdl.com");

        return finalUrl;
    }

    public static void main(String[] args) {
        System.out.println(buildAuthorizationUrl());


        //token具有有效期，请关注授权到期时间，授权到期时间与绑定到期时间一致。也可设置自动刷新token机制， 详见文档
        //授权商家
        //BAGSMART旗舰店
        //商家编号
        //687349
        //应用名称
        //维发自研ERP
        //appKey
        //AB743CB2EF26BC86270A24F78B3ED232
        //token
        //796522b06d07422ab5dce1415eff90a4yja2
        //到期时间
        //2026-11-19 11:50:40
    }

}
