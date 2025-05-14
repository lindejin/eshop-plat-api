package com.eshop.config;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class DhgateExample4 {
    public static void main(String[] args) throws Exception {
        //业务参数
        JSONObject businessDTO = new JSONObject();
        businessDTO.put("pages", "1");
        businessDTO.put("pageSize", "50");
        businessDTO.put("operateDateStart", "2019-01-12 18:20:21");
        businessDTO.put("state", "100100");

        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName("dh.item.list");
        dhRequest.setApiVersion("2.0");
        dhRequest.setBusinessDTO(businessDTO);

        String appKey = "";
        String appSecret = "";
        String accessToken = "6PhB1QaQOJ2UgGjqCt00Qm2xofGydKickXtaokIs";
        DhAppClientDTO publicDTO = new DhAppClientDTO();
        publicDTO.setAppKey(appKey);
        publicDTO.setAppSecret(appSecret);
        publicDTO.setAccessToken(accessToken);

        DhResponse execute = execute(dhRequest, publicDTO);
        System.out.println(execute.getGopResponseBody());
    }

    private static String execute(JSONObject params) {
        // 1. 创建OkHttp客户端实例（线程安全，建议全局复用）
        OkHttpClient client = new OkHttpClient();

        // 2. 构建请求URL并添加查询参数
        HttpUrl url = Objects.requireNonNull(
                        HttpUrl.parse("http://api.dhgate.com/dop/router"),
                        "Hardcoded URL should be valid"
                ).newBuilder()
                .build();

        // 3. 构建表单请求体（对应PHP的setPostFields）
        RequestBody formBody = getRequestBody(params);
        // 4. 创建请求对象
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)  // 设置为POST方法
                .addHeader("cache-control", "no-cache")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            // 5. 处理响应
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 6. 获取并打印响应体
            return response.body().string();
        } catch (IOException e) {
            // 7. 异常处理
            e.printStackTrace();
        }
        return null;
    }

    public static DhResponse execute(DhRequest dhRequest, DhAppClientDTO publicDTO) throws Exception {
        JSONObject businessDTO = dhRequest.getBusinessDTO();

        JSONObject commonParams = new JSONObject();
        commonParams.put("method", dhRequest.getApiName());
        commonParams.put("v", dhRequest.getApiVersion());
        commonParams.put("access_token", publicDTO.getAccessToken());
        commonParams.put("timestamp", System.currentTimeMillis());

        JSONObject params = new JSONObject();
        params.putAll(commonParams);
        params.putAll(businessDTO);

        String responseBody = execute(params);

        DhResponse dhResponse = new DhResponse();
        dhResponse.setGopResponseBody(responseBody);
        return dhResponse;
    }

    @NotNull
    private static JSONObject getJsonObject() {
        JSONObject businessDTO = new JSONObject();
        //公告参数
        businessDTO.put("access_token", "6PhB1QaQOJ2UgGjqCt00Qm2xofGydKickXtaokIs");
        businessDTO.put("method", "dh.item.list");
        businessDTO.put("timestamp", System.currentTimeMillis() + "");
        businessDTO.put("v", "2.0");
        businessDTO.put("locale", "en_US");

        //业务参数
        businessDTO.put("pages", "1");
        businessDTO.put("pageSize", "50");
        businessDTO.put("operateDateStart", "2019-01-12 18:20:21");
        businessDTO.put("state", "100100");
        return businessDTO;
    }

    private static RequestBody getRequestBody(JSONObject businessDTO) {
        // 使用 fastjson 的 JSONObject 构建业务参数对象

        FormBody.Builder builder = new FormBody.Builder();

        // 自动遍历所有字段
        for (Map.Entry<String, Object> entry : businessDTO.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // 空值检查（重要！）
            if (value != null) {
                builder.add(key, value.toString());
            }
        }

        RequestBody formBody = builder.build();
        return formBody;
    }
}
