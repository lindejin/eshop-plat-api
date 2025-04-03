package com.eshop.util.minio;


import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.util.ObjectUtil;
import com.eshop.util.minio.service.MinioSysFileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.util.Timeout;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;

/**
 * 文件请求处理
 *
 * @author rch
 */
@Slf4j
@Component
public class MinioFileUtils {
    @Resource
    private MinioSysFileServiceImpl sysFileService;

    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadMultipartFile(MultipartFile file, Integer filePathType, String contentType) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            String url = sysFileService.uploadMultipartFile(file, filePathType, contentType);
            if (ObjectUtil.isEmpty(url)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    /**
     * 文件上传请求-带缩略图
     */
    public RetCode<SysFile> uploadMultipartFileThu(MultipartFile file, Integer filePathType, String contentType, int width, int height, String fileType, String watermarkText) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(file, filePathType, contentType, width, height, fileType, watermarkText);
            if (ObjectUtil.isEmpty(imgInfo)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
            sysFile.setUrl(imgInfo.getUrl());

            sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
            sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    /**
     * 文件上传请求
     */
    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFile(File file, Integer filePathType, String contentType) {
        FileInputStream fileInputStreamType = null;
        FileInputStream fileInputStreamFile = null;
        try {
            fileInputStreamType = new FileInputStream(file);
            fileInputStreamFile = new FileInputStream(file);
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(file)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }
            Tika tika = new Tika();
            contentType = ObjectUtil.isEmpty(contentType) ? tika.detect(fileInputStreamType) : contentType;
            MultipartFile cMultiFile = new MyMockMultipartFile("file", file.getName(), contentType, fileInputStreamFile);
            String url = sysFileService.uploadMultipartFile(cMultiFile, filePathType, contentType);
            if (ObjectUtil.isEmpty(url)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        } finally {
            IOUtils.closeQuietly(fileInputStreamType);
            IOUtils.closeQuietly(fileInputStreamFile);
        }
    }

    /**
     * 文件上传请求-带缩略图
     */
    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFileThu(File file, Integer filePathType, String contentType, int width, int height, String fileType, String watermarkText) {
        FileInputStream fileInputStreamType = null;
        FileInputStream fileInputStreamFile = null;
        try {
            fileInputStreamType = new FileInputStream(file);
            fileInputStreamFile = new FileInputStream(file);
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(file)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }
            Tika tika = new Tika();
            contentType = ObjectUtil.isEmpty(contentType) ? tika.detect(fileInputStreamType) : contentType;
            MultipartFile cMultiFile = new MyMockMultipartFile("file", file.getName(), contentType, fileInputStreamFile);
            ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(cMultiFile, filePathType, contentType, width, height, fileType, watermarkText);
            if (ObjectUtil.isEmpty(imgInfo)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
            sysFile.setUrl(imgInfo.getUrl());

            sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
            sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        } finally {
            IOUtils.closeQuietly(fileInputStreamType);
            IOUtils.closeQuietly(fileInputStreamFile);
        }
    }

    /**
     * 上传BufferedImage类型文件
     *
     * @param fileName
     * @param bufferedImage
     * @param filePathType
     * @return
     */
    public RetCode<SysFile> uploadBufferedImageFile(String fileName, BufferedImage bufferedImage, Integer filePathType) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(bufferedImage)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            String imgType = fileName.substring(fileName.lastIndexOf(".") + 1);
            ImageIO.write(bufferedImage, imgType, os);  // Choose appropriate format
            byte[] buffer = os.toByteArray();
            int fileSize = buffer.length;
            InputStream inputStream = new ByteArrayInputStream(buffer);
            try {
                String url = sysFileService.uploadMultipartFile(inputStream, filePathType, Files.probeContentType(Paths.get(fileName)), fileName, Long.valueOf(fileSize));
                if (ObjectUtil.isEmpty(url)) {
                    log.error("上传文件异常:文件不存在或者文件路径不存在！");
                    return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
                }

                SysFile sysFile = new SysFile();
                sysFile.setName(FileUtils.getName(url));
                sysFile.setUrl(url);

                return RetCode.ok("文件上传成功！", sysFile);
            } catch (Exception e) {
                log.error("上传文件异常", e);
                return RetCode.err("文件上传失败！");
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 上传BufferedImage类型文件
     *
     * @param fileName
     * @param bufferedImage
     * @param filePathType
     * @return
     */
    public RetCode<SysFile> uploadBufferedImageFile(String fileName, BufferedImage bufferedImage, Integer filePathType, String fileTypeSuffix) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(bufferedImage)
                    || ObjectUtil.isEmpty(fileTypeSuffix)
                    || ObjectUtil.isEmpty(fileName)
                    || ObjectUtil.isEmpty(filePathType)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 传入的图片后缀应该检测类型是否是图片类型，这里省略不做了先，调用接口要保证类型正确
//            String imgType = fileName.substring(fileName.lastIndexOf("." ) + 1);
            ImageIO.write(bufferedImage, fileTypeSuffix, os);  // Choose appropriate format
            byte[] buffer = os.toByteArray();
            int fileSize = buffer.length;
            InputStream inputStream = new ByteArrayInputStream(buffer);
            try {
                fileName = MyStrUtil.replaceImageSuffix(fileName, fileTypeSuffix);
                String url = sysFileService.uploadMultipartFile(inputStream, filePathType, Files.probeContentType(Paths.get(fileName)), fileName, Long.valueOf(fileSize));
                if (ObjectUtil.isEmpty(url)) {
                    log.error("上传文件异常:文件不存在或者文件路径不存在！");
                    return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
                }

                SysFile sysFile = new SysFile();
                sysFile.setName(FileUtils.getName(url));
                sysFile.setUrl(url);

                return RetCode.ok("文件上传成功！", sysFile);
            } catch (Exception e) {
                log.error("上传文件异常", e);
                return RetCode.err("文件上传失败！");
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 上传BufferedImage类型文件 - 带缩略图
     *
     * @param fileName
     * @param bufferedImage
     * @param filePathType
     * @return
     */
    public RetCode<SysFile> uploadBufferedImageFileThu(String fileName, BufferedImage bufferedImage, Integer filePathType, int width, int height, String fileType, String watermarkText) throws IOException {
        // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
        // 上传并返回访问地址
        if (ObjectUtil.isEmpty(bufferedImage)) {
            log.error("上传文件异常:请求参数文件不存在！");
            return RetCode.err("上传文件异常:请求参数文件不存在！");
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String imgType = fileName.substring(fileName.lastIndexOf(".") + 1);
        ImageIO.write(bufferedImage, imgType, os);  // Choose appropriate format
        byte[] buffer = os.toByteArray();
        int fileSize = buffer.length;

        try (InputStream inputStream = new ByteArrayInputStream(buffer)) {
            ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(inputStream, filePathType, Files.probeContentType(Paths.get(fileName)), fileName, Long.valueOf(fileSize), width, height, fileType, watermarkText);
            if (ObjectUtil.isEmpty(imgInfo)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
            sysFile.setUrl(imgInfo.getUrl());

            sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
            sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFile(String fileName, InputStream inputStream, Integer filePathType, String contentType) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            int contentLength = outputStream.size();

            String url = sysFileService.uploadMultipartFile(inputStream, filePathType, contentType, fileName, Long.valueOf(contentLength));
            if (ObjectUtil.isEmpty(url)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFile(InputStream inputStream, String fileName, Integer filePathType, String contentType, Long contentLength) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }
            String url = sysFileService.uploadMultipartFile(inputStream, filePathType, contentType, fileName, contentLength);
            if (ObjectUtil.isEmpty(url)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 文件上传请求-带缩略图
     */
    public RetCode<SysFile> uploadFileThu(String fileName, InputStream inputStream, Integer filePathType, String contentType, int width, int height, String fileType, String watermarkText) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            int contentLength = outputStream.size();

            ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(inputStream, filePathType, contentType, fileName, Long.valueOf(contentLength), width, height, fileType, watermarkText);
            if (ObjectUtil.isEmpty(imgInfo)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
            sysFile.setUrl(imgInfo.getUrl());

            sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
            sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }


//    /**
//     * 文件上传请求
//     */
//    public RetCode<SysFile> uploadFile(String urlStr, String fileName, Integer filePathType){
//        try{
//            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
//            // 上传并返回访问地址
//            if (ObjectUtil.isEmpty(urlStr)) {
//                log.error("上传文件异常:请求参数文件不存在！");
//                return RetCode.err("上传文件异常:请求参数文件不存在！");
//            }
//
//            ResponseEntity<byte[]> rtByte = downloadImgRestTemplateByUrl(urlStr);
//            String contentType = rtByte.getHeaders().getContentType().toString();
//            // 从URLConnection获取InputStream
//            InputStream inputStream = new ByteArrayInputStream(rtByte.getBody());
//
//            long contentLength = rtByte.getHeaders().getContentLength();
//
//            if (contentLength == -1) {
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//                contentLength = outputStream.size();
//            }
//
//            String result = sysFileService.uploadMultipartFile(inputStream, 1, contentType, fileName, Long.valueOf(contentLength));
//            if (ObjectUtil.isEmpty(result)) {
//                log.error("上传文件异常:文件不存在或者文件路径不存在！");
//                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
//            }
//
//            SysFile sysFile = new SysFile();
//            sysFile.setName(FileUtils.getName(result));
//            sysFile.setUrl(result);
//
//            return RetCode.ok("文件上传成功！", sysFile);
//        } catch (SocketTimeoutException e) {
//            log.error("外链-URL：" + urlStr + " -连接超时", e.getMessage());
//            return RetCode.err("文件上传失败！连接超时!");
//        } catch (Exception e){
//            e.printStackTrace();
//            log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
//            return RetCode.err("文件上传失败！");
//        }
//    }


    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFile(String urlStr, String fileName, Integer filePathType) throws Exception {
//        try{
        // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
        // 上传并返回访问地址
        if (ObjectUtil.isEmpty(urlStr)) {
            log.error("上传文件异常:请求参数文件不存在！");
//                return RetCode.err("上传文件异常:请求参数文件不存在！");
            throw new Exception("上传文件异常:请求参数文件不存在！");
        }

        ResponseEntity<byte[]> rtByte = downloadImgRestTemplateByUrl(urlStr);
        String contentType = rtByte.getHeaders().getContentType().toString();
        // 从URLConnection获取InputStream
        try (InputStream inputStream = new ByteArrayInputStream(rtByte.getBody())) {
            try (ByteArrayOutputStream baos = copyInputStream(inputStream)) {
                // 复制出两个新的输入流（此时有一个InputStream的到两个相同的inputStream，如果需要多个还可以继续复制）
                try (InputStream saveStream = new ByteArrayInputStream(baos.toByteArray());
                     InputStream sizeStream = new ByteArrayInputStream(baos.toByteArray());) {

                    long contentLength = getContentLength(sizeStream);
                    String result = sysFileService.uploadMultipartFile(saveStream, 1, contentType, fileName, Long.valueOf(contentLength));
                    if (ObjectUtil.isEmpty(result)) {
                        log.error("上传文件异常:文件不存在或者文件路径不存在！");
                        throw new Exception("上传文件异常:文件不存在或者文件路径不存在！");
                    }
                    SysFile sysFile = new SysFile();
                    sysFile.setName(FileUtils.getName(result));
                    sysFile.setUrl(result);

                    return RetCode.ok("文件上传成功！", sysFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("上传文件异常:" + e);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("上传文件异常:" + e);
            }
        } catch (Exception e) {
            log.error("上传文件异常: " + e.getMessage(), e);
            throw new Exception("上传文件失败！");
        }
    }

    /**
     * 文件上传请求-加水印
     */
    public RetCode<SysFile> uploadAddWatermarkFile(String urlStr, String fileName, String watermarkStr) {
        // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
        // 上传并返回访问地址
        if (ObjectUtil.isEmpty(urlStr)) {
            log.error("上传文件异常:请求参数文件不存在！");
            return RetCode.err("上传文件异常:请求参数文件不存在！");
        }

        ResponseEntity<byte[]> rtByte = downloadImgRestTemplateByUrl(urlStr);
        String contentType = rtByte.getHeaders().getContentType().toString();
        // 从URLConnection获取InputStream
        try (InputStream inputStream = new ByteArrayInputStream(rtByte.getBody())) {
            try (ByteArrayOutputStream baos = copyInputStream(inputStream)) {
                // 复制出两个新的输入流（此时有一个InputStream的到两个相同的inputStream，如果需要多个还可以继续复制）
                try (InputStream saveStream = new ByteArrayInputStream(baos.toByteArray());
                     InputStream sizeStream = new ByteArrayInputStream(baos.toByteArray());) {
                    long contentLength = getContentLength(sizeStream);
                    String result = sysFileService.uploadMultipartFile(saveStream, 1, contentType, fileName, Long.valueOf(contentLength), watermarkStr);
                    if (ObjectUtil.isEmpty(result)) {
                        log.error("上传文件异常:文件不存在或者文件路径不存在！");
                        return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
                    }

                    SysFile sysFile = new SysFile();
                    sysFile.setName(FileUtils.getName(result));
                    sysFile.setUrl(result);

                    return RetCode.ok("文件上传成功！", sysFile);
                } catch (Exception exception) {
                    log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                    return RetCode.err("文件上传失败！");
                }
            } catch (Exception exception) {
                log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                return RetCode.err("文件上传失败！");
            }
        } catch (SocketTimeoutException e) {
            log.error("外链-URL：" + urlStr + " -连接超时", e.getMessage());
            return RetCode.err("文件上传失败！连接超时!");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 文件上传请求-带缩略图
     */
    public RetCode<SysFile> uploadFileThu(String urlStr, String fileName, Integer filePathType, int width, int height, String fileType, String watermarkText) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(urlStr)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            // 创建URL对象
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.connect();
            // 获取文件的MIME类型
            String contentType = connection.getContentType();
            // 从URLConnection获取InputStream
            try (InputStream inputStream = connection.getInputStream()) {
                try (ByteArrayOutputStream baos = copyInputStream(inputStream)) {
                    // 复制出两个新的输入流（此时有一个InputStream的到两个相同的inputStream，如果需要多个还可以继续复制）
                    try (InputStream saveStream = new ByteArrayInputStream(baos.toByteArray());
                         InputStream sizeStream = new ByteArrayInputStream(baos.toByteArray());) {
                        long contentLength = getContentLength(sizeStream);
                        ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(saveStream, 1, contentType, fileName, Long.valueOf(contentLength), width, height, fileType, watermarkText);
                        if (ObjectUtil.isEmpty(imgInfo)) {
                            log.error("上传文件异常:文件不存在或者文件路径不存在！");
                            return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
                        }

                        SysFile sysFile = new SysFile();
                        sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
                        sysFile.setUrl(imgInfo.getUrl());

                        sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
                        sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

                        return RetCode.ok("文件上传成功！", sysFile);
                    } catch (Exception exception) {
                        log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                        return RetCode.err("文件上传失败！");
                    }
                } catch (Exception exception) {
                    log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                    return RetCode.err("文件上传失败！");
                }
            } catch (SocketTimeoutException e) {
                log.error("外链-URL：" + urlStr + " -连接超时", e.getMessage());
                return RetCode.err("文件上传失败！连接超时!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
                return RetCode.err("文件上传失败！");
            }
        } catch (Exception e) {
            log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 文件上传请求
     */
    public RetCode<SysFile> uploadFile(String fileName, byte[] fileByte, Integer filePathType, String contentType) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(fileByte)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            Tika tika = new Tika();
            contentType = ObjectUtil.isEmpty(contentType) ? tika.detect(fileByte) : contentType;
            MultipartFile cMultiFile = new MyMockMultipartFile("file", fileName, contentType, fileByte);
            String url = sysFileService.uploadMultipartFile(cMultiFile, filePathType, contentType);
            if (ObjectUtil.isEmpty(url)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);
            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 文件上传请求-带缩略图
     */
    public RetCode<SysFile> uploadFileThu(String fileName, byte[] fileByte, Integer filePathType, String contentType, int width, int height, String fileType, String watermarkText) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(fileByte)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            Tika tika = new Tika();
            contentType = ObjectUtil.isEmpty(contentType) ? tika.detect(fileByte) : contentType;
            MultipartFile cMultiFile = new MyMockMultipartFile("file", fileName, contentType, fileByte);
            ImgInfo imgInfo = sysFileService.uploadMultipartFileThu(cMultiFile, filePathType, contentType, width, height, fileType, watermarkText);
            if (ObjectUtil.isEmpty(imgInfo)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
            }

            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(imgInfo.getUrl()));
            sysFile.setUrl(imgInfo.getUrl());

            sysFile.setThumbnailName(FileUtils.getName(imgInfo.getThumbnailUrl()));
            sysFile.setThumbnailUrl(imgInfo.getThumbnailUrl());

            return RetCode.ok("文件上传成功！", sysFile);
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    /**
     * 文件下载请求
     */
    public RetCode<SysFile> downloadFileToTemp(String minioUrl) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(minioUrl)) {
                log.error("下载文件异常:请求参数文件不存在！");
                return RetCode.err("下载文件异常:请求参数文件不存在！");
            }
            String outsideBucketUrl = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName();
            String bucketUrl = minioConfig.getUrl() + "/" + minioConfig.getBucketName();
            String realMinioUrl = null;
            if (minioUrl.indexOf(outsideBucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(outsideBucketUrl, "");
            }

            if (minioUrl.indexOf(bucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(bucketUrl, "");
            }

            if (ObjectUtil.isEmpty(realMinioUrl)) {
                log.error("下载文件异常:请求参数异常！");
                return RetCode.err("下载文件异常:请求参数异常！");
            }

            InputStream inputStream = sysFileService.downloadFile(realMinioUrl, null);
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("下载文件异常:文件不存在或者文件路径不存在！");
                return RetCode.err("下载文件异常:文件不存在或者文件路径不存在！");
            }
            // String newFilePath = SpringUtil.getBean(ImportUtils.class).saveTempFile(inputStream, realMinioUrl);
            String newFilePath = "";
            SysFile sysFile = new SysFile();
            sysFile.setNewFilePath(newFilePath);
            return RetCode.ok("", sysFile);
        } catch (Exception e) {
            log.error("下载文件异常", e);
            return RetCode.err("下载文件异常！");
        }
    }


    /**
     * 文件下载请求
     */
    public InputStream downloadFileToUrl(String minioUrl) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(minioUrl)) {
                log.error("下载文件异常:请求参数文件不存在！");
                return null;
            }
            String outsideBucketUrl = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName();
            String bucketUrl = minioConfig.getUrl() + "/" + minioConfig.getBucketName();
            String realMinioUrl = null;
            if (minioUrl.indexOf(outsideBucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(outsideBucketUrl, "");
            }

            if (minioUrl.indexOf(bucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(bucketUrl, "");
            }

            if (ObjectUtil.isEmpty(realMinioUrl)) {
                log.error("下载文件异常:请求参数异常！");
                return null;
            }

            InputStream inputStream = sysFileService.downloadFile(realMinioUrl, null);
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("下载文件异常:文件不存在或者文件路径不存在！");
                return null;
            }
            return inputStream;
        } catch (Exception e) {
            log.error("下载文件异常", e);
            return null;
        }
    }


    /**
     * 获取临时缩略图
     *
     * @param minioUrl
     * @param width
     * @param height
     * @return
     */
    public InputStream getThumbnailImage(String minioUrl, int width, int height) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(minioUrl)) {
                log.error("下载文件异常:请求参数文件不存在！");
                return null;
            }
            String outsideBucketUrl = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName();
            String bucketUrl = minioConfig.getUrl() + "/" + minioConfig.getBucketName();
            String realMinioUrl = null;
            if (minioUrl.indexOf(outsideBucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(outsideBucketUrl, "");
            }

            if (minioUrl.indexOf(bucketUrl) != -1) {
                realMinioUrl = minioUrl.replace(bucketUrl, "");
            }

            if (ObjectUtil.isEmpty(realMinioUrl)) {
                log.error("下载文件异常:请求参数异常！");
                return null;
            }

            InputStream inputStream = sysFileService.getThumbnailImage(realMinioUrl, width, height);
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("下载文件异常:文件不存在或者文件路径不存在！");
                return null;
            }
            return inputStream;
        } catch (Exception e) {
            log.error("下载文件异常", e);
            return null;
        }
    }


    /**
     * 数据库历史数据处理   根据url 下载图片 然后压缩上传 返回新的压缩后的url
     *
     * @param urlStr
     * @param fileName
     * @param width
     * @param height
     * @param fileType
     * @return
     */
    public RetCode<String> historyMinio(String urlStr, String fileName, int width, int height, String fileType, String watermarkText) {
        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(urlStr)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }

            // 判断是否是外网地址 如果是外网地址换成内网地址
            if (urlStr.contains(minioConfig.getOutsideUrl())) {
                urlStr.replace(minioConfig.getOutsideUrl(), minioConfig.getUrl());
            }

            // 创建URL对象
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.connect();
            // 获取文件的MIME类型
            String contentType = connection.getContentType();
            // 从URLConnection获取InputStream
            try (InputStream inputStream = connection.getInputStream()) {
                try (ByteArrayOutputStream baos = copyInputStream(inputStream)) {
                    // 复制出两个新的输入流（此时有一个InputStream的到两个相同的inputStream，如果需要多个还可以继续复制）
                    try (InputStream saveStream = new ByteArrayInputStream(baos.toByteArray());
                         InputStream sizeStream = new ByteArrayInputStream(baos.toByteArray());) {
                        long contentLength = getContentLength(sizeStream);
                        String imgUrl = sysFileService.uploadMultipartFileOnlyThu(saveStream, 1, contentType, fileName, Long.valueOf(contentLength), width, height, fileType, watermarkText);
                        if (ObjectUtil.isEmpty(imgUrl)) {
                            log.error("上传文件异常:文件不存在或者文件路径不存在！");
                            return RetCode.err("上传文件异常:文件不存在或者文件路径不存在！");
                        }
                        return RetCode.ok("文件上传成功！", imgUrl);
                    } catch (Exception exception) {
                        log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                        return RetCode.err("文件上传失败！");
                    }
                } catch (Exception exception) {
                    log.error("外链-URL：" + urlStr + " -上传文件异常", exception.getMessage());
                    return RetCode.err("文件上传失败！");
                }
            } catch (SocketTimeoutException e) {
                log.error("外链-URL：" + urlStr + " -连接超时", e.getMessage());
                return RetCode.err("文件上传失败！连接超时!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
                return RetCode.err("文件上传失败！");
            }
        } catch (Exception e) {
            log.error("外链-URL：" + urlStr + " -上传文件异常", e.getMessage());
            return RetCode.err("文件上传失败！");
        }
    }


    /**
     * 图片嘉水印   根据url 下载图片 然后压缩上传 返回新的压缩后的url
     *
     * @param fileName
     * @param inputStream
     * @param watermarkText
     * @return
     */
    public RetCode<SysFile> addWatermarkMinio(String fileName, InputStream inputStream, String watermarkText) {

        try {
            // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
            // 上传并返回访问地址
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("上传文件异常:请求参数文件不存在！");
                return RetCode.err("上传文件异常:请求参数文件不存在！");
            }
            InputStream waterMarkInputStream = sysFileService.addWatermarkToUrlImage(inputStream, watermarkText);
            RetCode<SysFile> sysFile = uploadBufferedImageFile(fileName, ImageIO.read(waterMarkInputStream), 1);
            sysFile.setMsg("文件上传成功！");
            return sysFile;
        } catch (Exception e) {
            log.error("上传文件异常", e);
            return RetCode.err("文件上传失败！");
        }
    }

    // 指定宽高像素图片裁剪后上传图片服务器

    /**
     * 先这样 后面有时间再封装
     *
     * @param url
     * @param type 1.750 *1000 裁剪 2.800*800
     * @return
     */
    public RetCode<SysFile> cutPixel(String url, Integer type) throws Exception {

        // TODO 如果对文件大小、格式做限制在这里做，直接引用File工具类即可已实现
        // 上传并返回访问地址
        if (ObjectUtil.isEmpty(url)) {
            log.error("上传文件异常:请求参数文件不存在！");
            return RetCode.err("上传文件异常:请求参数文件不存在！");
        }

        if (ObjectUtil.isEmpty(type)) {
            log.error("上传文件异常:请求参数type 不存在！");
            return RetCode.err("上传文件异常:请求参数 type不存在！");
        }

        if (url.contains(minioConfig.getOutsideUrl())) {
            url = url.replace(minioConfig.getOutsideUrl(), minioConfig.getUrl());
        }

        ResponseEntity<byte[]> rtByte = downloadImgRestTemplateByUrl(url);
        String contentType = rtByte.getHeaders().getContentType().toString();
        // 从URLConnection获取InputStream
        try (InputStream inputStream = new ByteArrayInputStream(rtByte.getBody())) {
            if (ObjectUtil.isEmpty(inputStream)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在：" + url);
//                    return RetCode.err("上传文件异常:文件不存在或者文件路径不存在：" + url);
                throw new Exception("上传文件异常:文件不存在或者文件路径不存在：" + url);
            }

            BufferedImage bufferedImage = null;
            if (type == 1) {
                bufferedImage = ImageUtil.cutPixel(inputStream);
            } else if (type == 2) {
                bufferedImage = ImageUtil.cutPixel(inputStream, 800, 800);
            }

            if (ObjectUtil.isEmpty(bufferedImage)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在：" + url);
//                    return RetCode.err("上传文件异常:文件不存在或者文件路径不存在：" + url);
                throw new Exception("上传文件异常:文件不存在或者文件路径不存在：" + url);
            }

            RetCode<SysFile> sysFileRetCode = uploadBufferedImageFile(UUID.randomUUID().toString() + url.substring(url.lastIndexOf(".")), bufferedImage, 1);
            if (ObjectUtil.isEmpty(sysFileRetCode)) {
                log.error("上传文件异常:文件不存在或者文件路径不存在：" + url);
//                    return RetCode.err("上传文件异常:文件不存在或者文件路径不存在：" + url);
                throw new Exception("上传文件异常:文件不存在或者文件路径不存在：" + url);
            }

            sysFileRetCode.setMsg("文件上传成功！");
            return sysFileRetCode;
        } catch (Exception e) {
            log.error("上传文件异常", e);
            throw new Exception("上传文件异常", e);
//                return RetCode.err("文件上传失败！");
        }
    }

//    public static  ResponseEntity<byte[]> downloadImgRestTemplateByUrl(String url) {
//
//        String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("user-agent", userAgent);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        // 设置超时
//        int timeout = 15000; // 30 seconds
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(timeout)
//                .setConnectionRequestTimeout(timeout)
//                .setSocketTimeout(timeout)
//                .build();
//        CloseableHttpClient client = HttpClientBuilder.create()
//                .setDefaultRequestConfig(config)
//                .build();
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
//
//        // 创建一个新的 RestTemplate 实例
//        RestTemplate restTemplate = new RestTemplate(factory);
//
//        ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity,byte[].class);
//        return result;
//    }

    public  ResponseEntity<byte[]> downloadImgRestTemplateByUrl(String url) {
//        String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("user-agent", userAgent);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        // 设置超时时间
//        int timeout = 25000; // 25 秒
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(timeout)
//                .setConnectionRequestTimeout(timeout)
//                .setSocketTimeout(timeout)
//                .build();
//
//        try (CloseableHttpClient client = HttpClientBuilder.create()
//                .setDefaultRequestConfig(config)
//                .build()) {
//
//            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
//            RestTemplate restTemplate = new RestTemplate(factory);
//
//            int maxRetries = 5; // 最大重试次数
//            int attempt = 0;
//            while (attempt < maxRetries) {
//                try {
//                    ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
//
//                    // 判断状态码是否成功
//                    if (result.getStatusCode().is2xxSuccessful()) {
//                        return result;
//                    } else {
//                        throw new RuntimeException("HTTP 请求失败，状态码：" + result.getStatusCode());
//                    }
//                } catch (ResourceAccessException ex) {
//                    attempt++;
//                    if (attempt >= maxRetries) {
//                        throw new RuntimeException("下载图片失败，已重试 " + maxRetries + " 次: " + ex.getMessage(), ex);
//                    }
//                    Thread.sleep(2000); // 失败后等待 2 秒再重试
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("下载图片时发生异常: " + e.getMessage(), e);
//        }
//        return null;

        String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", userAgent);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        int timeout = 25000;
        int maxRetries = 5;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(timeout))
                .setConnectionRequestTimeout(Timeout.ofSeconds(timeout))
                .setResponseTimeout(Timeout.ofSeconds(timeout))
                .build();

        try (CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .build()) {



            int attempt = 0;
            while (attempt < maxRetries) {
                try {
                    log.info("下载 URL: {}", URLDecoder.decode(url, StandardCharsets.UTF_8));

                    ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

                    if (result.getStatusCode().is2xxSuccessful()) {
                        return result;
                    } else {
                        String errorMsg = "HTTP 请求失败，状态码: " + result.getStatusCode();
                        if (result.getStatusCode() == HttpStatus.FORBIDDEN) {
                            errorMsg += " (403 Forbidden - 可能是签名错误，请检查访问密钥、URL 编码或时间同步)";
                        }
                        throw new RuntimeException(errorMsg);
                    }
                } catch (HttpClientErrorException e) {
                    if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                        log.warn("403 Forbidden: 签名错误，正在重试... 尝试次数: {}", (attempt + 1));
                    } else {
                        log.error("HTTP 请求异常: {} - {}", e.getStatusCode(), e.getMessage());
                    }
                    log.error("完整返回体: {}", e.getResponseBodyAsString());
                } catch (ResourceAccessException ex) {
                    log.warn("网络异常，正在重试... 尝试次数: {} - {}", (attempt + 1), ex.getMessage());
                }
                attempt++;
            }
        } catch (Exception e) {
            throw new RuntimeException("下载图片时发生异常: " + e.getMessage(), e);
        }
        throw new RuntimeException("下载图片失败，已重试 " + maxRetries + " 次。");
    }

    public static Integer getContentLength(InputStream inputStream) throws IOException {
        int contentLength = 0;
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            contentLength += bytesRead;
        }

        return contentLength;
    }

    /**
     * 流复制
     */
    private static ByteArrayOutputStream copyInputStream(InputStream input) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // 定义一个缓存数组，临时存放读取的数组
            //经过测试，4*1024是一个非常不错的数字，过大过小都会比较影响性能
            byte[] buffer = new byte[4096];
            int length;
            while ((length = input.read(buffer)) > -1) {
                baos.write(buffer, 0, length);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
