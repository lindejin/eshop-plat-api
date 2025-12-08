package com.eshop.util.platform.api.service.auth.xiaohongshu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuTokenClient;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuRequest;
import com.eshop.util.platform.api.client.xiaohongshu.response.XiaohongshuResponse;
import com.eshop.util.platform.api.service.auth.xiaohongshu.dto.XiaohongshuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.dto.XiaohongshuTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.vo.XiaohongshuTokenCreateVO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.vo.XiaohongshuTokenRefreshVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XiaohongshuAuthCall {

    @Autowired
    private XiaohongshuTokenClient xiaohongshuTokenClient;

    /**
     * 小红书
     * 获取访问令牌（accessToken）
     */
    public XiaohongshuTokenCreateVO tokenCreate(XiaohongshuAppClientDTO acDTO, XiaohongshuTokenCreateDTO reqDTO) throws Exception {
        String method = "oauth.getAccessToken";
        String version = "2.0";
        XiaohongshuRequest request = new XiaohongshuRequest();
        request.setMethod(method);
        request.setVersion(version);

        XiaohongshuResponse response = xiaohongshuTokenClient.getAccessToken(reqDTO.getCode(), request, acDTO);
        String respBody = response.getGopResponseBody();
        XiaohongshuTokenCreateVO respVO = JSONObject.parseObject(respBody, XiaohongshuTokenCreateVO.class);
        if (respVO == null) {
            respVO = new XiaohongshuTokenCreateVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    /**
     * 小红书
     * 刷新访问令牌（refreshToken）
     */
    public XiaohongshuTokenRefreshVO tokenRefresh(XiaohongshuAppClientDTO acDTO, XiaohongshuTokenRefreshDTO reqDTO) throws Exception {
        String method = "oauth.refreshToken";
        String version = "2.0";
        XiaohongshuRequest request = new XiaohongshuRequest();
        request.setMethod(method);
        request.setVersion(version);

        XiaohongshuResponse response = xiaohongshuTokenClient.refreshToken(reqDTO.getRefreshToken(), request, acDTO);
        String respBody = response.getGopResponseBody();
        XiaohongshuTokenRefreshVO respVO = JSONObject.parseObject(respBody, XiaohongshuTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new XiaohongshuTokenRefreshVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }


}
