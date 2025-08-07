package com.eshop.api3;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.time.Instant;

@Slf4j
public class Test005 {


    public static void main(String[] args) throws IOException {
        String erpAccount = "shipos_1700";
        long timestamp = 1753696710L;
        String signature = "354cf9dd7d86d5dcbd22f47a619755e6";

        System.out.println("Signature: " + signature);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("ERP Account: " + erpAccount);
        String postUrl = "http://119.91.146.179";
        String apiName = "/api/Erp/getChannel";


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(postUrl + apiName)
                .method("POST", body)
                .addHeader("erpAccount", erpAccount)
                .addHeader("timestamp", timestamp + "")
                .addHeader("signature", signature)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    /**
     * 获取10位秒级时间戳
     */
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
}
