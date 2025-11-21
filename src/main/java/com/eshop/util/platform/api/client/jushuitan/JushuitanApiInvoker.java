package com.eshop.util.platform.api.client.jushuitan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanRequest;
import com.eshop.util.platform.api.client.jushuitan.response.JushuitanResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * jushuitan
 * 万能API调用工具（极简版）
 */
@Component
public class JushuitanApiInvoker {

    @Resource
    private JushuitanClient jushuitanClient;

    //字符编码（固定值：utf-8）
    private static final String CHARSET = "utf-8";

    //版本号，固定传2
    private static final String VERSION = "2";

    /**
     * 通用执行方法
     *
     * @param method      接口类型（如："/open/orders/single/query"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            JushuitanAppClientDTO temuAcDTO,
            String method,
            Class<T> respClass,
            Object dto
    ) throws Exception {
        // 构建请求
        JushuitanRequest request = new JushuitanRequest();
        request.setMethod(method);
        request.setCharset(CHARSET);
        request.setVersion(VERSION);
        request.setJsonParams(toJsonToJsonObj(dto));

        // 执行请求
        JushuitanResponse response = jushuitanClient.execute(request, temuAcDTO);
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
