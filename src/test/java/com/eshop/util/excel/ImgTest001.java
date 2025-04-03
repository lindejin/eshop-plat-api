//package com.eshop.util.excel;
//
//import org.apache.hc.client5.http.config.RequestConfig;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
//import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
//import org.springframework.http.*;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
//public class ImgTest001 {
//
//    private byte [] getBytes(String uri) {
//        // 1. 配置带连接池和超时的RestTemplate
//        RestTemplate restTemplate = createRestTemplateWithTimeout();
//
//        // 2. 设置更完整的请求头（模拟浏览器）
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//        headers.setAccept(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_PNG, MediaType.APPLICATION_OCTET_STREAM));
//        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
//
//        // 3. 带重试机制的下载（最多3次）
//        int maxRetry = 3;
//        for (int i = 0; i < maxRetry; i++) {
//            try {
//                ResponseEntity<byte[]> response = restTemplate.exchange(
//                        uri,
//                        HttpMethod.GET,
//                        new HttpEntity<>(headers),
//                        byte[].class
//                );
//
//                if (response.getStatusCode().is2xxSuccessful() && response.hasBody()) {
//                    return response.getBody();
//                }
//
//                // 非成功状态码时延迟重试
//                Thread.sleep(1000 * (i + 1));
//            } catch (ResourceAccessException e) {
//                // 超时或连接异常时重试
//                if (i == maxRetry - 1) throw new RuntimeException("下载超时，请检查网络或URL: " + uri, e);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                throw new RuntimeException("下载被中断", e);
//            } catch (Exception e) {
//                throw new RuntimeException("图片下载失败: " + e.getMessage(), e);
//            }
//        }
//        return null;
//    }
//
//    // 创建带超时和连接池的RestTemplate
//    private RestTemplate createRestTemplateWithTimeout() {
//        // 连接池配置
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//        connectionManager.setMaxTotal(100); // 最大连接数
//        connectionManager.setDefaultMaxPerRoute(20); // 每个路由最大连接数
//
//        // 超时设置（单位：毫秒）
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setConnectTimeout(5000)    // 连接超时
//                .setSocketTimeout(30000)    // 读取超时
//                .setConnectionRequestTimeout(2000) // 从池中获取连接超时
//                .build();
//
//        // 创建HttpClient
//        CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setConnectionManager(connectionManager)
//                .setDefaultRequestConfig(requestConfig)
//                .build();
//
//        // 配置RestTemplate
//        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
//    }
//}
