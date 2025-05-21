package com.eshop.img;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

public class ThumbnailatorSquareUtils2 {

    /**
     * 高质量将图片处理为正方形（保持原比例，不裁剪）
     *
     * @param inputStream 图片输入流
     * @param size        正方形边长
     * @param bgColor     背景颜色
     * @param format      输出格式（jpg/png等）
     * @return 处理后的图片字节数组
     */
    public static byte[] toSquare(InputStream inputStream, int size, Color bgColor, String format) throws IOException {
        // 读取原始图像
        BufferedImage original = ImageIO.read(inputStream);

        // 创建高质量的正方形画布
        BufferedImage squared = new BufferedImage(size, size,
                hasTransparency(original) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);

        // 获取Graphics2D对象并设置高质量渲染参数
        Graphics2D g = squared.createGraphics();

        // 设置渲染质量为最高
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

        // 设置背景
        if (bgColor != null) {
            g.setColor(bgColor);
            g.fillRect(0, 0, size, size);
        }

        // 计算缩放比例 - 添加0.5像素偏移避免舍入误差
        double scale = Math.min((double) size / original.getWidth(), (double) size / original.getHeight());
        int newWidth = (int) Math.round(original.getWidth() * scale);
        int newHeight = (int) Math.round(original.getHeight() * scale);

        // 计算居中位置 - 添加0.5像素偏移
        int x = (int) Math.round((size - newWidth) / 2.0);
        int y = (int) Math.round((size - newHeight) / 2.0);

        // 高质量绘制图像
        g.drawImage(original, x, y, newWidth, newHeight, null);
        g.dispose();

        // 转换为字节数组 - 添加压缩质量参数
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        if ("jpg".equalsIgnoreCase(format) || "jpeg".equalsIgnoreCase(format)) {
            // 对于JPEG格式，设置压缩质量
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
            if (writers.hasNext()) {
                ImageWriter writer = writers.next();
                ImageWriteParam param = writer.getDefaultWriteParam();
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.95f); // 设置JPEG质量为95%

                try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
                    writer.setOutput(ios);
                    writer.write(null, new IIOImage(squared, null, null), param);
                }
                writer.dispose();
            } else {
                ImageIO.write(squared, format, baos);
            }
        } else {
            // 其他格式直接写入
            ImageIO.write(squared, format, baos);
        }

        return baos.toByteArray();
    }

    /**
     * 从URL读取图片并处理为正方形
     *
     * @param imageUrl 图片URL
     * @param size     正方形边长
     * @param bgColor  背景颜色
     * @param format   输出格式
     * @return 处理后的图片字节数组
     */
    public static byte[] toSquareFromUrl(String imageUrl, int size, Color bgColor, String format) throws IOException {
        try (InputStream in = new URL(imageUrl).openStream()) {
            return toSquare(in, size, bgColor, format);
        }
    }

    /**
     * 使用Thumbnailator内置方法处理为正方形（简单版）
     */
    public static byte[] toSquareSimple(InputStream inputStream, int size, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Thumbnails.of(inputStream)
                .size(size, size)
                .keepAspectRatio(true)
                .outputFormat(format)
                .toOutputStream(baos);
        return baos.toByteArray();
    }

    /**
     * 检查图片是否有透明通道
     */
    private static boolean hasTransparency(BufferedImage image) {
        return image.getTransparency() != Transparency.OPAQUE;
    }
}
