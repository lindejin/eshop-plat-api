package com.eshop.dewu;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DewuAuthServlet {
    //查看App secret
    //
    //App Key：75881da49c8b41caa2448c3fef771595
    //App Secret：5f44031fef3f41119f2324ac3fbeb9aaaf6a9d9fb4024455809bdaee3e30804c

    // 得物授权页面基础URL
    private static final String AUTH_URL = "https://open.dewu.com/#/authorize";

    // 你的应用配置（应从配置文件读取，此处为示例）
    private static final String CLIENT_ID = "75881da49c8b41caa2448c3fef771595"; // 替换为你的真实client_id
    private static final String REDIRECT_URI = "https://open-dev-boss-api.worthfind.com/auth/authorize/tiktok/authcallback"; // 必须与开放平台注册的回调地址完全一致
    private static final String SCOPE = "all"; // 固定值

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1. 生成防CSRF攻击的随机state（生产环境应存储到session）
        String state = "random_string_" + System.currentTimeMillis();

        // 2. 构建授权请求URL（关键步骤）
        DewuAuthServlet dewuAuthServlet = new DewuAuthServlet();
        String authUrl = dewuAuthServlet.buildAuthUrl(state);
        System.out.println(authUrl);

        //1764752928535
        //1764752737832
        System.out.println(System.currentTimeMillis());
    }


    /**
     * 构建授权请求URL
     * 注意：redirect_uri必须进行双重编码（先URL编码再整体作为参数值）
     */
    public String buildAuthUrl(String state) throws UnsupportedEncodingException {
        // 对redirect_uri进行严格编码（符合RFC 3986标准）
        String encodedRedirectUri = URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8.name())
                .replace("+", "%20")  // 将+替换为%20（标准空格编码）
                .replace("*", "%2A")
                .replace("%7E", "~");

        // 构建完整授权URL
        StringBuilder urlBuilder = new StringBuilder(AUTH_URL);
        urlBuilder.append("?response_type=code")
                .append("&client_id=").append(CLIENT_ID)
                .append("&redirect_uri=").append(encodedRedirectUri)
                .append("&scope=").append(SCOPE);

        // 添加可选参数（按需启用）
        if (state != null && !state.isEmpty()) {
            urlBuilder.append("&state=").append(URLEncoder.encode(state, StandardCharsets.UTF_8.name()));
        }
        // urlBuilder.append("&view=mobile"); // 如需手机端页面取消注释

        return urlBuilder.toString();
    }
}