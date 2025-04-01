package com.eshop.util.platform.api.client.shopee;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;
import java.util.Set;

/**
 * Shopee HTTP 异常处理器
 * 职责：统一处理来自Shopee API的HTTP协议层异常
 */
@Slf4j
public class ShopeeHttpErrorProcessor {


    /**
     * HTTP 403 Forbidden 是客户端错误状态码，表示服务器已收到请求并理解请求内容，但拒绝执行该请求。
     * 与401 Unauthorized不同，403 错误发生在用户身份已验证但权限不足时。
     * 401 Unauthorized。401是未认证，而403是已认证但权限不足。
     */

    /**
     * 排除关键状态码说明
     * 不应重试的4xx错误
     * 状态码	原因	修复方式
     * 400	客户端请求语法错误	修改请求参数
     * 401	身份认证失败	更新授权令牌
     * 403	权限不足	申请对应接口权限
     * 404	资源不存在	检查请求路径
     */

    // 直接返回的HTTP状态码
    private static final Set<HttpStatus> RETURN_STATUSES = ImmutableSet.of(
            HttpStatus.FORBIDDEN          // 403
    );

    public static boolean shouldReturn(HttpClientErrorException ex) {
        return RETURN_STATUSES.contains(ex.getStatusCode());
    }

    // 错误信息标准化构建器
    public static JSONObject buildStandardizedError(HttpClientErrorException ex) {
        try {
            JSONObject errorResponse = null;
            if (shouldReturn(ex)) {
                errorResponse = parseJsonPrimary(ex);
            } else {
                errorResponse = parseJsonFallback(ex);
            }
            logErrorForMonitoring(ex); // 监控埋点
            return errorResponse;
        } catch (JSONException e) {
            return buildFallbackError(ex); // 兜底错误构造
        }
    }

    /**
     * 标准解析
     */
    private static JSONObject parseJsonPrimary(HttpClientErrorException ex) {
        return JSON.parseObject(ex.getResponseBodyAsString(), Feature.DisableCircularReferenceDetect);
    }

    /**
     * 宽松模式解析（容错处理）
     */
    private static JSONObject parseJsonFallback(HttpClientErrorException ex) {
        JSONObject errorResponse = new JSONObject();
        // 基础错误信息
        errorResponse.put(ShopeeErrorConstants.HTTP_STATUS_CODE, ex.getStatusCode().value());
        errorResponse.put(ShopeeErrorConstants.STATUS_TEXT, ex.getStatusText());

        // 原始响应体安全处理
        String sanitizedBody = sanitizeResponse(ex.getResponseBodyAsString());
        errorResponse.put(ShopeeErrorConstants.RAW_RESPONSE, sanitizedBody);

        // 增强诊断信息
        errorResponse.put(ShopeeErrorConstants.TIMESTAMP, Instant.now().toString());
        errorResponse.put(ShopeeErrorConstants.ERROR_TYPE, "SHOPEE_API_HTTP_ERROR");

        // 根据状态码映射业务语义
        errorResponse.put(ShopeeErrorConstants.BUSINESS_CODE,
                ShopeeErrorMapper.getBusinessErrorCode(ex.getStatusCode()));

        logErrorForMonitoring(ex); // 监控埋点
        return errorResponse;
    }

    // 敏感信息过滤（防止泄露密钥等）
    private static String sanitizeResponse(String rawBody) {
        return rawBody.replaceAll("\"token\":\"[^\"]+\"", "\"token\":\"***\"")
                .replaceAll("\"password\":\"[^\"]+\"", "\"password\":\"***\"");
    }

    // 监控系统集成
    private static void logErrorForMonitoring(HttpClientErrorException ex) {
        log.error("[Shopee Monitor] HTTP Error {} - {}",
                ex.getStatusCode(), ex.getStatusText(), ex);
        // 推送到监控系统（示例）
//        MonitoringService.report(
//                new ShopeeApiIncident(ex.getStatusCode(), ex.getResponseBodyAsString())
//        );
    }

    private static JSONObject buildFallbackError(HttpClientErrorException ex) {
        // 基础兜底响应（Java 8字符串拼接）
        String fallbackJson = "{"
                + "\"error_type\":\"FALLBACK_ERROR\","
                + "\"http_status\":" + ex.getStatusCode().value() + ","
                + "\"message\":\"请求处理失败，请联系管理员\""
                + "}";
        try {
            return JSONObject.parseObject(fallbackJson);
        } catch (JSONException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", "CRITICAL_FAILURE");
            return jsonObject;
        }
    }
}