package com.eshop.util.platform.api.service.auth.dewu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dewu.DewuTokenClient;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.client.dewu.request.DewuRequest;
import com.eshop.util.platform.api.client.dewu.response.DewuResponse;
import com.eshop.util.platform.api.service.auth.dewu.dto.DewuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.dewu.dto.DewuTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.dewu.vo.DewuTokenCreateVO;
import com.eshop.util.platform.api.service.auth.dewu.vo.DewuTokenRefreshVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DewuAuthCallService {

    @Autowired
    private DewuTokenClient dewuTokenClient;

    /**
     * 得物
     * 获取访问令牌（accessToken）
     */
    public DewuTokenCreateVO tokenCreate(DewuAppClientDTO acDTO, DewuTokenCreateDTO reqDTO) throws Exception {
        String method = "/api/v1/h5/passport/v1/oauth2/token";
        DewuRequest request = new DewuRequest();
        request.setMethod(method);

        DewuResponse response = dewuTokenClient.getAccessToken(reqDTO.getCode(), request, acDTO);
        String respBody = response.getResponseBody();
        DewuTokenCreateVO respVO = JSONObject.parseObject(respBody, DewuTokenCreateVO.class);
        if (respVO == null) {
            respVO = new DewuTokenCreateVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    /**
     * 得物
     * 刷新访问令牌（refreshToken）
     */
    public DewuTokenRefreshVO tokenRefresh(DewuAppClientDTO acDTO, DewuTokenRefreshDTO reqDTO) throws Exception {
        String method = "/api/v1/h5/passport/v1/oauth2/refresh_token";
        DewuRequest request = new DewuRequest();
        request.setMethod(method);

        DewuResponse response = dewuTokenClient.refreshToken(reqDTO.getRefreshToken(), request, acDTO);
        String respBody = response.getResponseBody();
        DewuTokenRefreshVO respVO = JSONObject.parseObject(respBody, DewuTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new DewuTokenRefreshVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

}
