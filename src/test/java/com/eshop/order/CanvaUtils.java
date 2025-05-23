package com.eshop.order;


import cn.hutool.core.img.ImgUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 画布工具类
 *
 * @author sheng
 * @date 2024-12-18 13:45
 **/
public class CanvaUtils {
    /**
     * 画布添加图片设置大小
     *
     * @param canvasWidth
     * @param canvasHeight
     * @param sourceImage
     * @return java.io.ByteArrayOutputStream
     * @author sheng
     * @date 2024-12-18 17:11
     */
    public static BufferedImage imageConversion(int canvasWidth, int canvasHeight, BufferedImage sourceImage) {
        //图片信息
        BufferedImage sourceImage1 = verifyImageSize(sourceImage, canvasWidth, canvasHeight);

        // 居中图像并获取新的画布
        BufferedImage centeredImage = centerImage(sourceImage1, canvasWidth, canvasHeight);
        // 使用 ByteArrayOutputStream 来保存图像数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(centeredImage, "png", byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return centeredImage;
    }
    /**
     * 画布居中图片
     *
     * @param source
     * @param canvasWidth
     * @param canvasHeight
     * @return java.awt.image.BufferedImage
     * @author sheng
     * @date 2024-12-18 17:16
     */
    public static BufferedImage centerImage(BufferedImage source, int canvasWidth, int canvasHeight) {
        // 创建一个指定大小的透明画布
        BufferedImage canvas = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = canvas.createGraphics();

        try {
            // 获取源图片的宽度和高度
            int sourceWidth = source.getWidth();
            int sourceHeight = source.getHeight();

            // 计算源图片放置在画布上的位置以使其居中
            int x = (canvasWidth - sourceWidth) / 2;
            int y = (canvasHeight - sourceHeight) / 2;

            // 将源图片绘制到画布上
            g2d.drawImage(source, x, y, null);
        } finally {
            // 确保图形上下文被正确释放
            g2d.dispose();
        }

        return canvas;
    }


    /**
     * 图片大于画布时，缩小图片
     *
     * @return java.awt.image.BufferedImage
     * @author sheng
     * @date 2024-12-18 14:24
     */
    public static BufferedImage verifyImageSize(BufferedImage sourceImage, int canvasWidth, int canvasHeight) {
        //图片宽高
        int originalWidth = sourceImage.getWidth();
        int originalHeight = sourceImage.getHeight();
        double scale = Math.min((double) canvasWidth / originalWidth, (double) canvasHeight / originalHeight);
        if (scale < 1.0) { // 只有当需要缩小的时候才进行处理
            originalWidth = (int) (originalWidth * scale);
            originalHeight = (int) (originalHeight * scale);

            // 缩放图片
            Image scaledImage = sourceImage.getScaledInstance(originalWidth, originalHeight, Image.SCALE_SMOOTH);
            return ImgUtil.toBufferedImage(scaledImage);
        }
        return sourceImage;
    }
}
