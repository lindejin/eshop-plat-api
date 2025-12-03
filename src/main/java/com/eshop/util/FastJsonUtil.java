//package com.eshop.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Map;
//
//public class FastJsonUtil {
//
//    public static String obj2String(Map<String, Object> params) {
//        return  toJson(params);
//    }
//
//    // 对象转 JSON（健壮配置）
//    public static String toJson(Object obj) {
//        return JSON.toJSONString(
//                obj,
//                SerializerFeature.WriteMapNullValue,      // 保留 null 字段
//                SerializerFeature.WriteDateUseDateFormat,// 标准日期格式
//                SerializerFeature.DisableCircularReferenceDetect, // 禁用循环引用检测
//                SerializerFeature.PrettyFormat           // 美化输出（调试用）
//        );
//    }
//    /**
//     * 对象转Map，复杂对象属性转为JSON字符串
//     *
//     * @param obj 要转换的对象
//     * @return 转换后的Map
//     */
//    public static Map<String, String> objectToMapWithJsonString(Object obj) {
//        Map<String, String> resultMap = new HashMap<>();
//
//        if (obj == null) {
//            return resultMap;
//        }
//
//        try {
//            // 先用FastJSON将对象转为JSONObject
//            JSONObject jsonObject = (JSONObject) JSON.toJSON(obj);
//
//            // 遍历所有字段
//            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//
//                // 处理属性值
//                if (value == null) {
//                    resultMap.put(key, null);
//                } else if (isStrictSimpleType(value)) {
//                    // 基本类型直接转为字符串
//                    resultMap.put(key, String.valueOf(value));
//                } else {
//                    // 复杂对象转为JSON字符串
//                    resultMap.put(key, JSON.toJSONString(value));
//                }
//            }
//
//        } catch (Exception e) {
//            // 如果FastJSON转换失败，使用反射方式
//            return objectToMapWithReflection(obj);
//        }
//
//        return resultMap;
//    }
//
//    /**
//     * 使用反射方式处理对象转Map
//     */
//    private static Map<String, String> objectToMapWithReflection(Object obj) {
//        Map<String, String> resultMap = new HashMap<>();
//
//        if (obj == null) {
//            return resultMap;
//        }
//
//        try {
//            Class<?> clazz = obj.getClass();
//            Field[] fields = clazz.getDeclaredFields();
//
//            for (Field field : fields) {
//                field.setAccessible(true);
//                String fieldName = field.getName();
//                Object value = field.get(obj);
//
//                if (value == null) {
//                    resultMap.put(fieldName, null);
//                } else if (isStrictSimpleType(value)) {
//                    // 基本类型直接转为字符串
//                    resultMap.put(fieldName, String.valueOf(value));
//                } else {
//                    // 复杂对象转为JSON字符串
//                    resultMap.put(fieldName, JSON.toJSONString(value));
//                }
//            }
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException("对象转Map失败", e);
//        }
//
//        return resultMap;
//    }
//
//    /**
//     * 判断是否为简单类型
//     */
//    private static boolean isSimpleType(Object value) {
//        return value instanceof String ||
//                value instanceof Number ||
//                value instanceof Boolean ||
//                value instanceof Character ||
//                value.getClass().isPrimitive() ||
//                value instanceof java.util.Date;
//    }
//
//    /**
//     * 更严格的简单类型判断（可选）
//     */
//    private static boolean isStrictSimpleType(Object value) {
//        Class<?> clazz = value.getClass();
//        return clazz == String.class ||
//                clazz == Integer.class || clazz == int.class ||
//                clazz == Long.class || clazz == long.class ||
//                clazz == Double.class || clazz == double.class ||
//                clazz == Float.class || clazz == float.class ||
//                clazz == Boolean.class || clazz == boolean.class ||
//                clazz == Character.class || clazz == char.class ||
//                clazz == Byte.class || clazz == byte.class ||
//                clazz == Short.class || clazz == short.class ||
//                java.util.Date.class.isAssignableFrom(clazz);
//    }
//}
