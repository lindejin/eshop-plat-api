package com.eshop.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UrlUtils {

    public static String getBaseUrl(HttpServletRequest request) {
        // 1. 获取协议类型（支持反向代理）
        String scheme = getRequestScheme(request);

        // 2. 获取服务器名称（支持反向代理）
        String serverName = getRequestServerName(request);

        // 3. 获取服务器端口（支持反向代理）
        int serverPort = getRequestServerPort(request, scheme);

        // 4. 构建基础 URL
        return buildBaseUrl(scheme, serverName, serverPort);
    }

    private static String getRequestScheme(HttpServletRequest request) {
        // 优先使用反向代理传递的协议头
        String forwardedProto = request.getHeader("X-Forwarded-Proto");
        if (forwardedProto != null && !forwardedProto.isEmpty()) {
            // 处理多个值的情况（取第一个）
            return forwardedProto.split(",")[0].trim();
        }

        // 如果代理没有传递协议头，使用请求自身协议
        return request.getScheme();
    }

    private static String getRequestServerName(HttpServletRequest request) {
        // 优先使用反向代理传递的主机头
        String forwardedHost = request.getHeader("X-Forwarded-Host");
        if (forwardedHost != null && !forwardedHost.isEmpty()) {
            // 处理多个值的情况（取第一个）
            String[] hosts = forwardedHost.split(",")[0].split(":");
            return hosts[0].trim();
        }

        // 使用 Host 头部信息
        String hostHeader = request.getHeader("Host");
        if (hostHeader != null && !hostHeader.isEmpty()) {
            String[] hosts = hostHeader.split(":");
            return hosts[0].trim();
        }

        // 最后使用服务器名称
        return request.getServerName();
    }

    private static int getRequestServerPort(HttpServletRequest request, String scheme) {
        // 1. 尝试获取 X-Forwarded-Port
        String forwardedPort = request.getHeader("X-Forwarded-Port");
        if (forwardedPort != null && !forwardedPort.isEmpty()) {
            try {
                return Integer.parseInt(forwardedPort.split(",")[0].trim());
            } catch (NumberFormatException ignored) {
                // 继续使用其他方法
            }
        }

        // 2. 尝试从 X-Forwarded-Host 中提取端口
        String forwardedHost = request.getHeader("X-Forwarded-Host");
        if (forwardedHost != null && !forwardedHost.isEmpty()) {
            String[] hostParts = forwardedHost.split(",")[0].split(":");
            if (hostParts.length > 1) {
                try {
                    return Integer.parseInt(hostParts[1].trim());
                } catch (NumberFormatException ignored) {
                    // 继续使用其他方法
                }
            }
        }

        // 3. 尝试从 Host 头中提取端口
        String hostHeader = request.getHeader("Host");
        if (hostHeader != null && !hostHeader.isEmpty()) {
            String[] hostParts = hostHeader.split(",")[0].split(":");
            if (hostParts.length > 1) {
                try {
                    return Integer.parseInt(hostParts[1].trim());
                } catch (NumberFormatException ignored) {
                    // 继续使用其他方法
                }
            }
        }

        // 4. 尝试根据方案确定标准端口
        if (request.getServerPort() > 0) {
            return request.getServerPort();
        }

        // 5. 根据协议使用默认端口
        return "https".equalsIgnoreCase(scheme) ? 443 : 80;
    }

    private static String buildBaseUrl(String scheme, String serverName, int serverPort) {
        // 判断是否为标准端口（HTTP:80 或 HTTPS:443）
        boolean isStandardPort =
                ("http".equalsIgnoreCase(scheme) && serverPort == 80) ||
                        ("https".equalsIgnoreCase(scheme) && serverPort == 443);

        // 构建基础URL
        return isStandardPort ?
                scheme.toLowerCase() + "://" + serverName :
                scheme.toLowerCase() + "://" + serverName + ":" + serverPort;
    }


    /**
     * 处理无效的active参数，返回JSON错误响应
     */
    public static void handleInvalidActiveParam(HttpServletResponse response, String active) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 构造详细的错误信息
        String errorMsg = String.format("无效的active参数值: '%s'。有效值为: 'dev', 'local', 'test', 'prod'",
                StringUtils.defaultString(active, "NULL"));

        // 构建JSON响应
        String jsonResponse = String.format(
                "{\"status\": %d, \"error\": \"Bad Request\", \"message\": \"%s\"}",
                HttpStatus.BAD_REQUEST.value(), errorMsg
        );

        response.getWriter().write(jsonResponse);
    }
}
