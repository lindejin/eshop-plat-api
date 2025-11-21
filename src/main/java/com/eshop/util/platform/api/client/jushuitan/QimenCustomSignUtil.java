package com.eshop.util.platform.api.client.jushuitan;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;


/**
 * 淘宝系列
 * 签名对接工具类
 *
 * @author ldj
 */
public class QimenCustomSignUtil {

    /**
     * 给TOP请求签名 API v2.0
     * md签名
     */
    public static String createSign(Map<String, String> parameters, String secret) {
        parameters.remove("sign");

        // 对参数按key进行排序
        Map<String, String> sortedParams = new TreeMap<>(parameters);

        StringBuilder query = new StringBuilder(secret);
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
                query.append(key).append(value);
            }
        }
        query.append(secret);

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(query.toString().getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    result.append("0");
                }
                result.append(hex);
            }
            return result.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}