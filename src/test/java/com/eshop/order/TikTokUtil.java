package com.eshop.order;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TikTok工具类
 *
 * @author sheng
 * @date 2023-09-13 20:41
 */
@Slf4j
public final class TikTokUtil {
    /**
     * 生成sign参数  使用HmacSHA256加密
     *
     * @param path     请求路径
     * @param paramMap 请求参数
     * @param secret   应用密码
     * @return java.lang.String
     * @author sheng
     * @date 2023-09-10 17:56
     */
    public static String generateSign(String path, Map<String, Object> paramMap, String secret) {
        List<String> paramKeys = paramMap.keySet().stream().sorted().collect(Collectors.toList());
        paramKeys.removeAll(Arrays.asList("sign", "access_token"));
        StringBuilder signStr = new StringBuilder();
        signStr.append(secret).append(path).append(paramKeys.stream().map(e -> {
            Object value = paramMap.get(e);
            if (Objects.nonNull(value) || (value instanceof String && StringUtils.isNotBlank(value.toString()))) {
                return e + value;
            }
            return e;
        }).collect(Collectors.joining(""))).append(secret);
        try {
            // 使用 HMAC-SHA256 初始化
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmacSha256.init(secretKey);
            // 计算哈希值
            byte[] hashBytes = hmacSha256.doFinal(signStr.toString().getBytes(StandardCharsets.UTF_8));
            // 将哈希值转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace(); // 在实际应用中，最好记录错误
            return "";
        }
    }

    /**
     * 生成sign参数  使用HmacSHA256加密
     *
     * @param path     请求路径
     * @param paramMap 请求参数
     * @param secret   应用密码
     * @return java.lang.String
     * @author sheng
     * @date 2023-09-10 17:56
     */
    public static String generateSignNew(String path, Map<String, Object> paramMap, String bodyStr, String secret) {
        List<String> paramKeys = paramMap.keySet().stream().sorted().collect(Collectors.toList());
        paramKeys.removeAll(Arrays.asList("sign", "access_token"));
        if (Objects.isNull(bodyStr)) {
            bodyStr = "";
        }
        StringBuilder signStr = new StringBuilder();
        signStr.append(secret).append(path)
                .append(paramKeys.stream().map(e -> e + valueConvert(paramMap.get(e))).collect(Collectors.joining("")))
                .append(bodyStr)
                .append(secret);
        try {
            // 使用 HMAC-SHA256 初始化
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmacSha256.init(secretKey);
            // 计算哈希值
            byte[] hashBytes = hmacSha256.doFinal(signStr.toString().getBytes(StandardCharsets.UTF_8));
            // 将哈希值转换为十六进制字符串
            return String.format("%064x", new BigInteger(1, hashBytes));
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace(); // 在实际应用中，最好记录错误
            return "";
        }
    }

    /**
     * 直接获取data里面的数据
     *
     * @param returnJsonStr
     * @return com.alibaba.fastjson.JSONObject
     * @author sheng
     * @date 2023-11-13 14:17
     */
    public static JSONObject getReturnData(String returnJsonStr) {
        if (StringUtils.isBlank(returnJsonStr)) {
            return null;
        }
        JSONObject json = JSON.parseObject(returnJsonStr);
        if ("0".equals(json.getString("code"))) {
            return Optional.ofNullable(json.getJSONObject("data")).orElse(new JSONObject());
        } else {
            String msg = "操作失败,错误信息: " + json.getString("message");
            log.error(msg);
            throw new RuntimeException(msg);
        }
    }

    /**
     * 直接获取data里面的数据
     *
     * @param json
     * @return com.alibaba.fastjson.JSONObject
     * @author sheng
     * @date 2023-11-13 14:17
     */
    public static JSONObject getReturnData(JSONObject json) {
        if (Objects.isNull(json)) {
            return null;
        }
        if ("0".equals(json.getString("code"))) {
            return Optional.ofNullable(json.getJSONObject("data")).orElse(new JSONObject());
        } else {
            String msg = "操作失败,错误信息: " + json.getString("message");
            log.error(msg);
            throw new RuntimeException(msg);
        }
    }

    /**
     * 获取数据
     *
     * @param json      返回数据
     * @param logPrefix 日志前缀
     * @return com.alibaba.fastjson.JSONObject
     * @author sheng
     * @date 2024-01-25 14:46
     */
    public static JSONObject getReturnData(JSONObject json, String logPrefix) {
        if (Objects.isNull(json)) {
            return null;
        }
        if ("0".equals(json.getString("code"))) {
            return Optional.ofNullable(json.getJSONObject("data")).orElse(new JSONObject());
        } else {
            String msg = logPrefix + "操作失败,错误信息: " + json.getString("message");
            throw new RuntimeException(msg);
        }
    }

    /**
     * 获取返回数据
     *
     * @param json      返回数据
     * @param logPrefix 日志前缀
     * @param attrName  属性名
     * @param clazz     转换的对象
     * @return com.alibaba.fastjson.JSONObject
     * @author sheng
     * @date 2024-06-05 14:43
     */
    public static <T> List<T> getReturnDataConvertObj(JSONObject json, String attrName, Class<T> clazz, String logPrefix) {
        if (Objects.isNull(json)) {
            return Collections.emptyList();
        }
        if ("0".equals(json.getString("code"))) {
            JSONObject data = json.getJSONObject("data");
            if (Objects.nonNull(data)) {
                JSONArray categories = data.getJSONArray(attrName);
                if (CollectionUtils.isNotEmpty(categories)) {
                    return categories.toJavaList(clazz);
                }
            }
            return Collections.emptyList();
        } else {
            String msg = logPrefix + "操作失败,请求ID:" + json.getString("request_id") + ",错误信息: " + json.getString("message");
            throw new RuntimeException(msg);
        }
    }

    /**
     * 获取返回数据转换为指定对象
     *
     * @param returnJson
     * @param clazz
     * @param logPrefix
     * @return T
     * @author sheng
     * @date 2024-06-13 09:57
     */
    public static <T> T getReturnDataConvertObj(JSONObject returnJson, Class<T> clazz, String logPrefix) {
        if (Objects.isNull(returnJson)) {
            throw new RuntimeException(logPrefix + "未获取到返回值信息!!!");
        }
        if ("0".equals(returnJson.getString("code"))) {
            //返回参数
            JSONObject data = returnJson.getJSONObject("data");
            if (Objects.nonNull(data)) {
                return data.toJavaObject(clazz);
            }
            throw new RuntimeException(logPrefix + "未获取到返回值信息!!!");
        } else {
            String msg = logPrefix + "请求ID(" + returnJson.getString("request_id") + "), 错误信息: " + returnJson.getString(
                    "message");
            throw new RuntimeException(msg);
        }
    }

    /**
     * 获取返回数据转换为对应对象(直接从Data获取)
     *
     * @return java.lang.String
     * @author sheng
     * @date 2023-09-14 14:48
     */
    public static <T> T getReturnData(String returnJsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(returnJsonStr)) {
            log.error("未获取到返回值信息!!!");
            throw new RuntimeException("未获取到返回值信息!!!");
        }
        return getReturnData(JSON.parseObject(returnJsonStr), clazz);
    }

    public static <T> T getReturnData(JSONObject returnJson, Class<T> clazz) {
        if (Objects.isNull(returnJson)) {
            log.error("未获取到返回值信息!!!");
            throw new RuntimeException("未获取到返回值信息!!!");
        }
        if ("0".equals(returnJson.getString("code"))) {
            //返回参数
            JSONObject data = returnJson.getJSONObject("data");
            if (Objects.nonNull(data)) {
                return data.toJavaObject(clazz);
            }
            log.error("未获取到返回值信息!!!");
            throw new RuntimeException("未获取到返回值信息!!!");
        } else {
            String msg = "操作失败,错误信息: " + returnJson.getString("message");
            log.error(msg);
            throw new RuntimeException(msg);
        }
    }

    /**
     * 转换JavaBean
     *
     * @param data  返回值数据
     * @param clazz 对象
     * @return T
     * @author sheng
     * @date 2023-11-15 14:43
     */
    public static <T> T convertObj(JSONObject data, Class<T> clazz) {
        if (Objects.isNull(data)) {
            log.error("未获取到返回值信息!!!");
            throw new RuntimeException("未获取到返回值信息!!!");
        }
        return data.toJavaObject(clazz);
    }

    /**
     * 获取返回数据转换为对应对象 (data 里面包了一层属性)
     *
     * @return java.lang.String
     * @author sheng
     * @date 2023-09-14 14:48
     */
    public static <T> List<T> fromJsonToList(String returnJsonStr, String attrName, Class<T> clazz) {
        if (StringUtils.isBlank(returnJsonStr)) {
            return null;
        }
        JSONObject json = JSON.parseObject(returnJsonStr);
        if ("0".equals(json.getString("code"))) {
            //返回参数
            JSONObject data = json.getJSONObject("data");
            if (Objects.isNull(data)) {
                log.error("未获取到返回值信息!!!");
                throw new RuntimeException("未获取到返回值信息!!!");
            }
            return JSON.parseArray(data.getString(attrName), clazz);
        } else {
            String msg = "操作失败,错误信息: " + json.getString("message");
            log.error(msg);
            throw new RuntimeException(msg);
        }
    }

    /**
     * 获取返回数据转换为对应对象 (data 里面包了一层属性)
     *
     * @param returnJson 返回数据
     * @param attrName   指定名称
     * @param clazz      转换类型
     * @param logPrefix  日志前缀
     * @return java.util.List<T>
     * @author sheng
     * @date 2024-03-30 10:23
     */
    public static <T> List<T> fromJsonToList(JSONObject returnJson, String attrName, Class<T> clazz, String logPrefix) {
        if (Objects.isNull(returnJson)) {
            return null;
        }
        String msg;
        if ("0".equals(returnJson.getString("code"))) {
            //返回参数
            JSONObject data = returnJson.getJSONObject("data");
            if (Objects.isNull(data)) {
                msg = logPrefix + "请求ID: " + returnJson.getString("request_id") + " ,未获取到返回值信息!!!";
                log.error(msg);
                throw new RuntimeException(msg);
            }
            JSONArray array = data.getJSONArray(attrName);
            if (CollectionUtils.isNotEmpty(array)) {
                return array.toJavaList(clazz);
            }
            throw new RuntimeException(logPrefix + "请求ID: " + returnJson.getString("request_id") + " ,返回数据: " + returnJson);
        } else {
            msg = logPrefix + "请求ID: " + returnJson.getString("request_id") + " ,错误信息: "
                    + returnJson.getString("message");
            log.error(msg);
            throw new RuntimeException(msg);
        }
    }

    /**
     * 请求构建URl
     *
     * @param requestPath     请求路径
     * @param authBaseInfoDTO 授权信息
     * @param paramMap        其他请求参数
     * @return java.lang.String
     * @author sheng
     * @date 2023-10-30 14:20
     */
//    public static String generateRequestUrl(String requestPath, TiktokAuthBaseInfoDTO authBaseInfoDTO, Map<String, Object> paramMap) {
//        if (Objects.isNull(authBaseInfoDTO)) {
//            throw new RuntimeException("TikTok授权信息不能为空!!!");
//        }
//        if (Objects.isNull(paramMap)) {
//            paramMap = new HashMap<>();
//        }
//        JSONObject platformAppInfo = authBaseInfoDTO.getPlatformAppInfo();
//        paramMap.put("app_key", platformAppInfo.getString("app_key"));
//        paramMap.put("timestamp", Instant.now().getEpochSecond());
//        paramMap.put("version", ConstantTikTok.VERSION);
//        paramMap.put("shop_id", Optional.ofNullable(authBaseInfoDTO.getShopId()).orElse(""));
//        //店铺 密码跨境必须写
//        paramMap.put("shop_cipher", Optional.ofNullable(authBaseInfoDTO.getShopCipher()).orElse(""));
//        paramMap.put("access_token", authBaseInfoDTO.getAccessToken());
//        paramMap.put("sign", TikTokUtil.generateSign(requestPath, paramMap, platformAppInfo.getString("app_secret")));
//        StringBuilder requestUrl = new StringBuilder();
//        requestUrl.append(ConstantTikTok.OPEN_API).append(requestPath).append("?").append(paramMap.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&")));
//        return requestUrl.toString();
//    }
    /**
     * 请求构建URl (202309版)
     *
     * @param requestPath
     * @param authBaseInfoDTO
     * @param paramMap
     * @author sheng
     * @return java.lang.String
     * @date 2024-01-23 10:08
     */
//    public static String generateNewRequestUrl(String requestPath, TiktokAuthBaseInfoDTO authBaseInfoDTO, Map<String,
//            Object> paramMap,String bodyStr) {
//        if (Objects.isNull(authBaseInfoDTO)) {
//            throw new RuntimeException("TikTok授权信息不能为空!!!");
//        }
//        if (Objects.isNull(paramMap)) {
//            paramMap = new HashMap<>();
//        }
//        JSONObject platformAppInfo = authBaseInfoDTO.getPlatformAppInfo();
//        paramMap.put("app_key", platformAppInfo.getString("app_key"));
//        paramMap.put("timestamp", Instant.now().getEpochSecond());
//        if (StringUtils.isNotBlank(authBaseInfoDTO.getShopCipher())) {
//            paramMap.put("shop_cipher", authBaseInfoDTO.getShopCipher());
//        }
//        String sign = TikTokUtil.generateSignNew(requestPath, paramMap, bodyStr,
//                platformAppInfo.getString("app_secret"));
//        paramMap.put("sign", sign);
//        StringBuilder requestUrl = new StringBuilder();
//        requestUrl.append(ConstantTikTok.OPEN_API).append(requestPath).append("?")
//                .append(paramMap.entrySet().stream().map(e -> e.getKey() + "=" + valueConvert(e.getValue()))
//                        .collect(Collectors.joining("&")));
//        return requestUrl.toString();
//    }

    /**
     * 参数值转换为字符串
     *
     * @param value
     * @return java.lang.String
     * @author sheng
     * @date 2024-06-21 14:15
     */
    public static String valueConvert(Object value) {
        if (Objects.isNull(value)) {
            return "";
        } else if (value instanceof Collection) {
            return ((Collection<?>) value).stream().filter(Objects::nonNull)
                    .map(e -> e.toString()).collect(Collectors.joining(","));
        } else if (value.getClass().isArray()) {
            int length = Array.getLength(value);
            String str = "";
            for (int i = 0; i < length; i++) {
                T element = (T) Array.get(value, i);
                if (Objects.nonNull(element)) {
                    str += "," + element;
                }
            }
            if (StringUtils.isNotBlank(str)) {
                return str.substring(1);
            }
            return "";
        } else {
            return value.toString();
        }
    }

    /**
     * 请求构建URl
     *
     * @param requestPath     请求路径
     * @param authBaseInfoDTO 授权信息
     * @return java.lang.String
     * @author sheng
     * @date 2023-10-30 14:28
     */
//    public static String generateRequestUrl(String requestPath, TiktokAuthBaseInfoDTO authBaseInfoDTO) {
//        return generateRequestUrl(requestPath, authBaseInfoDTO, null);
//    }

    /**
     * 截取spu,  第一个分隔符"-" 前后两段文本
     *
     * @param sku
     * @return
     */
    public static String captureSpuCode(String sku) {
        if (StringUtils.isBlank(sku)) {
            return "";
        }
        String spuCode = "";
        String[] sellerSkus = sku.split("-");
        if (sellerSkus.length >= 2) {
            spuCode = sellerSkus[0] + "-" + sellerSkus[1];
        } else {
            spuCode = sellerSkus[0];
        }
        return spuCode;
    }

    /**
     * 回调验签
     *
     * @param authorization 验签
     * @param params        请求参数
     * @param platformApp   应用App
     * @return java.lang.Boolean
     * @author sheng
     * @date 2024-01-09 16:01
     */
//    public static Boolean verifySign(String authorization, String params, TbPlatformApp platformApp) throws Exception {
//        if (StringUtils.isBlank(authorization)) {
//            return false;
//        }
//        String HmacSHA256 = "HmacSHA256";
//        JSONObject paramStatic = JSONObject.parseObject(platformApp.getAppParamJson());
//        String appKey = Optional.ofNullable(paramStatic.getString("app_key")).orElse("");
//        appKey += params;
//        Mac mac = Mac.getInstance(HmacSHA256);
//        SecretKey secretKey = new SecretKeySpec(paramStatic.getString("app_secret").getBytes(), HmacSHA256);
//        mac.init(secretKey);
//        byte[] hash = mac.doFinal(appKey.getBytes());
//        String hexString = Hex.encodeHexString(hash);
//        return authorization.equals(hexString);
//    }

    /**
     * 请求参数对象转换为map
     *
     * @param obj
     * @return org.springframework.util.MultiValueMap<java.lang.String, java.lang.String>
     * @author sheng
     * @date 2023-09-14 16:31
     */
    public static Map<String, Object> convertObjToMap(Object obj) {
        Map<String, Object> params = new HashMap<>();
        if (Objects.isNull(obj)) {
            return params;
        }
        Class<?> aClass = obj.getClass();
        // 获取对象的所有属性信息
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            // 获取字段名
            String fieldName = field.getName();
            // 获取字段值
            try {
                Object fieldValue = field.get(obj);
                if (Objects.nonNull(fieldValue) && StringUtils.isNotBlank(fieldValue.toString())) {
                    params.put(StrUtil.toUnderlineCase(fieldName), fieldValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return params;
    }

    public static File createTempFile(MultipartFile multipartFile) throws IOException {
        // 获取文件的字节数组
        byte[] bytes = multipartFile.getBytes();
        // 创建一个临时文件
        Path path = Files.createTempFile(Paths.get(System.getProperty("java.io.tmpdir")), "temp", ".tmp");
        // 将字节数组写入临时文件
        Files.write(path, bytes);
        // 将临时文件转换为 File 对象
        return path.toFile();
    }

    /**
     * 授权信息移出店铺密码信息
     */
    public static TiktokAuthBaseInfoDTO removeShopCipher(TiktokAuthBaseInfoDTO authBaseInfoDTO) {
        TiktokAuthBaseInfoDTO authDTO = new TiktokAuthBaseInfoDTO();
        BeanUtils.copyProperties(authBaseInfoDTO, authDTO);
        authDTO.setShopCipher(null);
        return authDTO;
    }

    /**
     * 请求构建URl (202309版)
     */
    public static String generateNewRequestUrl(String requestPath, TiktokAuthBaseInfoDTO authBaseInfoDTO, Map<String,
            Object> paramMap, String bodyStr) {
        if (Objects.isNull(authBaseInfoDTO)) {
            throw new RuntimeException("TikTok授权信息不能为空!!!");
        }
        if (Objects.isNull(paramMap)) {
            paramMap = new HashMap<>();
        }
        JSONObject platformAppInfo = authBaseInfoDTO.getPlatformAppInfo();
        paramMap.put("app_key", platformAppInfo.getString("app_key"));
        paramMap.put("timestamp", Instant.now().getEpochSecond());
        if (StringUtils.isNotBlank(authBaseInfoDTO.getShopCipher())) {
            paramMap.put("shop_cipher", authBaseInfoDTO.getShopCipher());
        }
        String sign = TikTokUtil.generateSignNew(requestPath, paramMap, bodyStr,
                platformAppInfo.getString("app_secret"));
        paramMap.put("sign", sign);
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(ConstantTikTok.OPEN_API).append(requestPath).append("?")
                .append(paramMap.entrySet().stream().map(e -> e.getKey() + "=" + valueConvert(e.getValue()))
                        .collect(Collectors.joining("&")));
        return requestUrl.toString();
    }
}
