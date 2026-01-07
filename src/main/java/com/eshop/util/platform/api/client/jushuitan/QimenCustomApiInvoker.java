package com.eshop.util.platform.api.client.jushuitan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomRequest;
import com.eshop.util.platform.api.client.jushuitan.response.QimenCustomResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * qimen自定义
 * 万能API调用工具（极简版）
 */
@Component
public class QimenCustomApiInvoker {

    @Resource
    private QimenCustomApiClient qimenCustomApiClient;

    /**
     * 返回内容响应格式。不传默认为xml格式，可选值：xml，json。
     */
    private static final String FORMAT = "json";

    /**
     * API协议版本，可选值：2.0
     */
    private static final String VERSION = "2.0";

    /**
     * 签名的摘要算法，可选值为：hmac，md5，hmac-sha256。
     */
    private static final String SIGN_METHOD = "hmac";
    ;

    /**
     * 通用执行方法
     *
     * @param method    接口类型（如："jushuitan.order.list.query"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            QimenCustomAppClientDTO acDTO,
            String method,
            Class<T> respClass,
            Object dto
    ) throws Exception {
        // 构建请求
        QimenCustomRequest request = new QimenCustomRequest();
        request.setMethod(method);
        request.setFormat(FORMAT);
        request.setVersion(VERSION);
        request.setSignMethod(SIGN_METHOD);

        request.setParams(objectToMapWithJsonString(dto));

        // 执行请求
        QimenCustomResponse response = qimenCustomApiClient.execute(request, acDTO);
        String respBody = response.getGopResponseBody();

        // 处理响应
        return handleResponse(respBody, respClass);
    }

    /**
     * 实例化返回对象
     */
    private static <T extends BaseResponseVO> T handleResponse(String body, Class<T> respClass) throws Exception {
        T vo = JSONObject.parseObject(body, respClass);
        if (vo == null) vo = respClass.getDeclaredConstructor().newInstance();
        vo.setRespBody(body);  // 统一设置响应体
        return vo;
    }

    /**
     * 对象转Map，复杂对象属性转为JSON字符串
     *
     * @param obj 要转换的对象
     * @return 转换后的Map
     */
    public static Map<String, String> objectToMapWithJsonString(Object obj) {
        Map<String, String> resultMap = new HashMap<>();

        if (obj == null) {
            return resultMap;
        }

        try {
            // 先用FastJSON将对象转为JSONObject
            JSONObject jsonObject = (JSONObject) JSON.toJSON(obj);

            // 遍历所有字段
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // 处理属性值
                if (value == null) {
//                    resultMap.put(key, null);
                } else if (isStrictSimpleType(value)) {
                    // 基本类型直接转为字符串
                    resultMap.put(key, String.valueOf(value));
                } else {
                    // 复杂对象转为JSON字符串
                    resultMap.put(key, JSON.toJSONString(value));
                }
            }

        } catch (Exception e) {
            // 如果FastJSON转换失败，使用反射方式
            return objectToMapWithReflection(obj);
        }

        return resultMap;
    }

    /**
     * 使用反射方式处理对象转Map
     */
    private static Map<String, String> objectToMapWithReflection(Object obj) {
        Map<String, String> resultMap = new HashMap<>();

        if (obj == null) {
            return resultMap;
        }

        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);

                if (value == null) {
                    resultMap.put(fieldName, null);
                } else if (isStrictSimpleType(value)) {
                    // 基本类型直接转为字符串
                    resultMap.put(fieldName, String.valueOf(value));
                } else {
                    // 复杂对象转为JSON字符串
                    resultMap.put(fieldName, JSON.toJSONString(value));
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("对象转Map失败", e);
        }

        return resultMap;
    }

    /**
     * 判断是否为简单类型
     */
    private static boolean isSimpleType(Object value) {
        return value instanceof String ||
                value instanceof Number ||
                value instanceof Boolean ||
                value instanceof Character ||
                value.getClass().isPrimitive() ||
                value instanceof java.util.Date;
    }

    /**
     * 更严格的简单类型判断（可选）
     */
    private static boolean isStrictSimpleType(Object value) {
        Class<?> clazz = value.getClass();
        return clazz == String.class ||
                clazz == Integer.class || clazz == int.class ||
                clazz == Long.class || clazz == long.class ||
                clazz == Double.class || clazz == double.class ||
                clazz == Float.class || clazz == float.class ||
                clazz == Boolean.class || clazz == boolean.class ||
                clazz == Character.class || clazz == char.class ||
                clazz == Byte.class || clazz == byte.class ||
                clazz == Short.class || clazz == short.class ||
                java.util.Date.class.isAssignableFrom(clazz);
    }

}
