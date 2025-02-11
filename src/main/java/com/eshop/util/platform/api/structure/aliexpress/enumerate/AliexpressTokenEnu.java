package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/29 18:19
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressTokenEnu {
    //request.setApiName("/auth/token/security/create");
    //为调用 API 安全生成access_token
    TOKEN_SECURITY_CREATE("/auth/token/security/create"),
    //request.setApiName("/auth/token/create");
    //生成调用api的access_token
    TOKEN_CREATE("/auth/token/create"),
    //request.setApiName("/auth/token/security/refresh");
    //刷新安全令牌
    TOKEN_SECURITY_REFRESH("/auth/token/security/refresh"),
    //request.setApiName("/auth/token/refresh");
    //刷新access_token
    TOKEN_REFRESH("/auth/token/refresh");

    private final String apiName;

    AliexpressTokenEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
