package com.eshop.util.platform.api.client.cainiao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoAppClientDTO;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoRequest;
import com.eshop.util.platform.api.client.cainiao.response.CainiaoResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CainiaoApiInvoker {

    @Autowired
    private CainiaoClient cainiaoClient;

    /**
     * 通用执行方法
     *
     * @param msgType   接口类型（如："CLOUDPRINT_STANDARD_TEMPLATES"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            CainiaoAppClientDTO acDTO,
            String msgType,
            Class<T> respClass,
            Object dto
    ) throws Exception {

        String requestContent = JSON.toJSONString(dto);
        // 构建请求
        CainiaoRequest request = new CainiaoRequest();
        request.setMsgType(msgType);
        request.setRequestContent(requestContent);

        // 执行请求
        CainiaoResponse response = cainiaoClient.execute(request, acDTO);
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
}