package com.eshop.douyin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class Tets2 {
    public static void main(String[] args) {
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        String method = "logistics.getShopKey";
        String accessToken = "thf9zgq3yk1lgwk7oxkf6er00001ri95-11";
        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;
        timestamp = Long.valueOf( "1767877823");
// 序列化参数
        String paramJson = GsonUtil.marshal(JSON.parseObject("{}"));
        String signsss = SignUtil.sign(appKey, appSecret, method, timestamp, paramJson);
        String params = "access_token=" + accessToken + "&app_key=" + appKey + "&method=logistics.getShopKey&param_json={}&timestamp=" + timestamp + "&v=2&sign=" + signsss + "&sign_method=hmac-sha256";
        JSONObject json = JSON.parseObject("{}");
        System.out.println(params);
        json.put("params",params);
        json.put("timestamp",timestamp);
        System.out.println(json);
    }
}
