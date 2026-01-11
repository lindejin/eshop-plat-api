package com.eshop.util.platform.api.service.auth.taobao;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.taobao.TaoBaoApiClient;
import com.eshop.util.platform.api.client.taobao.TaoBaoApiInvoker;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoRequest;
import com.eshop.util.platform.api.client.taobao.response.TaoBaoResponse;
import com.eshop.util.platform.api.service.auth.taobao.dto.TaoBaoTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.taobao.dto.TaoBaoTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.taobao.vo.TaoBaoTokenCreateVO;
import com.eshop.util.platform.api.service.auth.taobao.vo.TaoBaoTokenRefreshVO;
import com.eshop.util.platform.api.service.auth.taobao.vo.TaoBaoTokenVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URLDecoder;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:52
 **/
@Component
public class TaoBaoAuthCall {

    @Resource
    private TaoBaoApiClient taoBaoApiClient;

    /**
     * 淘宝
     * 获取访问令牌（accessToken）
     */
    public TaoBaoTokenCreateVO tokenCreate(TaoBaoAppClientDTO acDTO, TaoBaoTokenCreateDTO reqDTO) throws Exception {
        String method = "taobao.top.auth.token.create";
        // 构建请求
        TaoBaoRequest request = new TaoBaoRequest();
        request.setMethod(method);
        request.setFormat(TaoBaoApiInvoker.FORMAT);
        request.setVersion(TaoBaoApiInvoker.VERSION);
        request.setSignMethod(TaoBaoApiInvoker.SIGN_METHOD);

        request.setParams(TaoBaoApiInvoker.objectToMapWithJsonString(reqDTO));

        // 执行请求
        TaoBaoResponse response = taoBaoApiClient.execute(request, acDTO);
        String respBody = response.getGopResponseBody();

        TaoBaoTokenCreateVO respVO = JSONObject.parseObject(respBody, TaoBaoTokenCreateVO.class);
        if (respVO == null) {
            respVO = new TaoBaoTokenCreateVO();
        }
        //解析json
        if (respVO.getTop_auth_token_create_response() != null && StringUtils.isNotBlank(respVO.getTop_auth_token_create_response().getToken_result())) {
            String tokenResult = respVO.getTop_auth_token_create_response().getToken_result();
            String requestId = respVO.getTop_auth_token_create_response().getRequest_id();

            TaoBaoTokenVO tokenVO = JSONObject.parseObject(tokenResult, TaoBaoTokenVO.class);
            if (tokenVO != null && StringUtils.isNotBlank(tokenVO.getTaobao_user_nick())) {
                // 关键1行：UTF-8解码
                String taobao_user_nick = URLDecoder.decode(tokenVO.getTaobao_user_nick(), "UTF-8");
                tokenVO.setTaobao_user_nick(taobao_user_nick);
            }
            respVO.setToken_vo(tokenVO);
            respVO.setRequest_id(requestId);
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    /**
     * 淘宝
     * 刷新访问令牌（refreshToken）
     * 根据refresh_token重新生成token，
     * 目前只有服务市场订购类应用可以刷新token，
     * 其他类型应用（如商家后台）使用固定时长token，不提供刷新功能。
     */
    public TaoBaoTokenRefreshVO tokenRefresh(TaoBaoAppClientDTO acDTO, TaoBaoTokenRefreshDTO reqDTO) throws Exception {
        String method = "taobao.top.auth.token.refresh";
        // 构建请求
        TaoBaoRequest request = new TaoBaoRequest();
        request.setMethod(method);
        request.setFormat(TaoBaoApiInvoker.FORMAT);
        request.setVersion(TaoBaoApiInvoker.VERSION);
        request.setSignMethod(TaoBaoApiInvoker.SIGN_METHOD);

        request.setParams(TaoBaoApiInvoker.objectToMapWithJsonString(reqDTO));

        // 执行请求
        TaoBaoResponse response = taoBaoApiClient.execute(request, acDTO);
        String respBody = response.getGopResponseBody();

        TaoBaoTokenRefreshVO respVO = JSONObject.parseObject(respBody, TaoBaoTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new TaoBaoTokenRefreshVO();
        }
        //解析json
        if (respVO.getTop_auth_token_refresh_response() != null && StringUtils.isNotBlank(respVO.getTop_auth_token_refresh_response().getToken_result())) {
            String tokenResult = respVO.getTop_auth_token_refresh_response().getToken_result();
            String requestId = respVO.getTop_auth_token_refresh_response().getRequest_id();

            TaoBaoTokenVO tokenVO = JSONObject.parseObject(tokenResult, TaoBaoTokenVO.class);
            if (tokenVO != null && StringUtils.isNotBlank(tokenVO.getTaobao_user_nick())) {
                // 关键1行：UTF-8解码
                String taobao_user_nick = URLDecoder.decode(tokenVO.getTaobao_user_nick(), "UTF-8");
                tokenVO.setTaobao_user_nick(taobao_user_nick);
            }
            respVO.setToken_vo(tokenVO);
            respVO.setRequest_id(requestId);
        }
        respVO.setRespBody(respBody);
        return respVO;
    }


}