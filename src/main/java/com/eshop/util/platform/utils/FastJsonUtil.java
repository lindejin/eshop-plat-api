package com.eshop.util.platform.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

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

    // 对象转 JSON（健壮配置）
    public static String toJson(Object obj) {
        return JSON.toJSONString(
                obj,
                SerializerFeature.WriteMapNullValue,      // 保留 null 字段
                SerializerFeature.WriteDateUseDateFormat,// 标准日期格式
                SerializerFeature.DisableCircularReferenceDetect, // 禁用循环引用检测
                SerializerFeature.PrettyFormat           // 美化输出（调试用）
        );
    }

    public static JSONObject toJsonToJsonObj(Object obj) {
        if (obj == null) {
            return new JSONObject();
        }
        return parseJson(toJson(obj));
    }

    // JSON 转对象（容错处理）
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(
                    json,
                    clazz,
                    Feature.IgnoreNotMatch,                 // 忽略字段兼容性检查
                    Feature.SupportNonPublicField          // 允许反序列化私有字段
            );
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON format", e);
        }
    }
}
