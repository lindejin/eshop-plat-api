package com.eshop.api3;

import com.alibaba.fastjson.JSONObject;
import com.moczul.ok2curl.CurlInterceptor;
import com.moczul.ok2curl.logger.Logger;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;

@Slf4j
public class Test003 {

    //账号：
    //	erpAccount: wj_erp_p
    //	appKey:c8chqu7tj7ky735tuz0sqlclxz2r1993
    //接口地址：
    //	http://119.91.146.179
    //api文档地址：
    //	5m7g32gk5h.apifox.cn

    public static void main(String[] args) {
        String erpAccount = "wj_erp_p";
        String erpSecretKey = "c8chqu7tj7ky735tuz0sqlclxz2r1993";
        long timestamp = getEpochSecond();
        String signature = generateSignature(erpAccount, erpSecretKey, timestamp);

        System.out.println("Signature: " + signature);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("ERP Account: " + erpAccount);
        System.out.println("ERP Secret Key: " + erpSecretKey);
        String postUrl = "http://119.91.146.179";
        String apiName = "/api/Erp/getChannel";
        execute(erpAccount, erpSecretKey, postUrl, apiName);
    }

    // 获取10位秒级时间戳
    private static long getEpochSecond() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 生成MD5签名
     * signature = MD5(ERP账号 + 时间戳(10位) + ERP密钥 + 时间戳(10位)) 加密为32位小写
     */

    public static String generateSignature(String erpAccount, String erpSecretKey, long timestamp) {
        try {
            // 构建待签名字符串
            String rawData = erpAccount + timestamp + erpSecretKey + timestamp;

            // 使用Apache Commons Codec计算MD5
            return DigestUtils.md5Hex(rawData);

        } catch (Exception e) {
            throw new RuntimeException("签名生成失败: " + e.getMessage(), e);
        }
    }

    public static void execute(String erpAccount, String erpSecretKey, String postUrl, String apiName) {
        long timestamp = getEpochSecond();
        String signature = generateSignature(erpAccount, erpSecretKey, timestamp);
        String respBody = null;
        Integer statusCode = null;
        try {
            // 拼接请求地址
            String apiUrl = postUrl + apiName;
            // 拼接请求参数
            //创建okhttp请求客户端并发起请求
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .retryOnConnectionFailure(true)  // 启用连接失败重试
                    .addNetworkInterceptor(new CurlInterceptor(new Logger() {
                        @Override
                        public void log(String message) {
                            log.info(message);
                        }
                    }))
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody requestBody =  RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .method("POST", requestBody)
                    .addHeader("erpAccount", erpAccount)
                    .addHeader("timestamp", timestamp + "")
                    .addHeader("signature", signature)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                //解析请求
                statusCode = response.code();
                if (statusCode == 200) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        respBody = body.string(); // 读取 JSON 响应体
                    } else {
                        throw new IOException("Response body is null despite 200 status code");
                    }
                } else {
                    // 处理非 200 状态码（例如 4xx、5xx 错误）
                    throw new IOException("HTTP request failed with status code: " + statusCode);
                }
            }

        } catch (Exception e) {
            log.error("feizhen api请求(api)异常", e);
            // 其他异常处理
            JSONObject result = new JSONObject();
            result.put("error", e.getMessage());
            result.put("message", e.getMessage());
            respBody = result.toJSONString();
        }
        log.info(respBody);
        return;
    }




}
