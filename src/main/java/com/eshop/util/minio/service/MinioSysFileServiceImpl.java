package com.eshop.util.minio.service;

import cn.hutool.core.util.ObjectUtil;
import com.eshop.util.minio.FileUploadUtils;
import com.eshop.util.minio.ImgInfo;
import com.eshop.util.minio.MinioConfig;
import com.eshop.util.minio.ThumbnailGeneratorUtil;
import io.minio.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * Minio 文件存储
 * 
 * @author rch
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    private static final Logger logger = LoggerFactory.getLogger(MinioSysFileServiceImpl.class);
    /**
     * 本地文件上传接口
     * 
     * @param file 上传的文件
     * @param filePathType  上传文件类型  详情见配置文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadMultipartFile(MultipartFile file, Integer filePathType, String contentType) throws Exception
    {
        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        if (ObjectUtil.isEmpty(file) || ObjectUtil.isEmpty(mapPaths) || !mapPaths.keySet().contains(filePathType)) {
            return null;
        }

        String filePathTypeName = mapPaths.get(filePathType);
        contentType = ObjectUtil.isEmpty(contentType) ? file.getContentType() : contentType;
        String fileName = filePathTypeName + "/" + FileUploadUtils.extractFilename(file);

        System.out.println("file.getSize()---：" + file.getSize());


        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), 5 * 1024 * 1024)
                .contentType(contentType)
                .build();
        client.putObject(args);
        return minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
    }


    /**
     * 本地文件上传接口带缩略图接口
     * @param file
     * @param filePathType
     * @param contentType
     * @param width
     * @param height
     * @param fileType
     * @return
     * @throws Exception
     */
    @Override
    public ImgInfo uploadMultipartFileThu(MultipartFile file, Integer filePathType, String contentType, Integer width, Integer height, String fileType, String watermarkText) throws Exception
    {
        ImgInfo imgInfo = new ImgInfo();
        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        if (ObjectUtil.isEmpty(file) || ObjectUtil.isEmpty(mapPaths) || !mapPaths.keySet().contains(filePathType)) {
            return null;
        }

        String filePathTypeName = mapPaths.get(filePathType);
        contentType = ObjectUtil.isEmpty(contentType) ? file.getContentType() : contentType;
        String fileName = filePathTypeName + "/" + FileUploadUtils.extractFilename(file, fileType);

        System.out.println("file.getSize()---：" + file.getSize());


        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), 5 * 1024 * 1024)
                .contentType(contentType)
                .build();
        client.putObject(args);

        // 原图url
        String url = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
        imgInfo.setUrl(url);

        // 缩略图
        InputStream inputStreamThu = ThumbnailGeneratorUtil.generateThumbnail(file.getInputStream(), width, height, fileType);
        if (ObjectUtil.isNotEmpty(watermarkText)) {
            inputStreamThu = addWatermarkToUrlImage(inputStreamThu, watermarkText);
        }

        String fileNameThu = filePathTypeName + "/" + FileUploadUtils.extractFilename(file, fileType);
        PutObjectArgs argsThu = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileNameThu)
                .stream(inputStreamThu, inputStreamThu.available(), 5 * 1024 * 1024)
                .contentType(contentType)
                .build();
        client.putObject(argsThu);

        String urlThu = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + fileNameThu;
        imgInfo.setThumbnailUrl(urlThu);

        return imgInfo;
    }


    /**
     * 本地文件上传接口
     *
     * @param inputStream 上传的文件
     * @param filePathType  上传文件类型  详情见配置文件
     * @param contentType   文件格式
     * @Param fileName      文件名称
     * @Param fileSize      文件大小
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadMultipartFile(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize) throws Exception
    {

        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        String filePathTypeName = mapPaths.get(filePathType);
        if (ObjectUtil.isEmpty(inputStream)
                || ObjectUtil.isEmpty(mapPaths)
                || !mapPaths.keySet().contains(filePathType)
                || ObjectUtil.isEmpty(contentType)
                || ObjectUtil.isEmpty(fileSize)) {
            return null;
        }

        String uploadFileName = filePathTypeName + "/" + FileUploadUtils.extractFilename(fileName);

        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(uploadFileName)
                .stream(inputStream, fileSize, -1)
                .contentType(contentType)
                .build();
        client.putObject(args);
        return minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + uploadFileName;
    }

    /**
     * 本地文件上传接口
     *
     * @param inputStream 上传的文件
     * @param filePathType  上传文件类型  详情见配置文件
     * @param contentType   文件格式
     * @Param fileName      文件名称
     * @Param fileSize      文件大小
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadMultipartFile(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize, String watermarkStr) throws Exception
    {

        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        String filePathTypeName = mapPaths.get(filePathType);
        if (ObjectUtil.isEmpty(inputStream)
                || ObjectUtil.isEmpty(mapPaths)
                || !mapPaths.keySet().contains(filePathType)
                || ObjectUtil.isEmpty(contentType)
                || ObjectUtil.isEmpty(fileSize)) {
            return null;
        }

        if (ObjectUtil.isNotEmpty(watermarkStr)) {
            inputStream = addWatermarkToUrlImage(inputStream, watermarkStr);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        long contentLength = outputStream.size();
        String uploadFileName = filePathTypeName + "/" + FileUploadUtils.extractFilename(fileName);

        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(uploadFileName)
                .stream(inputStream, contentLength, -1)
                .contentType(contentType)
                .build();
        client.putObject(args);
        return minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + uploadFileName;
    }


    /**
     * 本地文件上传接口-带缩略图
     *
     * @param inputStream 上传的文件
     * @param filePathType  上传文件类型  详情见配置文件
     * @param contentType   文件格式
     * @Param fileName      文件名称
     * @Param fileSize      文件大小
     * @Param width
     * @Param height
     * @return 访问地址
     * @throws Exception
     */
    public ImgInfo uploadMultipartFileThu(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize, int width, int height, String fileType, String watermarkText) throws Exception
    {

        ImgInfo imgInfo = new ImgInfo();
        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        String filePathTypeName = mapPaths.get(filePathType);
        if (ObjectUtil.isEmpty(inputStream)
                || ObjectUtil.isEmpty(mapPaths)
                || !mapPaths.keySet().contains(filePathType)
                || ObjectUtil.isEmpty(contentType)
                || ObjectUtil.isEmpty(fileSize)) {
            return null;
        }

        String uploadFileName = filePathTypeName + "/" + FileUploadUtils.extractFilename(fileName, fileType);

        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(uploadFileName)
                .stream(inputStream, fileSize, -1)
                .contentType(contentType)
                .build();
        client.putObject(args);

        String url = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + uploadFileName;
        imgInfo .setUrl(url);


        InputStream inputStreamThu = ThumbnailGeneratorUtil.generateThumbnail(inputStream, width, height, fileType);
        if (ObjectUtil.isNotEmpty(watermarkText)) {
            inputStreamThu = addWatermarkToUrlImage(inputStreamThu, watermarkText);
        }
        String uploadFileNameThu = filePathTypeName + "/" + FileUploadUtils.extractFilename(fileName);
        PutObjectArgs argsThu = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(uploadFileNameThu)
                .stream(inputStreamThu, inputStreamThu.available(), -1)
                .contentType(contentType)
                .build();
        client.putObject(argsThu);

        String urlThu = minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + uploadFileNameThu;
        imgInfo.setThumbnailUrl(urlThu);
        return imgInfo;
    }

    /**
     * 获取指定url图片并添加水印
     * @param originalInputStream
     * @param watermarkText
     * @return
     * @throws IOException
     */
    public InputStream addWatermarkToUrlImage(InputStream originalInputStream, String watermarkText) throws IOException {
        BufferedImage originalImage = ImageIO.read(originalInputStream);
        // 创建水印属性
        Graphics2D g2d = (Graphics2D) originalImage.getGraphics();

        // 将原始图片绘制到水印图片上
        g2d.drawImage(originalImage, 0, 0, null);

        // 设置水印字体、大小和颜色
//        Font font = new Font("Arial", Font.BOLD, 20);
        Font font = getSuitableFont(originalImage, watermarkText);
        g2d.setFont(font);
        g2d.setColor(Color.lightGray);

        // 添加水印文本
        FontRenderContext frc = g2d.getFontRenderContext();
        int textWidth = (int) font.getStringBounds(watermarkText, frc).getWidth();
        int textHeight = (int) font.getStringBounds(watermarkText, frc).getHeight();

        // 计算水印之间的间隔
        int xInterval = textWidth * 3 / 2; // 水印之间的横向间隔为水印文本宽度的 1.5 倍
        int yInterval = textHeight * 3 / 1; // 水印之间的纵向间隔为水印文本高度的 1.5倍

        // 添加水印
        AffineTransform originalTransform = g2d.getTransform(); // 保存原始的变换
        for (int y = 0; y < originalImage.getHeight() + 45; y += yInterval) {
            for (int x = 0; x < originalImage.getWidth() + 45; x += xInterval) {
                g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(-45), x, y)); // 设置旋转角度为 -45 度
                g2d.drawString(watermarkText, x,y + 25);
            }
        }
        g2d.setTransform(originalTransform); // 恢复原始的变换
        // 释放资源
        g2d.dispose();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "png", outputStream);

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    // 计算适合的字体大小
    public static Font getSuitableFont(BufferedImage originalImage, String watermarkText) {
        int fontSize = 12; // 初始字体大小
        int targetWidth = originalImage.getWidth() / 4; // 目标宽度为图片的 1/4
        int targetHeight = originalImage.getHeight() / 4; // 目标高度为图片的 1/4

        Font font = new Font("Arial", Font.BOLD, fontSize);
        FontMetrics metrics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
                .createGraphics().getFontMetrics(font);

        while (metrics.stringWidth(watermarkText) < targetWidth && metrics.getHeight() < targetHeight) {
            fontSize++;
            font = new Font("Arial", Font.BOLD, fontSize);
            metrics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
                    .createGraphics().getFontMetrics(font);
        }

        return font;
    }

    /**
     * 本地文件上传接口-仅仅缩略图
     *
     * @param inputStream 上传的文件
     * @param filePathType  上传文件类型  详情见配置文件
     * @param contentType   文件格式
     * @Param fileName      文件名称
     * @Param fileSize      文件大小
     * @Param width
     * @Param height
     * @return 访问地址
     * @throws Exception
     */
    public String uploadMultipartFileOnlyThu(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize, int width, int height, String fileType, String watermarkText) throws Exception
    {
        Map<Integer, String> mapPaths = minioConfig.getFilePaths();
        String filePathTypeName = mapPaths.get(filePathType);
        if (ObjectUtil.isEmpty(inputStream)
                || ObjectUtil.isEmpty(mapPaths)
                || !mapPaths.keySet().contains(filePathType)
                || ObjectUtil.isEmpty(contentType)
                || ObjectUtil.isEmpty(fileSize)) {
            return null;
        }

        InputStream inputStreamThu = ThumbnailGeneratorUtil.generateThumbnail(inputStream, width, height, fileType);
        if (ObjectUtil.isNotEmpty(watermarkText)) {
            inputStreamThu = addWatermarkToUrlImage(inputStreamThu, watermarkText);
        }
        String uploadFileNameThu = filePathTypeName + "/" + FileUploadUtils.extractFilename(fileName, fileType);
        PutObjectArgs argsThu = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(uploadFileNameThu)
                .stream(inputStreamThu, inputStreamThu.available(), -1)
                .contentType(contentType)
                .build();
        client.putObject(argsThu);

        return minioConfig.getOutsideUrl() + "/" + minioConfig.getBucketName() + "/" + uploadFileNameThu;
    }


    /**
     * 下载文件
     * @param originalName 文件路径(桶下相对路径)
     */
    @Override
    public InputStream downloadFile(String originalName, HttpServletResponse response) {
        try {
            InputStream file = client.getObject(GetObjectArgs.builder().bucket(minioConfig.getBucketName()).object(originalName).build());
            if (ObjectUtil.isEmpty(response)) {
                return file;
            }
            String filename = new String(originalName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
            if (ObjectUtil.isNotEmpty(originalName)) {
                filename = originalName;
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = file.read(buffer)) > 0) {
                servletOutputStream.write(buffer, 0, len);
            }
            servletOutputStream.flush();
            file.close();
            servletOutputStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取指定大小缩略图
     * @param objectName
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    public InputStream getThumbnailImage(String objectName, int width, int height) throws Exception {
        InputStream objectStream = client.getObject(GetObjectArgs.builder().bucket(minioConfig.getBucketName()).object(objectName).build());
        BufferedImage originalImage = ImageIO.read(objectStream);
        BufferedImage thumbnailImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        thumbnailImage.createGraphics().drawImage(originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH),0,0,null);
        ByteArrayOutputStream thumbnailOutputStream = new ByteArrayOutputStream();
        String fileType = objectName.substring(objectName.lastIndexOf(".")+1, objectName.length());
        ImageIO.write(thumbnailImage, fileType, thumbnailOutputStream);
        return new ByteArrayInputStream(thumbnailOutputStream.toByteArray());
    }



    /**
     * 文件刪除
     * @param objects objects.add(new DeleteObject("my-objectname2"));
     */
    @Override
    public void deleteFile(List<DeleteObject> objects) {
        try {
            // 执行批量删除操作
            Iterable<Result<DeleteError>> results =
                    client.removeObjects(
                            RemoveObjectsArgs.builder().bucket(minioConfig.getBucketName()).objects(objects).build());

            // 检查是否有删除错误
            for (Result<DeleteError> result : results) {
                DeleteError error = result.get();
                logger.error("Error in deleting object " + error.objectName() + "; " + error.message());
            }
        } catch (Exception e) {
            logger.error("Error occurred: " + e);
        }
    }
}
