package com.eshop.util.platform.api.client.douyin.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-06 21:32
 **/
public class SignUtil {
    // 计算签名
    public static String sign(String appKey, String appSecret, String method, long timestamp, String paramJson) {
        // 按给定规则拼接参数
        String paramPattern = "app_key" + appKey + "method" + method + "param_json" + paramJson + "timestamp" + timestamp + "v2";
        String signPattern = appSecret + paramPattern + appSecret;
        System.out.println("sign_pattern:" + signPattern);

        return hmac(signPattern, appSecret);
    }

    // 计算hmac
    public static String hmac(String plainText, String appSecret) {
        Mac mac;
        try {
            byte[] secret = appSecret.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(secret, "HmacSHA256");

            mac = Mac.getInstance("HmacSHA256");
            mac.init(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return "";
        }

        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] digest = mac.doFinal(plainBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b: digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
