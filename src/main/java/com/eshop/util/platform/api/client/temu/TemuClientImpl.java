package com.eshop.util.platform.api.client.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.exception.ApiSyncException;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import okhttp3.*;
import okio.BufferedSink;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class TemuClientImpl implements TemuClient {

    @Resource
    private TemuHttp temuHttp;

    @Resource
    private OkHttpClient client;

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
        String sign = TemuUtils.getSignKey(appKey, appSecret, accessToken, timestamp, type, dataType, jsonParams);

        jsonParams.put("app_key", appKey);
        jsonParams.put("access_token", accessToken);
        jsonParams.put("timestamp", timestamp);
        jsonParams.put("type", type);
        jsonParams.put("data_type", dataType);
        jsonParams.put("sign", sign);

        String jsonStr = temuHttp.execute(apiUrl, jsonParams.toJSONString());
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
            throw new ApiSyncException("Temu temuRequest is null.");
        }
        if (publicDTO == null) {
            throw new ApiSyncException("Temu publicDTO is null.");
        }
        if (StringUtils.isBlank(publicDTO.getLocation())) {
            throw new ApiSyncException("Temu location is null.");
        }

        if (StringUtils.isBlank(apiUrl)) {
            throw new ApiSyncException("Temu apiUrl is null.");
        }
        if (StringUtils.isBlank(appKey)) {
            throw new ApiSyncException("Temu appKey is null.");
        }
        if (StringUtils.isBlank(appSecret)) {
            throw new ApiSyncException("Temu appSecret is null.");
        }
        if (StringUtils.isBlank(accessToken)) {
            throw new ApiSyncException("Temu accessToken is null.");
        }
        if (StringUtils.isBlank(type)) {
            throw new ApiSyncException("Temu type is null.");
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
        if (temuRequest.getJsonParams() != null) {
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
        String sign = TemuUtils.getSignKey(appKey, appSecret, accessToken, timestamp, type, dataType, jsonParams);

        jsonParams.put("app_key", appKey);
        jsonParams.put("access_token", accessToken);
        jsonParams.put("code", code);
        jsonParams.put("timestamp", timestamp);
        jsonParams.put("type", type);
        jsonParams.put("data_type", dataType);
        jsonParams.put("sign", sign);

        String jsonStr = temuHttp.execute(apiUrl, jsonParams.toJSONString());
        TemuResponse response = new TemuResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }


    @Override
    public TemuResponse executeUpload(TemuFileRequest requestFile) throws Exception {
        String jsonStr = "";
        JSONObject jsonParams = requestFile.getJsonParams();
        byte[] byteFile = requestFile.getByteFile();
        String fileParam = requestFile.getFileParam();
        String fileName = requestFile.getFileName();
        String url = requestFile.getUrl();
        // 1. 准备输入流（模拟从网络或数据库获取）


        // 2. 创建 RequestBody
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), byteFile);
        // 3. 构建 Multipart 请求体
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        builder.addFormDataPart(
                fileParam,
                fileName,
                fileBody
        );

        if (jsonParams != null) {
            for (Map.Entry<String, Object> entry : jsonParams.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // 空值检查（重要！）
                if (value != null) {
                    builder.addFormDataPart(key, value.toString());
                }
            }
        }

        RequestBody requestBody = builder.build();

        // 4. 发送请求
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            jsonStr = response.body().string();
            String msg = jsonStr == null ? "" : jsonStr;
            msg = "Upload failed" + msg;
            if (!response.isSuccessful()) throw new IOException(msg);
        }
        TemuResponse response = new TemuResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }


    @Override
    public TemuResponse executeUploadPost(TemuFileRequest requestFile) throws Exception {
        JSONObject jsonParams = requestFile.getJsonParams();
        String url = requestFile.getUrl();
        if (jsonParams == null) {
            jsonParams = new JSONObject();
        }
        String jsonStr = temuHttp.execute(url, jsonParams.toJSONString());
        TemuResponse response = new TemuResponse();
        response.setGopResponseBody(jsonStr);
        return response;
    }
}
