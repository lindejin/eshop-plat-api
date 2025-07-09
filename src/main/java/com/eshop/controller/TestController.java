package com.eshop.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: ldj
 * @date: 2021/6/16
 * @content: token管理控制器
 */
@RestController()
@RequestMapping("/tokenManager")
@Slf4j
public class TestController {

    @Value("${spring.profiles.active}")
    private String springActive;

    /**
     * dhGate
     * 以code获取授权token 第三方call接口
     */
    @GetMapping("/dhGate/post/code/{shopId}/{employeeId}/{active}/")
    public void dhGateGetCode(
            @PathVariable("shopId") Long shopId,
            @PathVariable("employeeId") Long employeeId,
            @PathVariable("active") String active,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        // 获取授权code
        String code = request.getParameter("code");
        String baseUrl = UrlUtils.getBaseUrl(request);
        Map<String, String> envBaseUrls = new LinkedHashMap<String, String>() {{
            put(springActive, null);      // 默认使用原baseUrl
            put("dev", "http://127.0.0.1:11888");
            put("local", "http://127.0.0.1:11888");
            put("prod", "http://erp.vogocm.com");
            put("test", "https://test.vogocm.com:9696");
            put("dh", "http://dh.vogocm.com:6688");
            put("wj", "https://wj.vogocm.com:6868");
        }};

        if (StringUtils.isBlank(active)) {
            UrlUtils.handleInvalidActiveParam(response, active);
            return;
        }

        String targetBaseUrl = envBaseUrls.containsKey(active)
                ? (envBaseUrls.get(active) != null ? envBaseUrls.get(active) : baseUrl)
                : null;

        if (targetBaseUrl == null) {
            UrlUtils.handleInvalidActiveParam(response, active);
            return;
        }

        // 构建基础 URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(targetBaseUrl)
                .newBuilder()
                .addPathSegment("api")
                .addPathSegment("tokenManager")
                .addPathSegment("post")
                .addPathSegment("code")
                .addPathSegment(String.valueOf(shopId))
                .addPathSegment(String.valueOf(employeeId))
                .addPathSegment("")
                .setQueryParameter("code", code);

        // 获取完整的重定向 URL
        String redirectUrl = urlBuilder.build().toString();

        response.sendRedirect(redirectUrl);
    }
}
