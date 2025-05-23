package com.eshop.order;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.tika.Tika;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageService {

    private static final Tika tika = new Tika();
    private static final int MAX_SIZE_MB = 2;
    private static final float JPEG_QUALITY = 0.9f;

    /**
     * 处理图片：校验后缀、填充背景、压缩至 ≤2MB
     */
    public static byte[] processImage(byte[] imageData,String suffix) throws IOException {
        // 1. 获取真实文件后缀（基于内容）
        if (suffix == null) {
            throw new IllegalArgumentException("无法识别的图片格式");
        }

        // 2. 解码图片
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        if (originalImage == null) {
            throw new IOException("图片解码失败");
        }

        // 3. 构建画布（填充白色背景）
        BufferedImage processedImage = createCanvasWithBackground(originalImage, suffix);

        // 4. 动态压缩至目标大小
        return compressToMaxSize(processedImage, suffix, MAX_SIZE_MB);
    }


    /**
     * 创建带白色背景的画布（根据后缀处理透明度）
     */
    private static BufferedImage createCanvasWithBackground(BufferedImage src, String suffix) {
        int width = src.getWidth();
        int height = src.getHeight();

        // 判断是否需要处理透明度（PNG/GIF）
        boolean hasAlpha = src.getColorModel().hasAlpha();
        Color backgroundColor = Color.WHITE;

        // 创建画布
        BufferedImage canvas = new BufferedImage(
                width, height,
                hasAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g = canvas.createGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, width, height);
        g.drawImage(src, 0, 0, null);
        g.dispose();

        return canvas;
    }

    /**
     * 动态压缩图片至指定大小
     */
    private static byte[] compressToMaxSize(BufferedImage image, String suffix, double maxSizeBytes) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        float quality = JPEG_QUALITY;
        byte[] buffer;

        // 根据格式选择编码器
        if ("png".equalsIgnoreCase(suffix)) {
            // PNG 无损压缩
            ImageIO.write(image, "png", baos);
            buffer = baos.toByteArray();
        } else {
            // JPEG 有损压缩（动态调整质量）
            do {
                baos.reset();
                Thumbnails.of(image)
                        .scale(1.0) // 保持原始尺寸
                        .outputQuality(quality)
                        .outputFormat("jpeg")
                        .toOutputStream(baos);
                buffer = baos.toByteArray();
                quality -= 0.05f; // 每次降低5%质量
            } while (quality > 0.1f && buffer.length > maxSizeBytes);
        }

        return buffer;
    }
}
