package com.eshop.jushuitan;

import com.eshop.util.platform.api.client.jushuitan.JushuitanSignUtil;
import okhttp3.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Erp321ApiClient {

    // 环境配置
    public static final String PROD_URL = "https://open.erp321.com/api/open/query.aspx";
    public static final String SANDBOX_URL = "https://c.jushuitan.com/api/open/query.aspx";

    private final OkHttpClient client;
    private final String partnerId;
    private final String token;
    private final boolean isSandbox;

    public Erp321ApiClient(String partnerId, String token, boolean useSandbox) {
        this.client = new OkHttpClient();
        this.partnerId = partnerId;
        this.token = token;
        this.isSandbox = useSandbox;
    }

//    /**
//     * 生成API签名 (需要根据实际签名规则实现)
//     * 通常签名规则是：将参数按字母顺序排序，拼接成字符串，加上密钥后进行MD5/SHA1等哈希计算
//     */
//    private String generateSign(Map<String, String> params) {
//        // 实际项目中需要根据API文档的具体签名算法实现
//        // 这里仅作为框架示例
//        StringBuilder sb = new StringBuilder();
//        params.keySet().stream().sorted().forEach(key -> {
//            sb.append(key).append(params.get(key));
//        });
//        // 假设有secret key
//        String secretKey = "your_secret_key";
//        sb.append(secretKey);
//
//        // 伪代码，实际需要实现哈希算法
//        return hash(sb.toString()); // 例如MD5或SHA1
//    }

    private String hash(String input) {
        // 实现具体的哈希算法
        return "signature_placeholder";
    }

    /**
     * 执行API请求
     */
    public Response executeApiRequest(String method, Map<String, Object> bizParams) throws IOException {
        // 1. 准备系统参数
        long timestamp = System.currentTimeMillis() / 1000; // 秒级时间戳

        Map<String, String> systemParams = new TreeMap<>(); // 使用TreeMap确保参数按字母顺序排序
        systemParams.put("partnerid", partnerId);
        systemParams.put("token", token);
        systemParams.put("method", method);
        systemParams.put("ts", String.valueOf(timestamp));

        // 2. 业务参数转换为JSON字符串
        // 这里简化处理，实际项目可能需要使用JSON库序列化
        String bizContent = convertToJson(bizParams);

        // 3. 合并所有参数用于签名
        Map<String, String> allParamsForSign = new HashMap<>(systemParams);
        allParamsForSign.put("biz_content", bizContent);

        // 4. 生成签名
        String sign = JushuitanSignUtil.generateSign(allParamsForSign, appSecret);

        // 5. 构建请求体
        FormBody.Builder formBuilder = new FormBody.Builder()
                .add("partnerid", partnerId)
                .add("token", token)
                .add("method", method)
                .add("ts", String.valueOf(timestamp))
                .add("sign", sign)
                .add("biz_content", bizContent);

        // 6. 创建请求
        Request request = new Request.Builder()
                .url(isSandbox ? SANDBOX_URL : PROD_URL)
                .post(formBuilder.build())
                .build();

        // 7. 执行请求
        return client.newCall(request).execute();
    }

    /**
     * 示例：获取电子面单
     */
    public Response getWaybill(int shopId, Map<String, Object> waybillRequest) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("shop_id", shopId);
        params.put("WayBillRequest", waybillRequest);

        return executeApiRequest("cainiao.waybill.ii.get", params);
    }

    /**
     * 简化的JSON转换 (实际项目应使用Gson、Jackson等库)
     */
    private String convertToJson(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!first) sb.append(",");
            sb.append("\"").append(entry.getKey()).append("\":");

            if (entry.getValue() instanceof String) {
                sb.append("\"").append(entry.getValue()).append("\"");
            } else if (entry.getValue() instanceof Map) {
                sb.append(convertToJson((Map<String, Object>) entry.getValue()));
            } else {
                sb.append(entry.getValue());
            }
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
    String appKey = "ba0c1a5cd17a4d41a1e8d48e3c867419";
    String appSecret = "3381fe28080a469ab684f4e291d4f823";
    String accessToken = "d494f28be7624f72be1df6c5fce55c87";

    /**
     * 使用示例
     */
    public static void main(String[] args) {
        // 初始化客户端
        Erp321ApiClient client = new Erp321ApiClient(
                "ba0c1a5cd17a4d41a1e8d48e3c867419",
                "d494f28be7624f72be1df6c5fce55c87",
                false // 使用沙箱环境
        );

        try {
            // 准备面单请求参数
            Map<String, Object> waybillRequest = new HashMap<>();
            waybillRequest.put("cp_code", "shunfeng");
            waybillRequest.put("sender", "123456");
            waybillRequest.put("trade_order_info_dtos", "123456");
            // 更多参数...

            // 调用API
            Response response = client.getWaybill(12345, waybillRequest);

            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println("Response: " + responseBody);

                // 解析响应 (示例)
                // JSONObject json = new JSONObject(responseBody);
                // if (json.getInt("code") == 200) {
                //     System.out.println("请求成功");
                // }
            } else {
                System.err.println("Request failed: " + response.code());
            }

            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}