package com.eshop.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ThumbnailatorSquareUtilsTest {

    public static void main(String[] args) {
        String imageUrl = "https://img.kwcdn.com/product/open/2fbb4e07b3c84a75872ff044147aac9f-goods.jpeg"; // 替换为实际测试图片URL

        try (InputStream in = new URL(imageUrl).openStream()) {
            // 读取原始图片获取尺寸
            BufferedImage original = ImageIO.read(in);
            int originalLongSide = Math.max(original.getWidth(), original.getHeight());
            // 测试1: 使用自定义背景处理
            byte[] squaredImage = ThumbnailatorSquareUtils.toSquareFromUrl(
                    imageUrl,
                    originalLongSide,
                    Color.WHITE,
                    "jpg"
            );

            // 保存结果
            ImageIO.write(
                    ImageIO.read(new ByteArrayInputStream(squaredImage)),
                    "jpg",
                    new File("output_square.jpg")
            );

            // 测试2: 使用简单方法处理
            byte[] simpleSquare = ThumbnailatorSquareUtils.toSquareFromUrl(
                    imageUrl,
                    originalLongSide,
                    null, // 使用默认透明背景
                    "png"
            );

            ImageIO.write(
                    ImageIO.read(new ByteArrayInputStream(simpleSquare)),
                    "png",
                    new File("output_simple_square.png")
            );

            System.out.println("图片处理完成，结果已保存");

        } catch (IOException e) {
            System.err.println("图片处理失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
