package com.eshop.api3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class PdfBase64Saver {

    /**
     * 保存Base64编码的PDF到文件
     * @param pdfBase64 Base64编码的PDF数据
     * @param outputPath 输出文件路径（完整路径）
     * @throws IOException 如果保存失败或文件无效
     */
    public static void saveBase64PdfToFile(String pdfBase64, String outputPath) throws IOException {
        // 1. 验证输入参数
        if (pdfBase64 == null || pdfBase64.isEmpty()) {
            throw new IllegalArgumentException("PDF Base64数据不能为空");
        }

        // 2. 清理Base64字符串
        String cleanedBase64 = cleanBase64String(pdfBase64);

        // 3. 解码为字节数组
        byte[] pdfBytes = decodeBase64(cleanedBase64);

        // 4. 验证PDF有效性
        validatePdfContent(pdfBytes);

        // 5. 保存到文件
        writeToFile(pdfBytes, outputPath);

        // 6. 二次验证文件内容
        validateSavedFile(outputPath);
    }

    // 清理Base64字符串
    private static String cleanBase64String(String base64Data) {
        // 移除数据URI前缀
        if (base64Data.startsWith("data:application/pdf;base64,")) {
            return base64Data.substring("data:application/pdf;base64,".length());
        }

        // 处理其他URI格式
        int commaIndex = base64Data.indexOf(',');
        if (commaIndex > 0) {
            return base64Data.substring(commaIndex + 1);
        }

        // 移除所有空白字符
        return base64Data.replaceAll("\\s+", "");
    }

    // 解码Base64数据
    private static byte[] decodeBase64(String base64Data) {
        // 处理URL安全格式
        String sanitized = base64Data
                .replace('-', '+')
                .replace('_', '/');

        // 补充填充字符
        int padding = (4 - sanitized.length() % 4) % 4;
        sanitized += "====".substring(0, padding);

        try {
            return Base64.getDecoder().decode(sanitized);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("无效的Base64格式", e);
        }
    }

    // 验证PDF内容有效性
    private static void validatePdfContent(byte[] pdfBytes) throws IOException {
        if (pdfBytes.length < 4) {
            throw new IOException("PDF数据不足（至少4字节）");
        }

        // 检查标准PDF头（%PDF）
        if (pdfBytes[0] == '%' && pdfBytes[1] == 'P' && pdfBytes[2] == 'D' && pdfBytes[3] == 'F') {
            return;
        }

        // 检查PDF-A等其他变体（25 50 44 46十六进制形式）
        if (pdfBytes[0] == 0x25 && pdfBytes[1] == 0x50 && pdfBytes[2] == 0x44 && pdfBytes[3] == 0x46) {
            return;
        }

        // 检查文件尾（%%EOF）
        boolean hasFooter = false;
        for (int i = Math.max(0, pdfBytes.length - 128); i < pdfBytes.length - 5; i++) {
            if (pdfBytes[i] == '%' && pdfBytes[i + 1] == '%' &&
                    pdfBytes[i + 2] == 'E' && pdfBytes[i + 3] == 'O' && pdfBytes[i + 4] == 'F') {
                hasFooter = true;
                break;
            }
        }

        if (!hasFooter) {
            throw new IOException("无效的PDF格式 - 缺少文件头和尾标识");
        }
    }

    // 保存到文件系统
    private static void writeToFile(byte[] data, String outputPath) throws IOException {
        Path path = Paths.get(outputPath);

        // 创建父目录（如果不存在）
        Path parentDir = path.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }

        // 写入文件（覆盖已有文件）
        Files.write(
                path,
                data,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        );
    }

    // 验证保存后的文件
    private static void validateSavedFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("文件保存失败：" + filePath);
        }

        if (file.length() == 0) {
            throw new IOException("保存的文件为空");
        }

        // 简单检查文件头
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] header = new byte[4];
            int read = fis.read(header);
            if (read < 4 || (header[0] != '%' && header[0] != 0x25)) {
                throw new IOException("保存的文件不是有效的PDF");
            }
        }
    }

    /**
     * 便捷方法：生成带时间戳的唯一文件名
     */
    public static String generatePdfFilename(String prefix) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return prefix + "_" + timestamp + ".pdf";
    }
}