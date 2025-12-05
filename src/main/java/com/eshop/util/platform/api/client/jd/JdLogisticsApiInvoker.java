package com.eshop.util.platform.api.client.jd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsRequest;
import com.eshop.util.platform.api.client.jd.response.JdLogisticsResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 京东物流
 * 万能API调用工具（极简版）
 */
@Component
public class JdLogisticsApiInvoker {

    @Resource
    private JdLogisticsClient jdLogisticsClient;


    //版本号，固定传2.0
    private static final String VERSION = "2.0";


    /**
     * 通用执行方法
     * @param acDTO
     * @param domain
     * @param urlPath
     * @param method
     * @param respClass
     * @param dto
     * @return
     * @param <T>
     * @throws Exception
     */
    public <T extends BaseResponseVO> T execute(
            JdLogisticsAppClientDTO acDTO,
            String domain,
            String urlPath,
            String method,
            String version,
            Class<T> respClass,
            Object dto
    ) throws Exception {
        // 构建请求
        JdLogisticsRequest request = new JdLogisticsRequest();
        request.setDomain(domain);
        request.setUrlPath(urlPath);
        request.setVersion(version);
        request.setMethod(method);
        request.setParamJson(toJson(dto));
        // 执行请求
        JdLogisticsResponse response = jdLogisticsClient.execute(request, acDTO);
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

    // 对象转 JSON（健壮配置）
    public static String toJson(Object obj) {
        ArrayList var1 = new ArrayList();
        var1.add(obj);
        return JSON.toJSONString(
                var1,
                SerializerFeature.WriteDateUseDateFormat,// 标准日期格式
                SerializerFeature.DisableCircularReferenceDetect// 禁用循环引用检测
        );
    }

}