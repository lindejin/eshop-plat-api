package com.eshop.order;


import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.URLUtil;
import com.eshop.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Objects;

/**
 * 图片工具类
 *
 * @author sheng
 * @date 2022-05-18 11:03
 **/
@Slf4j
public class ImageUtil {

    /**
     *图片url转为MultipartFile
     *
     * @param url
     * @param fileName
     * @return
     * @throws Exception
     */
    public static MultipartFile urlToMultipartFile(String url, String fileName) throws Exception {
        File file = null;
        MultipartFile multipartFile = null;
        try {
            HttpURLConnection httpUrl = (HttpURLConnection) new URL(url).openConnection();
            httpUrl.connect();
            file = inputStreamToFile(httpUrl.getInputStream(), fileName);
            multipartFile = fileToMultipartFile(file);
            httpUrl.disconnect();
        } catch (Exception e) {
            log.error("url:{} 同步失败",url);
//            e.printStackTrace();
        }
        return multipartFile;
    }

    /**
     * File 转 MultipartFile
     * @param file
     * @return
     */
    public static CommonsMultipartFile fileToMultipartFile(File file) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item=factory.createItem(file.getName(),"text/plain",true,file.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonsMultipartFile(item);
    }

    /**
     * InputStream 转 File
     *
     * @param ins
     * @param fileName
     * @return
     * @throws Exception
     */
    public static File inputStreamToFile(InputStream ins, String fileName) throws Exception {
        File file = new File(System.getProperty("java.io.tmpdir") + File.separator + fileName);
        OutputStream os = Files.newOutputStream(file.toPath());
        int bytesRead;
        int len = 8192;
        byte[] buffer = new byte[len];
        while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        return file;
    }

    /**
     * 图片比例压缩(外网下载)
     *
     * @param url   URL路径
     * @param type  压缩后图片类型
     * @param scale 缩放比例  范围0-1
     * @author sheng
     * @date 2022-05-19 18:02
     */
    public static File internetDownloadImg(String url, String type, Float scale) {
        InputStream inputStream = null;
        try {
            URL urlFile = new URL(url);
            log.error("图片Url: " + url);
            inputStream = urlFile.openStream();
            return imgCompress(inputStream, type, scale);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("未获取到对应图片URL(" + url + ")" + ExceptionUtils.exToString(e));
            return null;
        }
    }

    /**
     * 图片比例压缩(内网)
     *
     * @param url   URL路径
     * @param type  压缩后图片类型
     * @param scale 缩放比例  范围0-1
     * @author sheng
     * @date 2022-05-19 18:02
     */
//    public static File localReadImg(String url, String type, Float scale) {
//        if (StringUtils.isBlank(url)) {
//            return null;
//        }
//        InputStream inputStream = null;
//        //获取Bean
//        MinioFileUtils bean = BeanFactoryStaticUtil.getBean(MinioFileUtils.class);
//        try {
//            inputStream = bean.downloadFileToUrl(url);
//            if (Objects.isNull(inputStream)) {
//                log.error("未获取到对应图片URL(" + url + ")");
//                return null;
//            }
//            return ImageUtil.imgCompress(inputStream, type, scale);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("图片获取异常URL(" + url + "): " + ExceptionUtils.exToString(e));
//            return null;
//        }
//    }

    /**
     * 压缩图片
     *
     * @param inputStream 输入流
     * @param type        图片格式
     * @param scale       缩小比例
     * @return java.io.File
     * @author sheng
     * @date 2023-03-31 10:30
     */
    public static File imgCompress(InputStream inputStream, String type, Float scale) {
        File file = null;
        FileOutputStream outputStream = null;
        try {
            file = File.createTempFile("image", type);
            outputStream = new FileOutputStream(file);
            //图片压缩
            ImgUtil.scale(inputStream, outputStream, scale);
            byte[] bytes = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(bytes, 0, 1024)) != -1) {
                outputStream.write(bytes, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    /**
     * 压缩图片
     *
     * @param inputStream 输入流
     * @param type        图片格式
     * @param width       缩小比例
     * @Param height      缩小比例
     * @return java.io.File
     * @author sheng
     * @date 2023-03-31 10:30
     */
    public static File imgCompress(InputStream inputStream, String type, Integer width, Integer height) {
        File file = null;
        FileOutputStream outputStream = null;
        try {
            file = File.createTempFile("image", type);
            outputStream = new FileOutputStream(file);
            //图片压缩
//            ImgUtil.scale(inputStream, outputStream, width, height, Color.WHITE);
            ImgUtil.scale(inputStream, outputStream, width, height, Color.WHITE);
            byte[] bytes = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(bytes, 0, 1024)) != -1) {
                outputStream.write(bytes, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 从网上下载图片
     *
     * @param url
     * @return java.io.File
     * @author sheng
     * @date 2022-05-19 18:00
     */
    public static File downloadImg(String url) {
        url = URLUtil.normalize(url);
        File file = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            String urlPath = URLUtil.getPath(url);
            file = new File(urlPath.substring(urlPath.lastIndexOf("/")));
            URL urlFile = new URL(url);
            inputStream = urlFile.openStream();
            fos = new FileOutputStream(file);

            byte[] bytes = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(bytes, 0, 1024)) != -1) {
                fos.write(bytes, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 通过RestTemplate 根据Url下载图片
     *
     * @param url  图片Url地址
     * @return byte[]
     * @author sheng
     * @date 2023-11-29 16:20
     */
//    public static byte[] downloadImgRestTemplateByUrl(String url) {
//        String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("user-agent", userAgent);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        //获取Bean
//        RestTemplate restTemplate = BeanFactoryStaticUtil.getBean(RestTemplate.class);
//        ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
//        return result.getBody();
//    }

    /**
     * 读取本地图片
     *
     * @param url
     * @return java.io.File
     * @author sheng
     * @date 2022-05-19 18:00
     */
    public static File readImg(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        File file = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            file = File.createTempFile("image", "jpg");
            inputStream = new FileInputStream(new File(url));
            fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(bytes, 0, 1024)) != -1) {
                fos.write(bytes, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * base64转换为图片
     *
     * @param base64
     * @return java.io.File
     * @author sheng
     * @date 2022-05-19 18:00
     */
//    public static File base64ToImg(String base64) {
//        if (StringUtils.isBlank(base64)) {
//            return null;
//        }
//        File tempFile = null;
//        FileOutputStream fos = null;
//        BufferedOutputStream bos = null;
//        //图片格式
//        String fileName = getImgNameByImgUrl(base64);
//        // 解密
//        Base64.Decoder decoder = Base64.getDecoder();
//        // 去掉base64前缀
//        base64 = base64.substring(base64.indexOf(",", 1) + 1);
//        byte[] bytes = decoder.decode(base64);
//        int length = bytes.length;
//        // 处理数据
//        for (int i = 0; i < length; ++i) {
//            if (bytes[i] < 0) {
//                bytes[i] += 256;
//            }
//        }
//        try {
//            tempFile = new File(fileName);
//            fos = new FileOutputStream(tempFile);
//            bos = new BufferedOutputStream(fos);
//            bos.write(bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (bos != null) {
//                try {
//                    bos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return tempFile;
//    }

    /**
     * 根据图片URl获取图片名称
     *
     * @param imgUrl  图片Url
     * @return java.lang.String
     * @author sheng
     * @date 2023-05-26 16:21
     */
//    public static String getImgNameByImgUrl(String imgUrl) {
//        if (PatternUtil.isBase64Img(imgUrl)) {
//            return MD5Util.md5(imgUrl) + "." + imgUrl.substring(imgUrl.indexOf("/") + 1, imgUrl.indexOf(";"));
//        } else {
//            imgUrl = URLUtil.getPath(imgUrl);
//            return imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
//        }
//    }

    /**
     * 输入流转换为file
     *
     * @param inputStream
     * @param fileName
     * @return java.io.File
     * @author sheng
     * @date 2023-11-02 16:14
     */
//    public static File inputStreamConvertFile(InputStream inputStream, String fileName) {
//        File file =new File(getImgNameByImgUrl(fileName));
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                fos.write(buffer, 0, bytesRead);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("文件名称: " + file.getName());
//        return file;
//    }
    /**
     * 下载图片
     *
     * @param filePath   URL路径
     * @author sheng
     * @date 2022-05-19 18:02
     */
    public static byte[] downloadImgConvertToPNG(String filePath) throws IOException {
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(filePath);
            BufferedImage image = ImageIO.read(inputStream);
            if (Objects.isNull(image)) {
                throw new RuntimeException("图片读取失败,该图片类型不是PNG!!!");
            }
            ImageIO.write(image, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void cutScale(File input, File output, double scaleWidth, double scaleHeight) throws IOException {
        BufferedImage image = ImageIO.read(input);
        int width = image.getWidth();
        int height = image.getHeight();
        //计算剪裁后的宽度和高度
        int newwidth = width;
        int newHeight = (int) Math.round(scaleHeight / scaleWidth * width);
        if (newHeight > height) {
            newwidth = (int) Math.round(scaleWidth / scaleHeight * height);
            newHeight = height;
        }
        //计算剪裁的起始坐标
        int x = (width - newwidth) / 2;
        int y = (height - newHeight) / 2;
        //剪裁图片
        BufferedImage cropped = image.getSubimage(x, y, newwidth, newHeight);
        ImageIO.write(cropped, "jpg", output);
    }

    public static void cutPixel(File input, File output, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(input);
        // 调整图片大小
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        ImageIO.write(resized, "jpg", output);
    }

    public static BufferedImage cutPixel(InputStream inputStream, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        // 调整图片大小
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();

        return resized;
    }

    public static BufferedImage cutPixel(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream cannot be null");
        }
        BufferedImage originalImage = ImageIO.read(inputStream);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        int x1, x2, y1, y2;
        x1 = 225;
        x2 = width - 225;
        y1 = 0;
        y2 = height - 200;

        BufferedImage croppedImage = originalImage.getSubimage(x1, y1, x2 - x1, y2 - y1);
        return croppedImage;
    }

    /**
     * 图片转换Base64
     *
     * @param inputStream 图片输入流
     * @return java.lang.String
     * @author sheng
     * @date 2024-11-01 13:58
     */
    public static String imgConvertBase64(InputStream inputStream) {
        byte[] fileContent = null;
        try {
            fileContent = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    /**
     * 图片转换Base64 2
     */
    public static String imgConvertBase64(byte[] fileContent ) {
        return Base64.getEncoder().encodeToString(fileContent);
    }

    /**
     * 图片转换Base64
     *
     * @param image 图片
     * @param formatName 图片名称
     * @return java.lang.String
     * @author sheng
     * @date 2024-11-01 13:58
     */
    public static String imgConvertBase64(BufferedImage image, String formatName) {
        String base64 = null;
        if ("jpg".equalsIgnoreCase(formatName)) {
            formatName = "jpeg";
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, formatName, baos);
            byte[] imageBytes = baos.toByteArray();
            Base64.Encoder encoder = Base64.getEncoder();
            base64 = encoder.encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }



    /**
     * 图片压缩
     *
     * @param image   图片
     * @param imgType 图片类型
     * @param size    大小限制 单位KB
     * @return java.awt.image.BufferedImage
     * @author sheng
     * @date 2024-12-19 16:28
     */
    public static BufferedImage imgCompress(BufferedImage image, String imgType, int size) {
        if (Objects.isNull(image)) {
            return null;
        }
        //int size = 1024 * 1024;
        size *= 1024;
        try {
            File file = File.createTempFile("img", ".tmp");
            if ("jpg".equalsIgnoreCase(imgType)) {
                imgType = "jpeg";
            }
            ImageIO.write(image, imgType, file);
            // 获取文件大小
            long fileSizeInBytes = file.length();
            if (fileSizeInBytes > size) {
                //图片压缩
                image = ImgUtil.toBufferedImage(ImgUtil.scale(image, 0.7F));
            }
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
//    /**
//     * 判断是否是JPG或者PNG图片
//     *
//     * @author sheng
//     * @return java.lang.Boolean
//     * @date 2024-12-26 11:53
//     */
//    public static Boolean isPngOrJpgImgType(byte[] header) {
//        if (header[0] == (byte) 0x89 && header[1] == (byte) 0x50 && header[2] == (byte) 0x4E && header[3] == (byte) 0x47) {
//            return true;
//        } else if (header[0] == (byte) 0xFF && header[1] == (byte) 0xD8) {
//            return true;
//        }
//        //} else if (header[0] == (byte) 0x52 && header[1] == (byte) 0x49 && header[2] == (byte) 0x46 && header[3] == (byte) 0x46) {
//        //    return false;
//        //} else {
//        //    return "Unknown";
//        //}
//        return false;
//    }

//    public static Boolean isPngOrJpgImgType(InputStream inputStream) {
//        byte[] header = null;
//        try {
//            header = IOUtils.toByteArray(inputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (Objects.isNull(header)) {
//            return false;
//        }
//        if (header[0] == (byte) 0x89 && header[1] == (byte) 0x50 && header[2] == (byte) 0x4E && header[3] == (byte) 0x47) {
//            return true;
//        } else if (header[0] == (byte) 0xFF && header[1] == (byte) 0xD8) {
//            return true;
//        }
//        //} else if (header[0] == (byte) 0x52 && header[1] == (byte) 0x49 && header[2] == (byte) 0x46 && header[3] == (byte) 0x46) {
//        //    return false;
//        //} else {
//        //    return "Unknown";
//        //}
//        return false;
//    }
    public static void main(String[] args) throws IOException {
        File input = new File("\\\\192.168.10.243\\美工部\\雪燕耳素材\\IMG_3753.JPG");
        // 保存剪裁后的图片
        File output = new File("D:\\output.jpg");
        cutPixel(input, output, 750, 1000);
    }
}
