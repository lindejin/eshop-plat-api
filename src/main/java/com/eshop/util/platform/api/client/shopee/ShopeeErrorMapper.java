package com.eshop.util.platform.api.client.shopee;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * 将HTTP状态码映射为Shopee业务错误码
 */
public class ShopeeErrorMapper {
    private static final Map<HttpStatus, String> ERROR_CODE_MAPPING = ImmutableMap.of(
            HttpStatus.BAD_REQUEST, "SHOPEE-4001",
            HttpStatus.UNAUTHORIZED, "SHOPEE-4011",
            HttpStatus.FORBIDDEN, "SHOPEE-4031",
            HttpStatus.TOO_MANY_REQUESTS, "SHOPEE-4291"
    );

    public static String getBusinessErrorCode(HttpStatus status) {
        return ERROR_CODE_MAPPING.getOrDefault(status, "SHOPEE-0000");
    }
}
