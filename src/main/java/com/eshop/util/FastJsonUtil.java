package com.eshop.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ldj
 * @date 2024/3/15 15:20
 * @Description: ...
 * @Version 1.0
 */
public class FastJsonUtil {

    public static JSONObject parseJson(String jsonStr) {
        try {
            return JSONObject.parseObject(jsonStr);
        } catch (JSONException e) {
            // 这里可以根据需要处理异常，例如打印错误信息、抛出自定义异常等
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error_json", "JSON解析错误");
            jsonObject.put("message_json", e.getMessage());
            jsonObject.put("original_json", jsonStr);
            return jsonObject;
        }
    }
}
