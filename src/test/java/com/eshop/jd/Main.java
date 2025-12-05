package com.eshop.jd;

import com.eshop.util.platform.api.client.jd.JdLogisticsSignUtil;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    private static final String HEX_CHARACTERS = "0123456789ABCDEF";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * JD调用成功过！！
     *
     * @param args
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";
        String accessToken = "ddf0a1d62d794b5d836b4d69202a695f";

        String domain = "jdcloudprint";
        String path = "/cloud/print/getTemplates";
        String method = "POST";
        String body = "[\n" +
                "  {\n" +
                "\t\"cpCode\":\"\"\n" +
                "}\n" +
                "]";
        String algorithm = "md5-salt";

        String timestamp = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        String content = String.join("", new String[]{
                appSecret,
                "access_token", accessToken,
                "app_key", appKey,
                "method", path,
                "param_json", body,
                "timestamp", timestamp,
                "v", "2.0",
                appSecret});
        String sign = JdLogisticsSignUtil.sign(algorithm, content.getBytes(UTF_8), appSecret.getBytes(UTF_8));

        String uri = baseUri + path;

        Map<String, String> query = new HashMap<>();
        query.put("LOP-DN", domain);
        query.put("app_key", appKey);
        query.put("access_token", accessToken);
        query.put("timestamp", timestamp);
        query.put("v", "2.0");
        query.put("sign", sign);
        query.put("algorithm", algorithm);
        URL url = new URL(uri + "?" + httpBuildQuery(query));

        int offset = OffsetTime.now().getOffset().getTotalSeconds() / 3600;
        Map<String, String> headers = new HashMap<>();
        headers.put("lop-tz", String.valueOf(offset));
        headers.put("User-Agent", "lop-http/java");

//        log.info("京东物流请求参数 apiUrl: {} ,paramJson:{}", apiUrl, paramJson);

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(body.getBytes(UTF_8));
            }

            try (InputStream inputStream = connection.getInputStream()) {
                System.out.println(new String(readAllBytes(inputStream), UTF_8));
            } catch (IOException e) {
                try (InputStream errorStream = connection.getErrorStream()) {
                    System.out.println(new String(readAllBytes(errorStream), UTF_8));
                }
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String sign(String algorithm, byte[] data, byte[] secret) throws GeneralSecurityException {
        if (Objects.equals(algorithm, "md5-salt")) {
            return bytesToHex(MessageDigest.getInstance("md5").digest(data));
        } else if (Objects.equals(algorithm, "HMacMD5")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA1")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA256")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA512")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        }
        throw new GeneralSecurityException("Algorithm " + algorithm + " not supported yet");
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(HEX_CHARACTERS.charAt((b >>> 4) & 0x0F));
            stringBuilder.append(HEX_CHARACTERS.charAt(b & 0x0F));
        }
        return stringBuilder.toString();
    }

    public static String httpBuildQuery(Map<String, String> query) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (!first) {
                stringBuilder.append("&");
            } else {
                first = false;
            }
            stringBuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), UTF_8.name()));
        }
        return stringBuilder.toString();
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, n);
        }
        return outputStream.toByteArray();
    }
}

