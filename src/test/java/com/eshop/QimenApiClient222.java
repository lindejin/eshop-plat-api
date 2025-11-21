package com.eshop;

import okhttp3.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QimenApiClient222 {

    //数帝奇门应用ID：24977747：
    //target_app_key=23060081
    //customer_id = 10969016
    //路由目标URL
    //https://openerp321.com/api/qimen/jushuitan/api.aspx?co_id=10969016&data all=true
    //目标Appkey：23060081
    //第三方授权url链接示例：
    public void setup() {
        String appkey = "23060081"; // 奇门的appkey
        String secret = ""; // 奇门的密钥
        String session = ""; // 非必填参数 可以不传

        Map<String, String> param = new HashMap<>();
        // 业务参数传参
        param.put("page_index", "1");
        param.put("page_size", "10");
        param.put("o_ids", "5459022");

        try {
            String result = post("http://a1q40taq0j.api.taobao.com/router/qm",
                    appkey, secret, "jushuitan.order.list.query", session, param);
            System.out.println("返回结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果：{"response":{"flag":"failure","code":25,"message":"Invalid signature","request_id":"15qzd9btbeym5"}}
    }

    /**
     * 给TOP请求签名 API v2.0
     */
    private static String createSign(Map<String, String> parameters, String secret) {
        parameters.remove("sign");

        // 对参数按key进行排序
        Map<String, String> sortedParams = new TreeMap<>(parameters);

        StringBuilder query = new StringBuilder(secret);
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
                query.append(key).append(value);
            }
        }
        query.append(secret);

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(query.toString().getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    result.append("0");
                }
                result.append(hex);
            }
            return result.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /**
     * 组装普通文本请求参数
     */
    private static String buildPostData(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder postData = new StringBuilder();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();

            if (name != null && !name.isEmpty() && value != null && !value.isEmpty()) {
                if (hasParam) {
                    postData.append("&");
                }
                postData.append(name)
                        .append("=")
                        .append(URLEncoder.encode(value, String.valueOf(StandardCharsets.UTF_8)));
                hasParam = true;
            }
        }
        return postData.toString();
    }

    /**
     * TOP API POST 请求
     */
    public static String post(String url, String appkey, String appSecret,
                              String method, String session, Map<String, String> param) throws IOException {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // 添加API系统参数
        param.put("method", method);
        param.put("app_key", appkey);
        param.put("session", session != null ? session : ""); // 非必填
        param.put("timestamp", timestamp);
        param.put("format", "json");
        param.put("v", "2.0");
        param.put("sign_method", "md5");

        //淘宝例子没有、 聚水潭有的 参数
        param.put("target_app_key", "23060081"); // 申请奇门自定义场景的target_app_key
        param.put("customer_id", ""); // 申请奇门自定义场景的customer_id



        param.put("sign", createSign(new HashMap<>(param), appSecret));

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(300, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(300, java.util.concurrent.TimeUnit.SECONDS)
                .build();

        String postData = buildPostData(param);

        RequestBody body = RequestBody.create(
                postData,
                MediaType.parse("application/x-www-form-urlencoded;charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code: " + response);
            }

            String result = response.body().string();
            // 移除控制字符（类似C#中的正则表达式处理）
            return result.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        }
    }

    // 使用示例
    public static void main(String[] args) {
        QimenApiClient222 client = new QimenApiClient222();
        client.setup();
    }

    {
        String appkey = "";
        String appSecret = "";
        String format = "JSON";
        /*
         * 这里的URL可以参考测试工具上的链接，域+后缀
         * 后缀如果测试环境地址则为/router/qmtest，如果是正式地址则为/router/qm
         */
        String url = "https://j6778fdz70.api.taobao.com/router/qmtest";
        String apiName = "";
        String targetAppkey = "";


        DefaultQimenCloudClient client = new DefaultQimenCloudClient(url, appkey, appSecret, format);


        QimenCloudRequest request = new QimenCloudRequest();
        request.setApiMethodName(apiName);
        //注意！ 千万不能少了这一步
        request.setTargetAppKey(targetAppkey);
        //添加参数
        //request.addQueryParam(key, value);
        QimenCloudResponse response = null;
        try {
            response = client.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}