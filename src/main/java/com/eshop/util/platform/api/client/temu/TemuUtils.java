package com.eshop.util.platform.api.client.temu;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemuUtils {
    /**
     * 本次请求中所有请求参数（包含公共参数与业务参数）进行首字母以ASCII方式升序排列ascii asc ，对于相同字母则使用下个字母做二次排序，字母序为从左到右，以此类推
     * 排序后的结果按照参数名$key 参数值$value 的次序进行字符串拼接，拼接处不包含任何字符
     * 拼接完成的字符串做进一步拼接成1个字符串（包含所有kv字符串的长串），并在该长串的头部及尾部分别拼接app_secret ，完成签名字符串的组装
     * 最后对签名字符串，使用MD5 算法加密后，得到的MD5 加密密文后转为大写，即为sign 值
     */
    public static String getSign(String appKey, String appSecret, String accessToken, long timestamp, String type, String dataType, JSONObject jsonParams) {

        // 1. 所有请求参数（包含公共参数与业务参数）进行首字母以ASCII方式升序排列ascii asc ，对于相同字母则使用下个字母做二次排序，字母序为从左到右，以此类推
        // 2. 排序后的结果按照参数名$key 参数值$value 的次序进行字符串拼接，拼接处不包含任何字符
        // 3. 拼接完成的字符串做进一步拼接成1个字符串（包含所有kv字符串的长串），并在该长串的头部及尾部分别拼接app_secret ，完成签名字符串的组装
        // 4. 对签名字符串，使用MD5 算法加密后，得到的MD5 加密密文后转为大写，即为sign 值
        List<String> params = new ArrayList<>();
        params.add("app_key" + appKey);
        params.add("access_token" + accessToken);
        params.add("timestamp" + timestamp);
        params.add("type" + type);
        params.add("data_type" + dataType);

        if (jsonParams != null && !jsonParams.isEmpty()) {
            //循环jsonParams
            for (String key : jsonParams.keySet()) {
                String jsonObject = jsonParams.getString(key);
                if (jsonObject != null) {
                    params.add(key + jsonObject);
                }
            }
        }

        //params首字母以ASCII方式升序排列ascii asc
        Collections.sort(params);

        // 排序后的结果按照参数名$key 参数值$value 的次序进行字符串拼接，拼接处不包含任何字符
        String paramsStr = "";
        for (String param : params) {
            paramsStr += param;
        }
        // 在该长串的头部及尾部分别拼接app_secret ，完成签名字符串的组装
        paramsStr = appSecret + paramsStr + appSecret;
        // 对签名字符串，使用MD5 算法加密后，得到的MD5 加密密文后转为大写，即为sign 值
        String sign = DigestUtil.md5Hex(paramsStr).toUpperCase();

        return sign;
    }
}
