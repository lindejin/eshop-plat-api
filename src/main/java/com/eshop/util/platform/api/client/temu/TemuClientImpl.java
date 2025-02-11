package com.eshop.util.platform.api.client.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuClientImpl implements TemuClient {

    @Autowired
    private TemuHttp temuHttp;

    @Override
    public TemuResponse execute(TemuRequest temuRequest, TemuAppClientDTO publicDTO) throws Exception {
        checkParams(temuRequest, publicDTO);

        String apiUrl = publicDTO.getEnvUrl();

        String accessToken = publicDTO.getAccessToken();
        String appKey = publicDTO.getAppKey();
        String appSecret = publicDTO.getAppSecret();
        String type = temuRequest.getType();
//        String version = temuRequest.getVersion();
        String dataType = temuRequest.getDataType();

        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;

        JSONObject jsonParams = temuRequest.getJsonParams();
        if (jsonParams == null) {
            jsonParams = new JSONObject();
        }

        //md5加密签名
        String sign = TemuUtils.getSign(appKey, appSecret, accessToken, timestamp, type, dataType, jsonParams);

        jsonParams.put("app_key", appKey);
        jsonParams.put("access_token", accessToken);
        jsonParams.put("timestamp", timestamp);
        jsonParams.put("type", type);
        jsonParams.put("data_type", dataType);
        jsonParams.put("sign", sign);

        String jsonStr = temuHttp.postForJson(apiUrl, jsonParams.toJSONString());
        TemuResponse response = new TemuResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }

    /**
     * 检查参数
     */
    private void checkParams(TemuRequest temuRequest, TemuAppClientDTO publicDTO) throws Exception {
        String apiUrl = publicDTO.getEnvUrl();
        String appKey = publicDTO.getAppKey();
        String appSecret = publicDTO.getAppSecret();
        String accessToken = publicDTO.getAccessToken();
        String type = temuRequest.getType();

        if (temuRequest == null) {
            throw new Exception("Temu temuRequest is null.");
        }
        if (publicDTO == null) {
            throw new Exception("Temu publicDTO is null.");
        }
        if (StringUtils.isBlank(publicDTO.getLocation())) {
            throw new Exception("Temu location is null.");
        }

        if (StringUtils.isBlank(apiUrl)) {
            throw new Exception("Temu apiUrl is null.");
        }
        if (StringUtils.isBlank(appKey)) {
            throw new Exception("Temu appKey is null.");
        }
        if (StringUtils.isBlank(appSecret)) {
            throw new Exception("Temu appSecret is null.");
        }
        if (StringUtils.isBlank(accessToken)) {
            throw new Exception("Temu accessToken is null.");
        }
        if (StringUtils.isBlank(type)) {
            throw new Exception("Temu type is null.");
        }
    }

    @Override
    public TemuResponse tokenCreateAndRefresh(TemuRequest temuRequest, TemuAppClientDTO publicDTO) throws Exception {
        String apiUrl = publicDTO.getEnvUrl();

        String accessToken = publicDTO.getAccessToken();
        String appKey = publicDTO.getAppKey();
        String appSecret = publicDTO.getAppSecret();
        String type = temuRequest.getType();
//        String version = temuRequest.getVersion();
        String dataType = temuRequest.getDataType();

        String code = null;
        if (temuRequest.getJsonParams() !=null) {
            JSONObject jsonParams = temuRequest.getJsonParams();
            code = jsonParams.getString("code");

        }

        if (StringUtils.isEmpty(accessToken)) {
            accessToken = code;
        }

        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;

        JSONObject jsonParams = temuRequest.getJsonParams();
        if (jsonParams == null) {
            jsonParams = new JSONObject();
        }

        //md5加密签名
        String sign = TemuUtils.getSign(appKey, appSecret, accessToken, timestamp, type, dataType, jsonParams);

        jsonParams.put("app_key", appKey);
        jsonParams.put("access_token", accessToken);
        jsonParams.put("code", code);
        jsonParams.put("timestamp", timestamp);
        jsonParams.put("type", type);
        jsonParams.put("data_type", dataType);
        jsonParams.put("sign", sign);

        String jsonStr = temuHttp.postForJson(apiUrl, jsonParams.toJSONString());
        TemuResponse response = new TemuResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }
}
