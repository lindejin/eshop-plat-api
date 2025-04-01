package com.eshop.util.platform.api.client;

import com.google.common.collect.ImmutableSet;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public class ApacheUrlBuilder {
    // 信任的域名白名单
    private static final Set<String> ALLOWED_DOMAINS = ImmutableSet.of("trusted.com");

    public String buildSafeUrl(String baseUrl, Map<String, String> params) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(baseUrl);

        // 1. 添加参数（自动编码）
        params.forEach(uriBuilder::addParameter);

        // 2. 构建最终 URI
        URI uri = uriBuilder.build();

        // 3. 强制验证域名白名单
        String host = uri.getHost();
        if (host == null || !isDomainAllowed(host)) {
            throw new SecurityException("非法域名: " + host);
        }

        return uri.toString();
    }

    private boolean isDomainAllowed(String host) {
        return ALLOWED_DOMAINS.stream().anyMatch(domain -> host.equals(domain) || host.endsWith("." + domain));
    }
}