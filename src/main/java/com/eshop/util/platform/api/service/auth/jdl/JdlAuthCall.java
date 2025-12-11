package com.eshop.util.platform.api.service.auth.jdl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.jd.JdLogisticsTokenClient;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.client.jd.response.JdLogisticsResponse;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenCreateVO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenRefreshVO;
import org.apache.commons.lang3.StringUtils;
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
    public JdLogisticsTokenCreateVO tokenCreate(String oauthUrl, JdLogisticsAppClientDTO appDTO, JdLogisticsTokenCreateDTO reqDTO) throws Exception {

        JdLogisticsResponse response = jdLogisticsTokenClient.tokenCreate(reqDTO.getCode(), oauthUrl, appDTO);
        String respBody = response.getGopResponseBody();
        String actualJson = respBody.trim();

        // 仅当字符串被双引号包裹且内部有JSON结构时才处理转义
        if (actualJson.startsWith("\"") && actualJson.endsWith("\"") &&
                actualJson.contains("\\\"")) {
            // 去除外层引号
            actualJson = actualJson.substring(1, actualJson.length() - 1);
            // 替换内部的转义双引号
            actualJson = actualJson.replace("\\\"", "\"");
        }
        JdLogisticsTokenCreateVO respVO = JSONObject.parseObject(actualJson, JdLogisticsTokenCreateVO.class);
        if (respVO == null) {
            respVO = new JdLogisticsTokenCreateVO();
        }
        respVO.setRespBody(respBody);
        return respVO;


    }

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
        if (respVO.getData() != null && StringUtils.isNotBlank(respVO.getData().getAccessToken())) {
            respVO.setAccessToken(respVO.getData().getAccessToken());
            respVO.setRefreshToken(respVO.getData().getRefreshToken());

            respVO.setAccessExpire(respVO.getData().getAccessExpire());
            respVO.setRefreshExpire(respVO.getData().getRefreshExpire());

            respVO.setClientId(respVO.getData().getClientId());
            respVO.setSellerId(respVO.getData().getSellerId());
        }
        respVO.setRespBody(respBody);
        return respVO;
    }
}
