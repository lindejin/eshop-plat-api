package com.eshop.download;

import com.eshop.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class Test002 {
    public static void main(String[] args) {
        String downloadUrl = "https://open-fs-va.tiktokshop.com/wsos_v2/oec_fulfillment_doc_tts/object/wsos67d126cbbad08b05?expire=1741846609&skipCookie=true&timeStamp=1741760209&sign=fb5bf55b290c0672d24bbac73857d3502815db4219bbccf4971dd507e3d8080a"; // 下载URL
        downloadUrl = "https://open-fs-va.tiktokshop.com/wsos_v2/oec_fulfillment_doc_tts/object/wsos67d1381947994b01?expire=1741851034&skipCookie=true&timeStamp=1741764634&sign=8a99c95ef0e1cd511c89e8f2c032bfbe795265f81ed8a25e4a26cc99ebe37aed";

//        downloadUrl = "https://us.vogocmerp.com/tiktokshop/wsos_v2/oec_fulfillment_doc_tts/object/wsos67d1381947994b01?expire=1741851034&skipCookie=true&timeStamp=1741764634&sign=8a99c95ef0e1cd511c89e8f2c032bfbe795265f81ed8a25e4a26cc99ebe37aed";
        String modifiedUrl = downloadUrl.replace("open-fs-va.tiktokshop.com", "us.vogocmerp.com/tiktokshop");
        byte[] content = null;

        try {
            // 尝试使用原始URL下载
            ResponseEntity<byte[]> result = httpExchange(downloadUrl);
            if (result == null) {
                throw new RuntimeException("pdf文件下载下载出错！");
            }
            content = result.getBody();
        } catch (RuntimeException e) {
            log.error("PDF文件下载失败,原始地址！" + ExceptionUtils.exToString(e));
            // 如果原始URL下载失败，尝试使用修改后的URL下载
            try {
                ResponseEntity<byte[]> result = httpExchange(modifiedUrl);
                if (result == null) {
                    throw new RuntimeException("pdf文件下载下载出错！");
                }
                content = result.getBody();
            } catch (RuntimeException ex) {
                // 如果两个地址都下载失败，抛出异常
                log.error("PDF文件下载失败,代理地址！" + ExceptionUtils.exToString(e));
                throw new RuntimeException("PDF文件下载失败,代理地址！", ex);
            }
        }

        // 保存文件到本地
        try {
            // 创建文件保存路径
            String saveDir = "downloads";
            File dir = new File(saveDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 生成文件名
            String fileName = "download_" + System.currentTimeMillis() + ".pdf";
            String filePath = saveDir + File.separator + fileName;

            // 写入文件
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(content);
            fos.close();

            System.out.println("文件已保存至: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("文件保存失败: " + e.getMessage());
        }
    }

    /**
     * 尝试重新下载
     */
    private static ResponseEntity<byte[]> httpExchange(String uri) {
        RestTemplate restTemplate = new RestTemplate();
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
