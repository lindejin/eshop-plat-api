package com.eshop.util.platform.api.service.auth.douyin;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.douyin.DouyinTokenClient;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.client.douyin.request.DouyinRequest;
import com.eshop.util.platform.api.client.douyin.response.DouyinResponse;
import com.eshop.util.platform.api.client.douyin.util.ApiSigner;
import com.eshop.util.platform.api.service.auth.douyin.dto.DouyinTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.douyin.dto.DouyinTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.douyin.vo.DouyinTokenCreateVO;
import com.eshop.util.platform.api.service.auth.douyin.vo.DouyinTokenRefreshVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DouyinAuthCall {


    @Autowired
    private DouyinTokenClient douyinTokenClient;

    /**
     * 得物
     * 获取访问令牌（accessToken）
     */
    public DouyinTokenCreateVO tokenCreate(DouyinAppClientDTO acDTO, DouyinTokenCreateDTO reqDTO) throws Exception {
        String method = "token.create";
        String version = "2";
        String urlPath = "/token/create";

        String paramJson = ApiSigner.serializeParamsPlain(reqDTO);
        String paramJsonNot = ApiSigner.serializeParams(reqDTO);

        DouyinRequest request = new DouyinRequest();
        request.setVersion(version);
        request.setMethod(method);
        request.setUrlPath(urlPath);
        request.setParamJson(paramJson);
        request.setParamJsonNot(paramJsonNot);

        DouyinResponse response = douyinTokenClient.execute(request, acDTO);
        String respBody = response.getGopResponseBody();
        DouyinTokenCreateVO respVO = JSONObject.parseObject(respBody, DouyinTokenCreateVO.class);
        if (respVO == null) {
            respVO = new DouyinTokenCreateVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    /**
     * 得物
     * 刷新访问令牌（refreshToken）
     */
    public DouyinTokenRefreshVO tokenRefresh(DouyinAppClientDTO acDTO, DouyinTokenRefreshDTO reqDTO) throws Exception {
        String method = "/api/v1/h5/passport/v1/oauth2/refresh_token";
        DouyinRequest request = new DouyinRequest();
        request.setMethod(method);

        DouyinResponse response = douyinTokenClient.execute(request, acDTO);
        String respBody = response.getGopResponseBody();
        DouyinTokenRefreshVO respVO = JSONObject.parseObject(respBody, DouyinTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new DouyinTokenRefreshVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

}
