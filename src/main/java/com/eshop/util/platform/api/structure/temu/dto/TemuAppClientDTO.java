package com.eshop.util.platform.api.structure.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuAppClientDTO {

    /**
     * app_key 已创建成功的应用标志app_key，联系对接运营颁发
     */
    private String appKey;

    /**
     * app_secret 已创建成功的应用标志app_secret，联系对接运营颁发
     */
    private String appSecret;

    /**
     * 用户授权令牌access_token，卖家中心—授权管理获取即可，运营会颁发对应线上测试店铺token
     */
    private String accessToken;

    /**
     * 区域环境，默认CN，可选值CN、US、EU，对应线上环境和测试环境
     */
    private String location;

    public String getEnvUrl() {
        if ("CN".equals(location)) {
            envUrl = ENV_CN;
        } else if ("EU".equals(location)) {
            envUrl = ENV_EU;
        } else if ("US".equals(location)) {
            envUrl = ENV_US;
        } else if ("GL".equals(location)) {
            envUrl = ENV_GL;
        }
        return envUrl;
    }

    /**
     * 环境 	http地址 	https地址
     */
    private String envUrl;


    //环境 	http地址 	https地址
    //正式环境 CN	无 	https://openapi.kuajingmaihuo.com/openapi/router
    private static final String ENV_CN = "https://openapi.kuajingmaihuo.com/openapi/router";
    //测试环境 CN	无	https://kj-openapi.temudemo.com/openapi/router
    private static final String ENV_CN_TEST = "https://kj-openapi.temudemo.com/openapi/router";
    //正式环境 US	无	https://openapi-b-us.temu.com/openapi/router
//    private static final String ENV_US = "https://openapi-b-us.temu.com/openapi/router";
    private static final String ENV_US = "https://us.vogocmerp.com/openapi/router";
    //测试环境 US	无	http://openapi-b-us.temudemo.com/openapi/router
    private static final String ENV_US_TEST = "http://openapi-b-us.temudemo.com/openapi/router";
    //正式环境 EU	无	https://openapi-b-eu.temu.com/openapi/router
    private static final String ENV_EU = "https://openapi-b-eu.temu.com/openapi/router";
    //测试环境 EU	无	http://openapi-b-eu.temudemo.com/openapi/router
    private static final String ENV_EU_TEST = "http://openapi-b-eu.temudemo.com/openapi/router";

    //正式环境 GL	无	https://us.vogocmerp.com/global/openapi/router
    private static final String ENV_GL = "https://us.vogocmerp.com/global/openapi/router";
}
