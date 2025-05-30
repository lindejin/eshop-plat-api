package com.eshop.api;

import eu.medsea.mimeutil.MimeType;
import eu.medsea.mimeutil.MimeUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class MimeDetector {
    static {
        // 必须加载 MIME 类型数据库（默认包含常见类型）
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.ExtensionMimeDetector");
        MimeUtil
                .registerMimeDetector(System.getProperty("os.name").startsWith(
                        "Windows") ? "eu.medsea.mimeutil.detector.WindowsRegistryMimeDetector"
                        : "eu.medsea.mimeutil.detector.OpendesktopMimeDetector");
    }

    // 根据二进制数据检测 MIME 类型
    public static Collection<?> detectMimeType(byte[] data) {
        return MimeUtil.getMimeTypes(data);// 默认返回未知类型
    }

    public static MimeType getMimeType(byte[] data){
        Collection<?> objects = detectMimeType(data);

        MimeType m = objects.toArray(new MimeType[0])[0];

        System.out.println("File Type: " + m.getMediaType());
        System.out.println("File Extension: " + m.getSubType());
        return m;
    }

    // 根据输入流检测（自动关闭流）
    public static Collection<?> detectMimeType(InputStream inputStream) throws IOException {
        return MimeUtil.getMimeTypes(inputStream);
    }

    // 根据 MIME 类型获取扩展名（需手动映射）
    public static String getExtension(String mimeType) {
        return MimeUtil.getExtension(mimeType);
    }
}
