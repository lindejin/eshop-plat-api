package com.eshop.douyin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.douyin.DouyinSignUtil;
import com.eshop.util.platform.api.client.douyin.util.GsonUtil;
import com.eshop.util.platform.api.client.douyin.util.SignUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-06 20:59
 **/
public class tets {
    public static void main(String[] args) {
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        String method = "logistics.getShopKey";
        String accessToken = "thf9zgq3yk1lgwk7oxkf6er00001ri95-11";
        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;
// 序列化参数
        String paramJson = GsonUtil.marshal(JSON.parseObject("{}"));
        String signsss = SignUtil.sign(appKey, appSecret, method, timestamp, paramJson);
        String params = "access_token=" + accessToken + "&app_key=" + appKey + "&method=logistics.getShopKey&param_json={}&timestamp=" + timestamp + "&v=2&sign=" + signsss + "&sign_method=hmac-sha256";


        JSONObject json = JSON.parseObject("{}");

        json.put("params",params);
        json.put("timestamp",timestamp);
        System.out.println(json);
    }

    // 下面是一个批量加密接口的示例
    public static void mai2n(String[] args) {
        // 收集参数
        String appKey = "*"; //  替换成你的app_key
        String appSecret = "*"; // 替换成你的app_secret
        String accessToken = "*"; // 替换成你的access_token
        String host = "https://openapi-fxg.jinritemai.com";
        String method = "order.batchEncrypt";

        long timestamp = System.currentTimeMillis() / 1000;

        Map<String, Object> m2 = new HashMap<>();
        m2.put("plain_text", "&<>='/ô汉😀");//附加符号、中日韩、Emoji都不转义
        m2.put("auth_id", "12345");
        m2.put("is_support_index", false);
        m2.put("sensitive_type", 2);

        Map<String, Object> m = new HashMap<>();
        m.put("batch_encrypt_list", new Object[]{m2});
//
//        // 序列化参数
//        String paramJson = marshal(m);
//        System.out.println("param_json:" + paramJson);
//
//        // 计算签名
//        String signVal = sign(appKey, appSecret, method, timestamp, paramJson);
//        System.out.println("sign_val:" + signVal);
//
//        // 发起请求
//        String responseVal = fetch(appKey, host, method, timestamp, paramJson, accessToken, signVal);
//        System.out.println("response_val:" + responseVal);
    }
}
