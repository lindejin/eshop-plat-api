package com.eshop.util.platform.api.client.dewu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.client.dewu.request.DewuRequest;
import com.eshop.util.platform.api.client.dewu.response.DewuResponse;
import com.eshop.util.platform.api.client.dewu.util.JsonUtil;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 得物
 * 万能API调用工具（极简版）
 */
@Component
@Slf4j
public class DewuApiInvoker {

    @Resource
    private DewuClient dewuClient;

    /**
     * 通用执行方法
     *
     * @param acDTO     应用配置
     * @param method    接口类型（如："order.query"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            DewuAppClientDTO acDTO,
            String method,
            Class<T> respClass,
            Object dto
    ) throws Exception {
        // 构建请求
        DewuRequest request = new DewuRequest();
        request.setMethod(method);
        request.setParams(objectToMapWithJsonString(dto));

        // 执行请求
        DewuResponse response = dewuClient.execute(request, acDTO);
        String respBody = response.getResponseBody();

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
     * 对象转Map，复杂对象属性保持原样
     *
     * @param dto 要转换的对象
     * @return 转换后的Map
     */
    public static Map<String, Object> objectToMapWithJsonString(Object dto) {
        HashMap requestMap = (HashMap) JsonUtil.string2Obj(JsonUtil.obj2String(dto), HashMap.class);
        return requestMap;
    }

    /**
     * 使用反射方式处理对象转Map
     */
    private static Map<String, Object> objectToMapWithReflection(Object obj) {
        Map<String, Object> resultMap = new HashMap<>();

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

                resultMap.put(fieldName, value);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("对象转Map失败", e);
        }

        return resultMap;
    }
}