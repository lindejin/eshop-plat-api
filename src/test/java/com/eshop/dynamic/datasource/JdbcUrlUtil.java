package com.eshop.dynamic.datasource;

public class JdbcUrlUtil {

    /**
     * 替换 JDBC URL 中的 IP 地址
     * @param jdbcUrl 原始 JDBC URL，例如："jdbc:mysql://192.168.10.239:3306/db_name?param=value"
     * @param newIp 要替换的新 IP 地址，例如："10.0.0.1"
     * @return 替换后的 JDBC URL
     * @throws IllegalArgumentException 如果 URL 格式无效
     */
    public static String replaceIpInJdbcUrl(String jdbcUrl, String newIp) {
        if (jdbcUrl == null || jdbcUrl.isEmpty()) {
            throw new IllegalArgumentException("JDBC URL 不能为空");
        }

        if (newIp == null || newIp.isEmpty()) {
            throw new IllegalArgumentException("新 IP 地址不能为空");
        }

        // 查找 "jdbc:mysql://" 之后和下一个 ":" 或 "/" 之前的部分
        int start = jdbcUrl.indexOf("://") + 3;
        if (start < 3) {
            throw new IllegalArgumentException("无效的 JDBC URL 格式");
        }

        int end = jdbcUrl.indexOf(':', start);
        if (end == -1) {
            end = jdbcUrl.indexOf('/', start);
            if (end == -1) {
                throw new IllegalArgumentException("无效的 JDBC URL 格式");
            }
        }

        return jdbcUrl.substring(0, start) + newIp + jdbcUrl.substring(end);
    }
}
