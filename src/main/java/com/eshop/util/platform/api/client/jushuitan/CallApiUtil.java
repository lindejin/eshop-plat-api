//package com.eshop.util.platform.api.client.jushuitan;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Map;
//import java.util.Set;
//import java.util.zip.GZIPInputStream;
//
///**
// * @program: eshop-plat-api
// * @description:
// * @author: lindz
// * @create: 2026-01-07 10:39
// **/
//public class CallApiUtil {
//
//    private static final String SIGN_METHOD_MD5 = "md5";
//    private static final String SIGN_METHOD_HMAC = "hmac";
//    private static final String CHARSET_UTF8 = "utf-8";
//    private static final String CONTENT_ENCODING_GZIP = "gzip";
//
//    public static String callApi(URL url, Map<String, String> params) throws IOException {
//        String query = buildQuery(params, CHARSET_UTF8);
//        byte[] content = {};
//        if (query != null) {
//            content = query.getBytes(CHARSET_UTF8);
//        }
//
//        HttpURLConnection conn = null;
//        OutputStream out = null;
//        String rsp = null;
//        try {
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            conn.setRequestProperty("Host", url.getHost());
//            conn.setRequestProperty("Accept", "text/xml,text/javascript");
//            conn.setRequestProperty("User-Agent", "top-sdk-java");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET_UTF8);
//            out = conn.getOutputStream();
//            out.write(content);
//            rsp = getResponseAsString(conn);
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
//
//        return rsp;
//    }
//
//    private static String buildQuery(Map<String, String> params, String charset) throws IOException {
//        if (params == null || params.isEmpty()) {
//            return null;
//        }
//
//        StringBuilder query = new StringBuilder();
//        Set<Map.Entry<String, String>> entries = params.entrySet();
//        boolean hasParam = false;
//
//        for (Map.Entry<String, String> entry : entries) {
//            String name = entry.getKey();
//            String value = entry.getValue();
//            // 忽略参数名或参数值为空的参数
//            if (isNotEmpty(name) && isNotEmpty(value)) {
//                if (hasParam) {
//                    query.append("&");
//                } else {
//                    hasParam = true;
//                }
//
//                query.append(name).append("=").append(URLEncoder.encode(value, charset));
//            }
//        }
//
//        return query.toString();
//    }
//
//    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
//        String charset = getResponseCharset(conn.getContentType());
//        if (conn.getResponseCode() < 400) {
//            String contentEncoding = conn.getContentEncoding();
//            if (CONTENT_ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
//                return getStreamAsString(new GZIPInputStream(conn.getInputStream()), charset);
//            } else {
//                return getStreamAsString(conn.getInputStream(), charset);
//            }
//        } else {// Client Error 4xx and Server Error 5xx
//            throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage());
//        }
//    }
//
//    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
//        try {
//            Reader reader = new InputStreamReader(stream, charset);
//            StringBuilder response = new StringBuilder();
//
//            final char[] buff = new char[1024];
//            int read = 0;
//            while ((read = reader.read(buff)) > 0) {
//                response.append(buff, 0, read);
//            }
//
//            return response.toString();
//        } finally {
//            if (stream != null) {
//                stream.close();
//            }
//        }
//    }
//
//    private static String getResponseCharset(String ctype) {
//        String charset = CHARSET_UTF8;
//
//        if (isNotEmpty(ctype)) {
//            String[] params = ctype.split(";");
//            for (String param : params) {
//                param = param.trim();
//                if (param.startsWith("charset")) {
//                    String[] pair = param.split("=", 2);
//                    if (pair.length == 2) {
//                        if (isNotEmpty(pair[1])) {
//                            charset = pair[1].trim();
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//
//        return charset;
//    }
//
//    private static boolean isNotEmpty(String value) {
//        int strLen;
//        if (value == null || (strLen = value.length()) == 0) {
//            return false;
//        }
//        for (int i = 0; i < strLen; i++) {
//            if ((Character.isWhitespace(value.charAt(i)) == false)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
