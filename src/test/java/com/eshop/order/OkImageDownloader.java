package com.eshop.order;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class OkImageDownloader {

    private static final int MAX_RETRY = 3;
    private static final long INITIAL_BACKOFF_MS = 1000;

    @Resource
    private OkHttpClient okHttpClient;

    /**
     * 同步下载图片并自动重试
     * 警告 不适合大文件图片下载
     */
    public byte[] downloadImageWithRetry(String url) throws IOException {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        Request request = new Request.Builder().url(url).build();
        int retryCount = 0;

        while (true) {
            Call call = okHttpClient.newCall(request);
            try (Response response = call.execute()) {
                // 处理HTTP状态码
                if (!response.isSuccessful()) {
                    if (shouldRetry(response.code()) && retryCount < MAX_RETRY) {
                        retryCount = scheduleRetry(retryCount);
                        continue;
                    }
                    throw new IOException("HTTP error: " + response.code());
                }

                // 读取响应内容
                ResponseBody body = response.body();
                if (body == null) throw new IOException("Empty response body");
                return body.bytes();

            } catch (IOException e) {
                if (isRecoverable(e) && retryCount < MAX_RETRY) {
                    retryCount = scheduleRetry(retryCount);
                } else {
                    throw e; // 达到重试上限或不可恢复异常
                }
            }
        }
    }
    /**
     * 同步下载文件并自动重试
     * 警告 不适合大文件下载
     */
    public ByteArrayInputStream downloadImageIsWithRetry(String url) throws IOException {
        byte[] bytes = downloadImageWithRetry(url);
        // 3. 数据校验
        if (bytes == null || bytes.length == 0) {
            throw new IOException("下载内容为空");
        }
        return new ByteArrayInputStream(bytes);
    }

    /**
     * 获取文件资源
     */
    public ByteArrayResource getByteArrayResource(String minioUrl, String filename) throws Exception {

        try (InputStream inputStream = downloadImageIsWithRetry(minioUrl)) {
            byte[] data = IOUtils.toByteArray(inputStream);
            return new ByteArrayResource(data) {
                @Override
                public String getFilename() {
                    return filename;
                }
            };
        } catch (Exception e) {
            throw new Exception("文件不存在-minioUrl:" + minioUrl);
        }
    }

    /**
     * 执行退避重试并返回更新后的重试计数
     */
    private int scheduleRetry(int retryCount) throws IOException {
        long backoffTime = calculateBackoff(retryCount);
        log.debug("Retry {} after {}ms", retryCount + 1, backoffTime);
        try {
            TimeUnit.MILLISECONDS.sleep(backoffTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Retry interrupted", e);
        }
        return retryCount + 1;
    }

    /**
     * 指数退避计算
     */
    private long calculateBackoff(int retryCount) {
        return (long) (INITIAL_BACKOFF_MS * Math.pow(2, retryCount));
    }

    /**
     * 可恢复异常检测
     */
    private boolean isRecoverable(Throwable e) {
        return e instanceof Exception;
    }

    /**
     * 可重试状态码检测
     */
    private boolean shouldRetry(int statusCode) {
        return statusCode == 408 ||
                statusCode == 429 ||
                statusCode >= 500;
    }


//    /**
//     * 外网转内网
//     */
//    public String getMinioUrl(String minioUrl) {
//        if (StringUtils.isBlank(minioUrl)) {
//            return null;
//        }
//        String outsideUrl = minioConfig.getOutsideUrl();
//        String downloadUrlStr = minioUrl;
//        if (minioUrl.contains(outsideUrl)) {
//            downloadUrlStr = minioUrl.replace(outsideUrl, minioConfig.getUrl());
//        }
//        return downloadUrlStr;
//    }
}