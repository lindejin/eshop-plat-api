package com.eshop.api;

import com.alibaba.fastjson.JSONObject;
import com.eshop.order.OkImageDownloader;
import com.eshop.order.TikaFileUtil;
import eu.medsea.mimeutil.MimeType;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

@SpringBootTest
public class OkImageDownloaderTest {

    @Resource
    private OkImageDownloader okImageDownloader;

    @Test
    void contextLoads2() throws Exception {
        String imgUrl = "https://file.vogocm.com:9000/eshop/eshop_video/2025/5/29/vg-250529145655720A314774.mp4";
        Integer catType = 1;
        byte[] imageData = okImageDownloader.downloadImageWithRetry(imgUrl);
        String imgBase64 = Base64.encodeBase64String(imageData);
        String suffix = TikaFileUtil.getFileExtension(imageData);

        System.out.println(suffix);


//        Tika tika = new Tika();
//        String fileType = null;
//        try (InputStream is = new ByteArrayInputStream(imageData);) {
//            fileType = tika.detect(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        MimeTypes mimeTypes = MimeTypes.getDefaultMimeTypes();
//        MimeType mimeType = mimeTypes.forName(fileType);
//        String fileExtension = mimeType.getExtension();
//
//        System.out.println("File Type: " + fileType);
//        System.out.println("File Extension: " + fileExtension);

        Collection<?> objects = MimeDetector.detectMimeType(imageData);
        System.out.println("GG");

        MimeType m = objects.toArray(new MimeType[objects.size()])[0];

        System.out.println("File Type: " + m.getMediaType());
        System.out.println("File Extension: " + m.getSubType());

    }

    @Resource
    private OkHttpClient client;

    private void contextLoads3(byte[] fileBytes, JSONObject params) throws IOException {
        // 1. 模拟二进制流（实际可能是网络流/数据库流）
        InputStream binaryStream = new ByteArrayInputStream(fileBytes);

        // 2. 构造流式 RequestBody
        RequestBody streamBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/octet-stream");
            }

            @Override
            public long contentLength() {
                return -1; // 未知长度时返回 -1
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = binaryStream.read(buffer)) != -1) {
                    sink.write(buffer, 0, bytesRead);
                }
            }
        };

        // 3. 构建 Multipart 表单
        MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(
                        "file",
                        "binary-data.bin",
                        streamBody
                );
        if (params != null) {
            // 自动遍历所有字段
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                // 空值检查（重要！）
                if (value != null) {
                    requestBodyBuilder.addFormDataPart(key, value.toString());
                }
            }
        }
        MultipartBody requestBody =  requestBodyBuilder.build();
        // 3. 创建上传请求
        Request uploadRequest = new Request.Builder()
                .url("https://your-api.com/upload")
                .post(requestBody)
                .build();

        // 4. 执行上传
        try (Response response = client.newCall(uploadRequest).execute()) {
            if (!response.isSuccessful()) throw new IOException("上传失败");
            System.out.println(response.body().string());
        }
    }


}
