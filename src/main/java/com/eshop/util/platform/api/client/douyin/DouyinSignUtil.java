package com.eshop.util.platform.api.client.douyin;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public class DouyinSignUtil {

    private static final Integer SIGN_METHOD_MD5 = Integer.valueOf(1);

    private static final Integer SIGN_METHOD_HMAC_SHA256 = Integer.valueOf(2);

    public static String sign(String appKey, String appSecret, String method, String timestamp, String paramJsonNot, String v) {
        String sortedParamStr = null;
        if (paramJsonNot != null) {
            sortedParamStr = paramJsonNot;
        } else {
            sortedParamStr = "{}";
        }
        String signPattern = appSecret + "app_key" + appKey + "method" + method + "param_json" + sortedParamStr + "timestamp" + timestamp + "v" + v + appSecret;
        return stringToMD5(signPattern);
    }

//    public static String spiSign(String appKey, String appSecret, String timestamp, String paramJson, Integer signMethod) {
//        String sortedParamStr = "";
//        if (StringUtils.isNotEmpty(paramJson)) {
//            JSONObject jsonObject = JSON.parseObject(paramJson);
//            LinkedHashMap<String, Object> sortedMap = sortParamJson(jsonObject);
//            if (sortedMap != null)
//                sortedParamStr = JSON.toJSONString(sortedMap);
//        }
//        String signPattern = appSecret + "app_key" + appKey + "param_json" + sortedParamStr + "timestamp" + timestamp + appSecret;
//        if (SIGN_METHOD_HMAC_SHA256.equals(signMethod))
//            return stringToHmac(signPattern, appSecret);
//        return stringToMD5(signPattern);
//    }
//
//    private static LinkedHashMap<String, Object> sortParamJson(JSONObject paramJsonObject) {
//        if (paramJsonObject == null)
//            return null;
//        if (paramJsonObject.size() == 0)
//            return new LinkedHashMap<>();
//        List<String> keys = new ArrayList<>(paramJsonObject.keySet());
//        Collections.sort(keys);
//        LinkedHashMap<String, Object> retMap = new LinkedHashMap<>();
//        for (String key : keys) {
//            Object valueObj = paramJsonObject.get(key);
//            if (valueObj instanceof JSONObject) {
//                retMap.put(key, sortParamJson((JSONObject)valueObj));
//                continue;
//            }
//            if (valueObj instanceof JSONArray) {
//                JSONArray arrayObj = (JSONArray)valueObj;
//                if (arrayObj.size() > 0 && arrayObj.get(0) instanceof JSONObject) {
//                    List<LinkedHashMap<String, Object>> newList = new ArrayList<>();
//                    for (Object obj : arrayObj) {
//                        if (obj instanceof JSONObject)
//                            newList.add(sortParamJson((JSONObject)obj));
//                    }
//                    retMap.put(key, newList);
//                    continue;
//                }
//                retMap.put(key, paramJsonObject.get(key));
//                continue;
//            }
//            retMap.put(key, paramJsonObject.get(key));
//        }
//        return retMap;
//    }

    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText
                    .getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("计算md5失败");
        }
        StringBuilder md5code = new StringBuilder((new BigInteger(1, secretBytes)).toString(16));
        while (md5code.length() < 32)
            md5code.insert(0, "0");
        return md5code.toString();
    }

    public static String stringToHmac(String plainText, String appSecret) {
        Mac mac;
        try {
            byte[] secret = appSecret.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(secret, "HmacSHA256");
            mac = Mac.getInstance("HmacSHA256");
            mac.init(keySpec);
        } catch (NoSuchAlgorithmException | java.security.InvalidKeyException e) {
            throw new RuntimeException("计算hmac失败");
        }
        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] digest = mac.doFinal(plainBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", new Object[] { Byte.valueOf(b) }));
        }
        return sb.toString();
    }
}
