package com.eshop.util.platform.api.client.jushuitan;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 聚水潭签名对接工具类
 * @author ldj
 */
public class JushuitanSignUtil {

    /**
     * 生成聚水潭API签名
     *
     * @param params 请求参数Map
     * @param appSecret 应用密钥
     * @return 签名值（32位小写MD5）
     */
    public static String generateSign(Map<String, String> params, String appSecret) {
        // 1. 移除sign参数（如果存在）
        params.remove("sign");

        // 2. 按参数名的字典顺序排序
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        // 3. 拼接参数名和参数值
        StringBuilder signBuilder = new StringBuilder();
        signBuilder.append(appSecret); // 首先添加app_secret

        for (String key : keys) {
            String value = params.get(key);
            // 跳过空值参数（根据聚水潭要求）
            if (value != null && !value.isEmpty()) {
                signBuilder.append(key).append(value);
            }
        }

        String signString = signBuilder.toString();

        // 4. 计算MD5签名
        return md5(signString);
    }

    /**
     * 计算字符串的MD5值
     *
     * @param input 输入字符串
     * @return 32位小写MD5值
     */
    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // 转换为16进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5算法不可用", e);
        }
    }
//
//    public static void main(String[] args) {
//        // 测试示例
//        String appSecret = "e9c5ca33fecb404b8e6cdbd0ef4a6d25";
//
//        Map<String, String> params = new HashMap<>();
//        params.put("app_key", "5b53060f23d84ddf9703056e84fa5a2d");
//        params.put("timestamp", "1639128407");
//        params.put("grant_type", "authorization_code");
//        params.put("charset", "utf-8");
//        params.put("code", "123456");
//
//        String sign = generateSign(params, appSecret);
//        System.out.println("计算得到的签名: " + sign);
//        System.out.println("预期签名: 05e3a51e19e0883afd1882ccd309e0b9");
//        System.out.println("是否匹配: " + "05e3a51e19e0883afd1882ccd309e0b9".equals(sign));
//    }
}