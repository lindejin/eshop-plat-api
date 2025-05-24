package com.eshop.order;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.tika.Tika;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TemuImageService {

    private static final Tika tika = new Tika();
    private static final float MAX_SIZE_MB = 0.35f;
    private static final float JPEG_QUALITY = 0.9f;
    private static final int TARGET_WIDTH = 1340;
    private static final int TARGET_HEIGHT = 1785;

    public static byte[] processImage(byte[] imageData, String suffix) throws IOException {
        if (suffix == null) {
            throw new IllegalArgumentException("无法识别的图片格式");
        }

        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        if (originalImage == null) {
            throw new IOException("图片解码失败");
        }

        // 计算保持比例的缩放尺寸
        Dimension scaledDimension = calculateScaledDimension(
                new Dimension(originalImage.getWidth(), originalImage.getHeight()),
                new Dimension(TARGET_WIDTH, TARGET_HEIGHT)
        );

        // 创建缩放后的图片
        BufferedImage scaledImage = scaleImage(originalImage, scaledDimension);

        // 创建目标画布并居中绘制
        BufferedImage processedImage = new BufferedImage(
                TARGET_WIDTH, TARGET_HEIGHT,
                originalImage.getColorModel().hasAlpha() ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB
        );
        drawCenteredImage(processedImage, scaledImage, Color.WHITE);

        return compressToMaxSize(processedImage, suffix, MAX_SIZE_MB);
    }

    /**
     * 计算保持宽高比的缩放尺寸（贴边策略）
     */
    private static Dimension calculateScaledDimension(Dimension imgSize, Dimension boundary) {
        int originalWidth = imgSize.width;
        int originalHeight = imgSize.height;
        int boundWidth = boundary.width;
        int boundHeight = boundary.height;

        // 计算宽高比
        double imgRatio = (double) originalWidth / originalHeight;
        double boundRatio = (double) boundWidth / boundHeight;

        if (imgRatio > boundRatio) {
            // 以宽度为基准缩放
            return new Dimension(boundWidth, (int) (boundWidth / imgRatio));
        } else {
            // 以高度为基准缩放
            return new Dimension((int) (boundHeight * imgRatio), boundHeight);
        }
    }

    /**
     * 等比例缩放图片
     */
    private static BufferedImage scaleImage(BufferedImage original, Dimension size) throws IOException {
        return Thumbnails.of(original)
                .size(size.width, size.height)
                .asBufferedImage();
    }

    /**
     * 在目标画布中居中绘制图片
     */
    private static void drawCenteredImage(BufferedImage canvas, BufferedImage image, Color bgColor) {
        Graphics2D g = canvas.createGraphics();
        try {
            // 填充背景
            g.setColor(bgColor);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            // 计算居中位置
            int x = (canvas.getWidth() - image.getWidth()) / 2;
            int y = (canvas.getHeight() - image.getHeight()) / 2;

            // 抗锯齿绘制
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.drawImage(image, x, y, null);
        } finally {
            g.dispose();
        }
    }

    // 压缩方法保持不变...

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
