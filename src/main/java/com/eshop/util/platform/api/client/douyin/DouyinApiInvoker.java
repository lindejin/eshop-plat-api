package com.eshop.util.platform.api.client.douyin;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.client.douyin.request.DouyinRequest;
import com.eshop.util.platform.api.client.douyin.response.DouyinResponse;
import com.eshop.util.platform.api.client.douyin.util.ApiSigner;
import com.eshop.util.platform.api.client.douyin.util.GsonUtil;
import com.eshop.util.platform.api.structure.BaseResponseVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DouyinApiInvoker {

    @Resource
    private DouyinClient douyinClient;

    /**
     * 通用执行方法
     *
     * @param method    接口类型（如："express.queryEbillOrder"）
     * @param respClass 响应VO类型
     * @param dto       业务参数DTO
     * @param <T>       响应类型
     * @return 统一响应对象
     */
    public <T extends BaseResponseVO> T execute(
            DouyinAppClientDTO acDTO,
            String method,
            String version,
            String urlPath,
            Class<T> respClass,
            Object dto
    ) throws Exception {

        String paramJson = GsonUtil.marshal(dto);
        String paramJsonNot = ApiSigner.serializeParams(dto);
        // 构建请求
        DouyinRequest request = new DouyinRequest();
        request.setVersion(version);
        request.setMethod(method);
        request.setUrlPath(urlPath);
        request.setParamJson(paramJson);
        request.setParamJsonNot(paramJsonNot);

        // 执行请求
        DouyinResponse response = douyinClient.execute(request, acDTO);
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
