package com.eshop.config;

import org.jsoup.Jsoup;
import org.zalando.logbook.BodyFilter;

public class HtmlToTextFilter implements BodyFilter {
    @Override
    public String filter(String contentType, String body) {
        if (contentType != null && contentType.contains("text/html")) {
            // 使用正则去除HTML标签（轻量级方案）
//            return body.replaceAll("<[^>]+>", "");

            // 或使用Jsoup精确提取（需添加依赖）
             return Jsoup.parse(body).text();
        }
        return body;
    }
}
