package com.eshop.cainiao.oauth;


import okhttp3.HttpUrl;

public class AuthorizationUrlBuilder {

    public static String buildAuthorizationUrl(String oauthUrl, String appKey, String extInfo, String redirectUrl) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(oauthUrl).newBuilder();

        // 添加必需的isvAppKey参数
        urlBuilder.addQueryParameter("isvAppKey", appKey);

        // 添加可选的ext参数 (如果提供)
        if (extInfo != null && !extInfo.isEmpty()) {
            urlBuilder.addQueryParameter("ext", extInfo);
        }

        // 添加重定向URL
        urlBuilder.addQueryParameter("redirectUrl", redirectUrl);

        return urlBuilder.build().toString();
    }

    public static void main(String[] args) {
        String oauthUrl = "https://lcp.cloud.cainiao.com/permission/isv/grantpage_tb.do";
        // 在Activity或Fragment中使用
        String appKey = "942402";
        String extInfo = "custom_info"; // 可选
//        String extInfo = null; // 可选
        String redirectUrl = "https://open-dev-boss-api.worthfind.com/auth/authorize/cainiao/authcallback"; // 确保域名已配置

        System.out.println(AuthorizationUrlBuilder.buildAuthorizationUrl(oauthUrl, appKey, extInfo, redirectUrl));
    }
}