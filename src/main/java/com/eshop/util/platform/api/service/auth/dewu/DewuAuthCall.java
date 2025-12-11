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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DewuAuthCall {

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
        if (respVO.getData()!=null && StringUtils.isNotBlank(respVO.getData().getAccess_token())) {
            respVO.setOpen_id(respVO.getData().getOpen_id());
            respVO.setAccess_token(respVO.getData().getAccess_token());
            respVO.setRefresh_token(respVO.getData().getRefresh_token());
            respVO.setAccess_token_expires_in(respVO.getData().getAccess_token_expires_in());
            respVO.setRefresh_token_expires_in(respVO.getData().getRefresh_token_expires_in());
            respVO.setScope(respVO.getData().getScope());
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
        if (respVO.getData()!=null && StringUtils.isNotBlank(respVO.getData().getAccess_token())) {
            respVO.setOpen_id(respVO.getData().getOpen_id());
            respVO.setAccess_token(respVO.getData().getAccess_token());
            respVO.setRefresh_token(respVO.getData().getRefresh_token());
            respVO.setAccess_token_expires_in(respVO.getData().getAccess_token_expires_in());
            respVO.setRefresh_token_expires_in(respVO.getData().getRefresh_token_expires_in());
            respVO.setScope(respVO.getData().getScope());
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

}
