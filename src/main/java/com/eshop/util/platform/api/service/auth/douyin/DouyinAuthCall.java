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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DouyinAuthCall {


    @Autowired
    private DouyinTokenClient douyinTokenClient;

    /**
     * 抖音
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

        if (respVO.getData() != null && StringUtils.isNotBlank(respVO.getData().getAccess_token())) {
            respVO.setAccess_token(respVO.getData().getAccess_token());
            respVO.setExpires_in(respVO.getData().getExpires_in());
            respVO.setRefresh_token(respVO.getData().getRefresh_token());
            respVO.setScope(respVO.getData().getScope());
            respVO.setShop_id(respVO.getData().getShop_id());
            respVO.setShop_name(respVO.getData().getShop_name());
            respVO.setAuthority_id(respVO.getData().getAuthority_id());
            respVO.setAuth_subject_type(respVO.getData().getAuth_subject_type());
            respVO.setEncrypt_operator(respVO.getData().getEncrypt_operator());
            respVO.setOperator_name(respVO.getData().getOperator_name());
            respVO.setShop_biz_type(respVO.getData().getShop_biz_type());
            respVO.setToutiao_id(respVO.getData().getToutiao_id());
            respVO.setToken_type(respVO.getData().getToken_type());
        }

        respVO.setRespBody(respBody);
        return respVO;
    }

    /**
     * 抖音
     * 刷新访问令牌（refreshToken）
     */
    public DouyinTokenRefreshVO tokenRefresh(DouyinAppClientDTO acDTO, DouyinTokenRefreshDTO reqDTO) throws Exception {
        String method = "token.refresh";
        String version = "2";
        String urlPath = "/token/refresh";


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
        DouyinTokenRefreshVO respVO = JSONObject.parseObject(respBody, DouyinTokenRefreshVO.class);
        if (respVO == null) {
            respVO = new DouyinTokenRefreshVO();
        }

        if (respVO.getData() != null && StringUtils.isNotBlank(respVO.getData().getAccess_token())) {
            respVO.setAccess_token(respVO.getData().getAccess_token());
            respVO.setExpires_in(respVO.getData().getExpires_in());
            respVO.setRefresh_token(respVO.getData().getRefresh_token());
            respVO.setScope(respVO.getData().getScope());
            respVO.setShop_id(respVO.getData().getShop_id());
            respVO.setShop_name(respVO.getData().getShop_name());
            respVO.setAuthority_id(respVO.getData().getAuthority_id());
            respVO.setAuth_subject_type(respVO.getData().getAuth_subject_type());
            respVO.setEncrypt_operator(respVO.getData().getEncrypt_operator());
            respVO.setOperator_name(respVO.getData().getOperator_name());
            respVO.setShop_biz_type(respVO.getData().getShop_biz_type());
            respVO.setToutiao_id(respVO.getData().getToutiao_id());
            respVO.setToken_type(respVO.getData().getToken_type());
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

}
