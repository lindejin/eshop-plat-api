package com.eshop.util.platform.api.client;

import com.google.common.collect.ImmutableSet;
import okhttp3.HttpUrl;

import java.util.Map;
import java.util.Set;

public class OkHttpUrlBuilder {
    // 信任的域名白名单
    private static final Set<String> ALLOWED_DOMAINS = ImmutableSet.of("trusted.com");

    public String buildSafeUrl(String baseUrl, Map<String, String> params) {
        // 1. 解析基础 URL
        HttpUrl baseHttpUrl = HttpUrl.parse(baseUrl);
        if (baseHttpUrl == null) {
            throw new IllegalArgumentException("无效的URL: " + baseUrl);
        }

        // 2. 验证基础域名
        String host = baseHttpUrl.host();
        if (!isDomainAllowed(host)) {
            throw new SecurityException("非法域名: " + host);
        }

        // 3. 构建带参数的 URL
        HttpUrl.Builder urlBuilder = baseHttpUrl.newBuilder();
        params.forEach(urlBuilder::addQueryParameter);

        // 4. 二次验证最终域名（防御参数注入）
        HttpUrl finalUrl = urlBuilder.build();
        if (!isDomainAllowed(finalUrl.host())) {
            throw new SecurityException("最终域名非法: " + finalUrl.host());
        }

        return finalUrl.toString();
    }

    private boolean isDomainAllowed(String host) {
        return ALLOWED_DOMAINS.stream().anyMatch(domain -> host.equals(domain) || host.endsWith("." + domain));
    }
}
