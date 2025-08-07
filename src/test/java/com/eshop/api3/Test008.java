package com.eshop.api3;

import com.alibaba.fastjson.JSONObject;
import com.eshop.api3.vo.FeizhenMakePdfLabelRespVO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.time.Instant;

@Slf4j
public class Test008 {


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

        String bodyResp = "";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(postUrl+"/api/Erp/makePdf?orderid=10000497272521")
                .method("GET",null)
                .addHeader("erpAccount", erpAccount)
                .addHeader("timestamp", timestamp+"")
                .addHeader("signature", signature)
                .addHeader("Content-Type", "application/json;charset=UTF-8")

                .build();
        Response response = client.newCall(request).execute();
        String gopResponseBody = response.body().string();
        FeizhenMakePdfLabelRespVO respVO = JSONObject.parseObject(gopResponseBody, FeizhenMakePdfLabelRespVO.class);
        if (respVO == null) {
            respVO = new FeizhenMakePdfLabelRespVO();
        }
        respVO.setRespBody(gopResponseBody);

        System.out.println(gopResponseBody);
        System.out.println(JSONObject.toJSONString(respVO));
        System.out.println(respVO.getData().getPdf_base64());
        System.out.println(respVO.getData().getLabel_pdf());

        // 示例Base64数据
        String base64Pdf = respVO.getData().getPdf_base64(); // 实际Base64字符串

        // 保存到文件
        try {
            // 生成文件名
            String filename = PdfBase64Saver.generatePdfFilename("invoice");
            String outputPath = "/reports/" + filename;

            // 保存文件
            PdfBase64Saver.saveBase64PdfToFile(base64Pdf, outputPath);
            System.out.println("PDF保存成功: " + outputPath);

        } catch (IllegalArgumentException e) {
            System.err.println("参数错误: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("保存失败: " + e.getMessage());
            e.printStackTrace();
        }

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
