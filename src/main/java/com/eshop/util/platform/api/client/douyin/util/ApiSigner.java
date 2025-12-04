package com.eshop.util.platform.api.client.douyin.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ApiSigner {

    private static final String HMAC_SHA256 = "HmacSHA256";

    // 配置ObjectMapper以满足序列化要求
    private static final ObjectMapper objectMapper = new ObjectMapper();
    // 用于不处理小数点的ObjectMapper
    private static final ObjectMapper plainObjectMapper = new ObjectMapper();

    static {
        configureObjectMapper(objectMapper, true);
        configureObjectMapper(plainObjectMapper, false);
    }

    private static void configureObjectMapper(ObjectMapper mapper, boolean forceInteger) {
        // 保证JSON所有层级上Key的有序性
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        // 禁用Html转义
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);

        // 忽略null值
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        if (forceInteger) {
            // 创建自定义模块
            SimpleModule module = new SimpleModule();
            // 为所有数值类型注册统一的序列化器
            module.addSerializer(Number.class, new ForceIntegerSerializer());
            mapper.registerModule(module);
        }

        // 确保使用BigDecimal处理浮点数
        mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

        // 禁用科学计数法
        mapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);

        // 配置ObjectMapper使用字段访问器，确保能获取私有字段
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE);
    }

    /**
     * 计算API签名
     * @param appKey 应用ID
     * @param appSecret 应用密钥
     * @param method API方法名
     * @param params 参数Map
     * @param timestamp 时间戳
     * @param version API版本
     * @return 签名字符串
     */
    public static String generateSignature(String appKey, String appSecret, String method,
                                           Map<String, Object> params, String timestamp, String version) {
        try {
            // STEP1: 序列化参数
            String paramJson = serializeParams(params);

            // STEP2: 拼接参数
            StringBuilder paramPattern = new StringBuilder();
            paramPattern.append("app_key").append(appKey)
                    .append("method").append(method)
                    .append("param_json").append(paramJson)
                    .append("timestamp").append(timestamp)
                    .append("v").append(version);

            // 在头尾拼接app_secret
            String signPattern = appSecret + paramPattern.toString() + appSecret;

            // 使用hmac-sha256算法计算签名
            return calculateHmacSha256(signPattern, appSecret);
        } catch (Exception e) {
            throw new RuntimeException("生成签名失败", e);
        }
    }

    /**
     * 序列化参数，会去除小数点及后续小数，同时忽略null值
     */
    public static String serializeParams(Map<String, Object> params) throws JsonProcessingException {
        if (params == null) {
            return "{}";
        }
        // 使用TreeMap确保Key有序
        Map<String, Object> sortedParams = sortMapRecursively(params);
        return objectMapper.writeValueAsString(sortedParams);
    }

    /**
     * 序列化参数，不做任何特殊处理（保留小数，不忽略null值）
     */
    public static String serializeParamsPlain(Map<String, Object> params) throws JsonProcessingException {
        if (params == null) {
            return "{}";
        }
        // 使用TreeMap确保Key有序
        Map<String, Object> sortedParams = sortMapRecursively(params);
        // 使用普通ObjectMapper
        return plainObjectMapper.writeValueAsString(sortedParams);
    }

    /**
     * 通用序列化方法 - 重载版本1：支持Map（会去除小数点）
     */
    public static String serializeParams(Object object) throws JsonProcessingException {
        if (object == null) {
            return "{}";
        }

        // 将对象转换为Map
        Map<String, Object> objectMap = convertObjectToMap(object);

        // 递归排序
        Map<String, Object> sortedMap = sortMapRecursively(objectMap);

        // 序列化为JSON
        return objectMapper.writeValueAsString(sortedMap);
    }

    /**
     * 通用序列化方法 - 不处理小数点和null值
     */
    public static String serializeParamsPlain(Object object) throws JsonProcessingException {
        if (object == null) {
            return "{}";
        }

        // 将对象转换为Map
        Map<String, Object> objectMap = convertObjectToMap(object);

        // 递归排序
        Map<String, Object> sortedMap = sortMapRecursively(objectMap);

        // 序列化为JSON，使用不处理小数的ObjectMapper
        return plainObjectMapper.writeValueAsString(sortedMap);
    }

    /**
     * 将任意对象转换为Map
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> convertObjectToMap(Object object) throws JsonProcessingException {
        if (object == null) {
            return Collections.emptyMap();
        }

        // 如果已经是Map，直接返回
        if (object instanceof Map) {
            return (Map<String, Object>) object;
        }

        // 将对象转换为JsonNode
        JsonNode jsonNode = objectMapper.valueToTree(object);

        // 将JsonNode转换为Map
        return objectMapper.convertValue(jsonNode,
                TypeFactory.defaultInstance().constructMapType(LinkedHashMap.class, String.class, Object.class));
    }

    /**
     * 递归排序Map，确保所有层级Key有序
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> sortMapRecursively(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return map;
        }

        TreeMap<String, Object> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value == null) {
                sortedMap.put(key, null);
                continue;
            }

            // 处理嵌套Map
            if (value instanceof Map) {
                sortedMap.put(key, sortMapRecursively((Map<String, Object>) value));
            }
            // 处理List/Array
            else if (value instanceof List) {
                sortedMap.put(key, processListRecursively((List<?>) value));
            }
            // 处理数组
            else if (value.getClass().isArray()) {
                List<Object> list = new ArrayList<>();
                int length = java.lang.reflect.Array.getLength(value);
                for (int i = 0; i < length; i++) {
                    list.add(java.lang.reflect.Array.get(value, i));
                }
                sortedMap.put(key, processListRecursively(list));
            }
            // 处理其他对象
            else if (!isSimpleValueType(value.getClass())) {
                try {
                    // 尝试将复杂对象转换为Map
                    Map<String, Object> objectMap = convertObjectToMap(value);
                    sortedMap.put(key, sortMapRecursively(objectMap));
                } catch (Exception e) {
                    // 如果转换失败，保留原始值
                    sortedMap.put(key, value);
                }
            }
            // 简单类型直接放入
            else {
                sortedMap.put(key, value);
            }
        }
        return sortedMap;
    }

    /**
     * 递归处理List中的Map元素
     */
    @SuppressWarnings("unchecked")
    private static List<?> processListRecursively(List<?> list) {
        List<Object> result = new ArrayList<>(list.size());
        for (Object item : list) {
            if (item instanceof Map) {
                result.add(sortMapRecursively((Map<String, Object>) item));
            } else if (item instanceof List) {
                result.add(processListRecursively((List<?>) item));
            } else {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * 判断是否为简单值类型
     */
    private static boolean isSimpleValueType(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz.equals(String.class) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(BigDecimal.class) ||
                clazz.equals(Date.class) ||
                clazz.equals(java.sql.Date.class) ||
                clazz.equals(java.sql.Timestamp.class) ||
                clazz.equals(java.sql.Time.class) ||
                clazz.equals(UUID.class) ||
                clazz.equals(Enum.class) ||
                clazz.isEnum();
    }

    /**
     * 计算HMAC-SHA256签名
     */
    private static String calculateHmacSha256(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSHA256 = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
        hmacSHA256.init(secretKeySpec);

        byte[] hash = hmacSHA256.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

    /**
     * 将字节数组转换为十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * 强制将所有数值转为整数，丢弃小数部分
     */
    public static class ForceIntegerSerializer extends StdSerializer<Number> {
        public ForceIntegerSerializer() {
            super(Number.class);
        }

        @Override
        public void serialize(Number value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null) {
                gen.writeNull();
                return;
            }

            // 处理所有数值类型，强制转换为整数
            if (value instanceof Double || value instanceof Float) {
                double doubleValue = value.doubleValue();
                if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                    // 非常规值处理
                    gen.writeNumber(0);
                } else {
                    // 向下取整，丢弃小数部分
                    gen.writeNumber((long) Math.floor(doubleValue));
                }
            } else if (value instanceof BigDecimal) {
                BigDecimal bd = (BigDecimal) value;
                // 丢弃小数部分，直接取整
                gen.writeNumber(bd.setScale(0, RoundingMode.FLOOR).toBigIntegerExact());
            } else {
                // 其他所有数值类型 (Integer, Long, Short, Byte等)
                // 由于已经是整数类型，直接写入
                gen.writeNumber(value.longValue());
            }
        }
    }
}