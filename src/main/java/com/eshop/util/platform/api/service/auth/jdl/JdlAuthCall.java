package com.eshop.util.platform.api.service.auth.jdl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.jd.JdLogisticsTokenClient;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.client.jd.response.JdLogisticsResponse;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenRefreshVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdlAuthCall {


    @Autowired
    private JdLogisticsTokenClient jdLogisticsTokenClient;

    /**
     * 京东物流
     * 刷新访问令牌（refreshToken）
     */
    public JdLogisticsTokenRefreshVO tokenRefresh(String oauthUrl, JdLogisticsAppClientDTO appDTO, JdLogisticsTokenRefreshDTO reqDTO) throws Exception {

        JdLogisticsResponse response = jdLogisticsTokenClient.tokenRefresh(reqDTO.getRefreshToken(), oauthUrl, appDTO);
        String respBody = response.getGopResponseBody();
        JdLogisticsTokenRefreshVO respVO = JSONObject.parseObject(respBody, JdLogisticsTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new JdLogisticsTokenRefreshVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }
}
