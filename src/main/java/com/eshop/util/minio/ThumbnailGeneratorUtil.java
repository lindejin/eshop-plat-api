package com.eshop.util.minio;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author xxs
 * @date 2023/12/6
 * @desc 缩略图工具嘞
 */
public class ThumbnailGeneratorUtil {
    public static InputStream generateThumbnail(InputStream inputStream, int width, int height, String fileType) throws IOException {
//        BufferedImage originalImage = ImageIO.read(inputStream);
//        BufferedImage thumbnail = Thumbnails.of(originalImage)
//                .size(width, height)
//                .asBufferedImage();
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ImageIO.write(thumbnail, fileType, outputStream);
//
//        return new ByteArrayInputStream(outputStream.toByteArray());
        return Files.newInputStream(ImageUtil.imgCompress(inputStream, fileType, width, height).toPath());
    }


    public static InputStream generateThumbnail(InputStream inputStream, Float scale, String fileType) throws IOException {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ImgUtil.scale(inputStream, outputStream, scale);
//        // 从 ByteArrayOutputStream 中获取字节数组
//        // 创建 ByteArrayInputStream 以读取图像
//        // 使用 ImageIO 读取 PNG 图像
//        // 创建新的 ByteArrayOutputStream 以重新编码为特定图像类型
//        ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream();
//        // 将图像写入到新的 ByteArrayOutputStream 中
//        ImageIO.write(ImageIO.read(new ByteArrayInputStream(outputStream.toByteArray())), fileType, imageOutputStream);
//        // 使用 ByteArrayInputStream 创建 InputStream 流
//        return new ByteArrayInputStream(imageOutputStream.toByteArray());
        return new FileInputStream(ImageUtil.imgCompress(inputStream, fileType, scale));
    }
}
