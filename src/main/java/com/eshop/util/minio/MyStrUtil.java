package com.eshop.util.minio;

import cn.hutool.core.util.ObjectUtil;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 字符串相关
 *
 * @author sheng
 * @date 2022-05-19 18:22
 **/
public final class MyStrUtil {
    /**
     * 若对象为空,返回空字符串
     *
     * @param o
     * @return java.lang.String
     * @author sheng
     * @date 2022-05-20 9:06
     */
    public static String setStr(Object o) {
        return Optional.ofNullable(o).isPresent() ? String.valueOf(o) : "";
    }

    /**
     * 判断字符串支付集
     *
     * @param str    字符串
     * @param encode 字符编码
     * @return boolean
     * @author sheng
     * @date 2022-05-21 10:52
     */
    public static boolean isEncoding(String str, String encode) {
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 字符串转换为SQL  in需要的格式
     *
     * @param str 字符串
     * @return String
     * @author sheng
     * @date 2022-05-21 10:52
     */
    public static String strToSQLInData(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("'").append(str.replace(",", "','")).append("'");
        return builder.toString();
    }
    /**
     * 字符串转换为List
     *
     * @param str
     * @author sheng
     * @return java.util.List<java.lang.Long>
     * @date 2022-05-30 19:04
     */
    public static List<Long> strToList(String str) {
        if (str == null) {
            return null;
        }
        List<String> strings = Arrays.asList(str.split(","));
        return strings.stream().map(e->Long.valueOf(e)).collect(Collectors.toList());
    }

    /**
     * 解析详情页，返回要添加的图片索引
     * @param inputString
     * @param regex
     * @return
     */
    public static List<Integer> extractPictureNumbers(String inputString, String regex) {
        List<Integer> numbers = new ArrayList<>();
        // Pattern pattern = Pattern.compile("\\$\\{picture-(\\d+)}");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            String numberString = matcher.group(1);
            int number = Integer.parseInt(numberString);
            numbers.add(number);
        }

        return numbers;
    }

    // 封装要替换的 img标签的string 信息
    public static String generateImgTag(String imageUrl) {
        // 获取图片大小
        Dimension imageSize = getImageSize(imageUrl);
        int width = imageSize.width;
        int height = imageSize.height;
        String[] parts = imageUrl.split("/");
        String fileName = parts[parts.length - 1].substring(0, parts[parts.length - 1].lastIndexOf("."));
        // 生成 <img> 标签字符串
        String imgTag = String.format("<img src=\"%s\" width=\"%dpx\" height=\"%dpx\" title=\"%s\" align=\"center\" alt=\"%s\" />",
                imageUrl, width, height, fileName, fileName);
        return imgTag;
    }

    public static String generateSimpleImgTag(String imageUrl) {
        // 获取图片大小
        Dimension imageSize = getImageSize(imageUrl);
        int width = imageSize.width;
        int height = imageSize.height;
        String[] parts = imageUrl.split("/");
        String fileName = parts[parts.length - 1].substring(0, parts[parts.length - 1].lastIndexOf("."));
        // 生成 <img> 标签字符串
        String imgTag = String.format("<img src=\"%s\" width=\"%d\" height=\"%d\"/>",
                imageUrl, width, height, fileName, fileName);
        return imgTag;
    }

    private static Dimension getImageSize(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(url.openStream());
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(imageInputStream);
            if (!imageReaders.hasNext()) {
                throw new IOException("No image reader found");
            }

            ImageReader imageReader = imageReaders.next();
            imageReader.setInput(imageInputStream);
            int width = imageReader.getWidth(0);
            int height = imageReader.getHeight(0);

            imageInputStream.close();

            return new Dimension(width, height);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
            return new Dimension(600, 600);
        }
    }


    public static String replaceStr(String textStr, String oldStr, String newStr) {
        if (ObjectUtil.isNotEmpty(textStr)
                && ObjectUtil.isNotEmpty(oldStr)
                && ObjectUtil.isNotEmpty(newStr)) {
            return textStr.replaceAll(Pattern.quote(oldStr), newStr);
        }
        return textStr;
    };

    /**
     * 替换字符串中<img>标签的src属性值为指定的新URL。
     *
     * @param input       待替换的字符串
     * @param targetUrl   目标URL，即要被替换的URL
     * @param replacement 替换成的新URL
     * @return 替换后的字符串
     */
    public static String replaceImgSrc(String input, String targetUrl, String replacement) {
        // 构建正则表达式
//        String regex = "(<img\\s+[^>]*?src\\s*=\\s*['\"]?)" + Pattern.quote(targetUrl) + "([^>]*?>)";
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(input);
//
//        // 执行替换
//        StringBuffer result = new StringBuffer();
//        while (matcher.find()) {
//            matcher.appendReplacement(result, matcher.group(1) + replacement + matcher.group(2));
//        }
//        matcher.appendTail(result);
//        return result.toString();

        // 构建正则表达式匹配 <img> 标签的 src 属性值
        String regex = "(<img\\s+[^>]*?src\\s*=\\s*\")" + Pattern.quote(targetUrl) + "(\"[^>]*?>)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        // 执行替换
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + Matcher.quoteReplacement(replacement) + matcher.group(2));
        }
        matcher.appendTail(result);
        return result.toString();
    }


    /**
     * 提取字符串中所有 <img> 标签的 src 属性值
     *
     * @param input 待提取的字符串
     * @return src 属性值的列表
     */
    public static List<String> extractImgSrc(String input) {
        List<String> srcList = new ArrayList<>();
        String regex = "<img\\s+[^>]*src\\s*=\\s*\"([^\"]+)\"[^>]*>";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            srcList.add(matcher.group(1));
        }
        return srcList;
    }

    public static void main(String[] args) {
        String imageUrl = "https://test.vogocm.com:9010/eshop/eshop_img/2024/5/22/20240522114505A002.png";
        // todo 这里将imgageUrl 加水印得到新的url 用新的url 来处理
        String imgTag = MyStrUtil.generateImgTag(imageUrl);



        String strText = "<p>\\n\\t123\\n</p>\\n<p>\\n\\t#{picture-1}\\n</p>\\n<p>\\n\\t321\\n</p>";

        String replaceStr = MyStrUtil.replaceStr(strText, "#{picture-1}" , imgTag);
        System.out.println("replaceStr = " + replaceStr);
        System.out.println(replaceStr);
    }

    public static String replaceImageSuffix(String imageUrl, String newSuffix) {
        if (imageUrl == null || newSuffix == null) {
            throw new IllegalArgumentException("URL and suffix must not be null.");
        }

        int lastDotIndex = imageUrl.lastIndexOf('.');
        if (lastDotIndex == -1) {
            throw new IllegalArgumentException("The URL does not contain a valid file suffix.");
        }

        // Construct the new URL with the new suffix
        String newUrl = imageUrl.substring(0, lastDotIndex + 1) + newSuffix;

        return newUrl;
    }
}
