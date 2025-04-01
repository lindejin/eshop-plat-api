package com.eshop.util.platform.api.client.shopee;

/**
 * Shopee 错误码常量池
 * 命名风格：模块_错误类型_描述
 */
public final class ShopeeErrorConstants {
    // HTTP 协议层
    public static final String HTTP_STATUS_CODE = "shopee_http_status_code";
    public static final String STATUS_TEXT = "shopee_http_status_text";
    public static final String RAW_RESPONSE = "shopee_raw_response";

    // 业务语义增强
    public static final String BUSINESS_CODE = "shopee_biz_code";
    public static final String ERROR_TYPE = "shopee_error_type";

    // 诊断信息
    public static final String TIMESTAMP = "shopee_timestamp";
    public static final String DEBUG_ID = "shopee_debug_id";
}