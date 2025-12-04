package com.eshop.douyin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

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
    static {
        // 保证JSON所有层级上Key的有序性
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        // 禁用Html转义
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);
        objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);

        // 创建自定义模块
        SimpleModule module = new SimpleModule();
        // 为所有数值类型注册统一的序列化器
        module.addSerializer(Number.class, new ForceIntegerSerializer());
        objectMapper.registerModule(module);

        // 确保使用BigDecimal处理浮点数
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

        // 禁用科学计数法
        objectMapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
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
     * 序列化参数，满足文档要求
     */
    private static String serializeParams(Map<String, Object> params) throws JsonProcessingException {
        // 使用TreeMap确保Key有序
        Map<String, Object> sortedParams = sortMapRecursively(params);
        return objectMapper.writeValueAsString(sortedParams);
    }

    /**
     * 递归排序Map，确保所有层级Key有序
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> sortMapRecursively(Map<String, Object> map) {
        if (map == null) {
            return null;
        }

        TreeMap<String, Object> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Map) {
                sortedMap.put(entry.getKey(), sortMapRecursively((Map<String, Object>) value));
            } else if (value instanceof List) {
                sortedMap.put(entry.getKey(), processListRecursively((List<?>) value));
            } else {
                sortedMap.put(entry.getKey(), value);
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

    /**
     * 测试示例
     */
    public static void main(String[] args) throws Exception {
        // 示例参数
        String appKey = "your_app_key";
        String appSecret = "your_app_secret";
        String method = "api.method.name";
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String version = "1.0";

        // 测试用例1：验证1.0被序列化为1
        Map<String, Object> test1 = new HashMap<>();
        test1.put("a", 1.0);
        System.out.println("测试1序列化结果: " + serializeParams(test1)); // 应该输出: {"a":1}

        // 测试用例2：验证2.5被序列化为2
        Map<String, Object> test2 = new HashMap<>();
        test2.put("b", 2.5);
        System.out.println("测试2序列化结果: " + serializeParams(test2)); // 应该输出: {"b":2}

        // 测试用例3：验证3.9被序列化为3
        Map<String, Object> test3 = new HashMap<>();
        test3.put("c", 3.9);
        System.out.println("测试3序列化结果: " + serializeParams(test3)); // 应该输出: {"c":3}

        // 测试用例4：验证负数
        Map<String, Object> test4 = new HashMap<>();
        test4.put("d", -2.7);
        System.out.println("测试4序列化结果: " + serializeParams(test4)); // 应该输出: {"d":-2}

        // 测试用例5：验证多层嵌套
        Map<String, Object> test5 = new HashMap<>();
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("b", 2.8);
        innerMap.put("a", 1.0);
        innerMap.put("c", 3.5);
        test5.put("b", 2);
        test5.put("c", 3);
        test5.put("a", innerMap);
        System.out.println("测试5序列化结果: " + serializeParams(test5)); // 应该输出: {"a":{"a":1,"b":2,"c":3},"b":2,"c":3}

        // 原始测试用例
        Map<String, Object> params = new HashMap<>();
        params.put("c", 3);
        params.put("b", 2);

        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("c", 3.7);
        nestedMap.put("b", 2.5);
        nestedMap.put("a", 1.9);
        params.put("a", nestedMap);

        // 添加带小数点的数值
        params.put("float_value", 1.6);
        params.put("double_value", 2.5);

        // 添加特殊字符
        params.put("special_chars", "&<>='/ô汉😀");

        // 生成签名
        String signature = generateSignature(appKey, appSecret, method, params, timestamp, version);

        System.out.println("参数JSON: " + serializeParams(params));
        System.out.println("签名: " + signature);
    }
}