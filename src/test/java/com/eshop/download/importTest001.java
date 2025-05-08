package com.eshop.download;

import lombok.extern.slf4j.Slf4j;
import net.sf.jmimemagic.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.tika.Tika;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;

@Slf4j
public class importTest001 {
    public static void main(String[] args) throws MagicMatchNotFoundException, MagicException, MagicParseException {
        String downloadUrl = "http://xmxc.kingtrans.net/upload/printPdf/202505081355334564118.pdf"; // 下载URL
        ResponseEntity<byte[]> result = httpExchange(downloadUrl);
        if (result == null) {
            throw new RuntimeException("pdf文件下载下载出错！");
        }
        byte[] content = result.getBody();

        MagicMatch match = Magic.getMagicMatch(content);
        System.out.println(match.getMimeType());
        System.out.println(TikaFileUtil.getFileExtension(content));
        System.out.println(TikaFileUtil.getMimeType(content));;
//        // 保存文件到本地
//        try {
//            // 创建文件保存路径
//            String saveDir = "downloads";
//            File dir = new File(saveDir);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            // 生成文件名
//            String fileName = "download_" + System.currentTimeMillis() + ".pdf";
//            String filePath = saveDir + File.separator + fileName;
//
//            // 写入文件
//            FileOutputStream fos = new FileOutputStream(filePath);
//            fos.write(content);
//            fos.close();
//
//            System.out.println("文件已保存至: " + filePath);
//        } catch (IOException e) {
//            throw new RuntimeException("文件保存失败: " + e.getMessage());
//        }
    }

    /**
     * 尝试重新下载
     */
    private static ResponseEntity<byte[]> httpExchange(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        // 设置连接和读取超时
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000);  // 连接超时10秒
        factory.setReadTimeout(10000);     // 读取超时10秒

        // 配置SSL证书信任
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }}, new SecureRandom());

            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);
            requestFactory.setConnectTimeout(10000);
            requestFactory.setReadTimeout(10000);
            restTemplate.setRequestFactory(requestFactory);
        } catch (Exception e) {
            throw new RuntimeException("SSL配置失败: " + e.getMessage());
        }

        ResponseEntity<byte[]> result = null;
        int maxRetries = 3;
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_PDF, MediaType.APPLICATION_OCTET_STREAM));
                headers.set("User-Agent", "Mozilla/5.0");
                HttpEntity<String> entity = new HttpEntity<>(headers);
                
                result = restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);
                byte[] content = result.getBody();
                if (content == null) {
                    throw new RuntimeException("下载内容为空");
                }

                Tika tika = new Tika();
                String mimeType = tika.detect(content);
                if (!"application/pdf".equals(mimeType)) {
                    throw new RuntimeException("pdf文件下载下载出错！");
                }
                
                // 下载成功，跳出重试循环
                break;
                
            } catch (ResourceAccessException e) {
                retryCount++;
                if (retryCount >= maxRetries) {
                    throw new RuntimeException("文件下载失败，网络连接异常: " + e.getMessage());
                }
                System.out.println("连接失败，正在进行第" + retryCount + "次重试...");
                try {
                    Thread.sleep(1000 * retryCount); // 重试间隔递增
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("重试过程被中断");
                }
            } catch (Exception e) {
                // 对于其他类型的异常，尝试不带PDF header的下载
                try {
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("User-Agent", "Mozilla/5.0");
                    HttpEntity<String> entity = new HttpEntity<>(headers);
                    result = restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);
                    byte[] content = result.getBody();
                    if (content == null) {
                        throw new RuntimeException("下载内容为空");
                    }

                    Tika tika = new Tika();
                    String mimeType = tika.detect(content);
                    if (!"application/pdf".equals(mimeType) && !"image/png".equals(mimeType)) {
                        throw new RuntimeException("面单文件下载下载出错！");
                    }
                    break;
                } catch (Exception ex) {
                    throw new RuntimeException("文件下载失败: " + ex.getMessage());
                }
            }
        }
        return result;
    }
}