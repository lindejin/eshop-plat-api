package com.eshop.config;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.core.DefaultHttpLogWriter;
import org.zalando.logbook.core.DefaultSink;
import org.zalando.logbook.json.JsonHttpLogFormatter;
import org.zalando.logbook.okhttp.LogbookInterceptor;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpConfig {
    private static final Logger logger = LoggerFactory.getLogger(OkHttpConfig.class);

    // 连接池参数
    private static final int MAX_IDLE_CONNECTIONS = 200;
    private static final long KEEP_ALIVE_DURATION = 30L;

    // 超时参数
    private static final int CONNECT_TIMEOUT = 30;
    private static final int READ_TIMEOUT = 60;
    private static final int WRITE_TIMEOUT = 60;

    @Bean
    public OkHttpClient okHttpClient(Logbook logbook) {
        return new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.SECONDS))
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .sslSocketFactory(sslSocketFactory(), x509TrustManager())
                .hostnameVerifier((hostname, session) -> true)
                .retryOnConnectionFailure(true)
                .addInterceptor(new LogbookInterceptor(logbook))  // 关键拦截器
                .build();
    }

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .sink(new DefaultSink(new JsonHttpLogFormatter(), new DefaultHttpLogWriter()))
                .bodyFilter(new HtmlToTextFilter()) // 新增HTML文本提取过滤器
                .build();
    }

    // SSL信任所有证书
    private SSLSocketFactory sslSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{x509TrustManager()}, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private X509TrustManager x509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {}
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {}
            @Override
            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
        };
    }

    // 日志拦截器
    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.nanoTime();
            logger.info("Sending request: {} {}", request.method(), request.url());
            Response response = chain.proceed(request);
            long duration = (System.nanoTime() - startTime) / 1_000_000;
            logger.info("Received response in {}ms: {}", duration, response.code());
            return response;
        }
    }
}
