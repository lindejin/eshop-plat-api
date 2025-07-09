package com.eshop.api;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {

    /**
     * 提取URL中的协议、主机和端口（若存在）
     * @param urlString 输入的URL字符串
     * @return 包含协议的完整域名（含端口若存在）或错误提示
     */
    public static String extractFullDomain(String urlString) {
        try {
            // 确保URL有协议前缀
            if (!urlString.matches("^\\w+://.*")) {
                urlString = "http://" + urlString; // 添加默认协议
            }

            URL url = new URL(urlString);

            // 获取协议（http/https等）
            String protocol = url.getProtocol();

            // 获取主机和端口
            String host = url.getHost();
            int port = url.getPort();

            // 构建结果：协议://主机:端口（若端口存在）
            if (port != -1) {
                return protocol + "://" + host + ":" + port;
            } else {
                return protocol + "://" + host;
            }
        } catch (MalformedURLException e) {
            return "无效URL格式: " + e.getMessage();
        }
    }

    // 测试示例
    public static void main(String[] args) {
        System.out.println(extractFullDomain("https://www.example.com:8080/path"));
        // 输出: https://www.example.com:8080

        System.out.println(extractFullDomain("http://sub.domain.com/index.html"));
        // 输出: http://sub.domain.com

        System.out.println(extractFullDomain("example.com/about"));

        System.out.println(extractFullDomain("http://192.168.10.122:11666/"));

        // 输出: http://example.com (自动添加协议)
    }
}
