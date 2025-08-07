package com.eshop.api3;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.time.Instant;

@Slf4j
public class Test007 {


    public static void main(String[] args) throws IOException {
        String erpAccount = "wj_erp_p";
        String erpSecretKey = "c8chqu7tj7ky735tuz0sqlclxz2r1993";
        long timestamp = getEpochSecond();
        String signature = generateSignature(erpAccount, erpSecretKey, timestamp);

        System.out.println("Signature: " + signature);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("ERP Account: " + erpAccount);
        String postUrl = "http://119.91.146.179";
        String apiName = "/api/Erp/index";

        String bodyResp = "{\n" +
                "  \"orderid\" : \"10000497272521\",\n" +
                "  \"ydh\" : \"10000497272521\",\n" +
                "  \"uid\" : \"2013\",\n" +
                "  \"uname\" : \"TK本地-TH\",\n" +
                "  \"weight\" : 1,\n" +
                "  \"volume\" : null,\n" +
                "  \"channel_id\" : 2068,\n" +
                "  \"remark\" : \"wj\",\n" +
                "  \"from_address\" : {\n" +
                "    \"name\" : \"ADDRESS\",\n" +
                "    \"company\" : \"to one\",\n" +
                "    \"addr1\" : \"6161 State Rd\",\n" +
                "    \"city\" : \"Palm Coast\",\n" +
                "    \"tel\" : \"88888888\",\n" +
                "    \"state\" : \"FL\",\n" +
                "    \"postcode\" : \"32164\",\n" +
                "    \"country\" : \"US\",\n" +
                "    \"addr2\" : \"\",\n" +
                "    \"email\" : \"0@123\"\n" +
                "  },\n" +
                "  \"to_address\" : {\n" +
                "    \"addr1\" : \"108 Oakdale Avenue\",\n" +
                "    \"addr2\" : \"\",\n" +
                "    \"city\" : \"Peachtree City\",\n" +
                "    \"company\" : \"Cynthia Frederick -\",\n" +
                "    \"country\" : \"US\",\n" +
                "    \"name\" : \"Cynthia Frederick -\",\n" +
                "    \"postcode\" : \"30269\",\n" +
                "    \"state\" : \"GA\",\n" +
                "    \"tel\" : \"（770)855-6741\"\n" +
                "  },\n" +
                "  \"packages\" : [ {\n" +
                "    \"xh\" : 1,\n" +
                "    \"weight\" : 1,\n" +
                "    \"length\" : 10,\n" +
                "    \"width\" : 20,\n" +
                "    \"height\" : 30,\n" +
                "    \"boxnote\" : \"sku*1\"\n" +
                "  } ],\n" +
                "  \"shenbao_items\" : [ {\n" +
                "    \"xh\" : 1,\n" +
                "    \"itemcn\" : \"男士T恤\",\n" +
                "    \"itemen\" : \"men t shirt\",\n" +
                "    \"sku\" : \"1-816L18-white-M\",\n" +
                "    \"cweight\" : 1,\n" +
                "    \"price\" : \"5.0\",\n" +
                "    \"num\" : 1,\n" +
                "    \"useage\" : \"\",\n" +
                "    \"depict\" : \"deserunt\",\n" +
                "    \"cz\" : \"\",\n" +
                "    \"hscode\" : \"6217109000\"\n" +
                "  } ],\n" +
                "  \"create_time\" : 1754536385,\n" +
                "  \"update_time\" : 1754536385,\n" +
                "  \"source\" : \"wj\"\n" +
                "}";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyResp);
        Request request = new Request.Builder()
                .url(postUrl+apiName)
                .method("POST", body)
                .addHeader("erpAccount", erpAccount)
                .addHeader("timestamp", timestamp+"")
                .addHeader("signature", signature)
                .addHeader("Content-Type", "application/json")
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
