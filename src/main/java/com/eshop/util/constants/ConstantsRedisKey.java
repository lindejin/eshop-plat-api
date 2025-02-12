package com.eshop.util.constants;

/**
 * @Version 1.0
 * @Author:ldj
 * @Date:2021/8/11
 * @Content: 静态redis key
 */
public class ConstantsRedisKey {
    /**
     * 电商关联 通行令牌token redis key
     */
    public static final String REDIS_TOKEN_EC_JOIN = "join:token:ec:";
    public static final String REDIS_TOKEN_MERCHANT_EC_JOIN = "join:token:merchant:ec:";

    /**
     * access 电商关联 通行令牌token redis key
     */
    public static final String REDIS_TOKEN_EC_ACCESS_JOIN = "join:token:ec:access:";
    public static final String REDIS_TOKEN_MERCHANT_EC_ACCESS_JOIN = "join:token:merchant:ec:access:";

    /**
     * refresh 电商关联 通行令牌token redis key
     */
    public static final String REDIS_TOKEN_EC_REFRESH_JOIN = "join:token:ec:refresh:";
    public static final String REDIS_TOKEN_MERCHANT_EC_REFRESH_JOIN = "join:token:merchant:ec:refresh:";
}
