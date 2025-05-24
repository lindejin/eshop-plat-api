package com.eshop.util.platform.api.client.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * temu
 * 万能API调用工具（极简版）
 */
@Component
public class TemuApiInvoker {

    @Resource
    private TemuClient temuClient;

    private static final String DATA_TYPE = "JSON";

    private static final String VERSION = null;

    /**
     * 通用执行方法
     *
     * @param type      接口类型（如："bg.modelinfo.get"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            TemuAppClientDTO temuAcDTO,
            String type,
            Class<T> respClass,
            Object dto
    ) throws Exception {
        // 构建请求
        TemuRequest request = new TemuRequest();
        request.setType(type);
        request.setDataType(DATA_TYPE);
        request.setVersion(VERSION);
        request.setJsonParams(FastJsonUtil.toJsonToJsonObj(dto));

        // 执行请求
        TemuResponse response = temuClient.execute(request, temuAcDTO);
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
