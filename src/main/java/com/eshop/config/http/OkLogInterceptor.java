package com.eshop.config.http;

import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;
import org.beetl.core.util.Log;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

public class OkLogInterceptor implements Interceptor {

    private static final String TAG = OkLogInterceptor.class.getSimpleName();

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Charset UTF8 = StandardCharsets.UTF_8;

        // 打印请求报文
        Request request = chain.request();
        RequestBody requestBody = request.body();
        String reqBody = null;
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            reqBody = buffer.readString(charset);
        }
        Log.d(TAG, String.format("发送请求\nmethod：%s\nurl：%s\nheaders: %s\nbody：%s",
                request.method(), request.url(), request.headers(), reqBody));

        // 打印返回报文
        // 先执行请求，才能够获取报文
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        String respBody = null;
        if (responseBody != null) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    e.printStackTrace();
                }
            }
            respBody = buffer.clone().readString(charset);
        }
        Log.d(TAG, String.format("收到响应\n%s %s\n请求url：%s\n请求body：%s\n响应body：%s",
                response.code(), response.message(), response.request().url(), reqBody, respBody));
        return response;
    }
}
