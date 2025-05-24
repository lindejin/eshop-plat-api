package com.eshop.order;

import cn.hutool.core.img.ImgUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eshop.entity.order.TbOrderBillPlatform;
import com.eshop.service.order.ITbOrderBillPlatformService;
import com.eshop.util.MurmurHashUtil;
import com.eshop.util.shop.PlatformAppClientUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

@SpringBootTest
public class ApiShopeeLogisticsSyncServiceTest3 {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbOrderBillPlatformService iTbOrderBillPlatformService;

    @Resource
    private OkImageDownloader okImageDownloader;

    @Test
    void contextLoads2() throws Exception {
        String imgUrl = "https://file.vogocm.com:9000/eshop/eshop_img/2025/5/23/vg-250523193018113A007279.jpg";
        Integer catType = 1;
        byte[] imageData = okImageDownloader.downloadImageWithRetry(imgUrl);
        String imgBase64 = Base64.encodeBase64String(imageData);
        String suffix = TikaFileUtil.getFileExtension(imageData);
        if (suffix != null && suffix.startsWith(".")) {
            suffix = suffix.substring(1); // 去掉开头的点（例如 ".jpg" -> "jpg"）
        }
        System.out.println(suffix);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData)) {
            BufferedImage sourceImage = null;
            try {
                sourceImage = ImageIO.read(bis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (Objects.isNull(sourceImage)) {
                throw new RuntimeException("图片转换失败,URL:" + imgUrl);
            }
            //图片宽高
            int height = sourceImage.getHeight();
            int width = sourceImage.getWidth();
            if (catType == 1) {
                int canvasWidth = 1340;
                int canvasHeight = 1785;
                if ((double) width / height == 3.0 / 4.0 && height > canvasHeight && width > canvasWidth) {
                    //宽高 3:4,宽度 >1340,高度>1785
                    sourceImage = ImageUtil.imgCompress(sourceImage, suffix, 1024);
                    height = sourceImage.getHeight();
                    width = sourceImage.getWidth();
                    sourceImage = CanvaUtils.imageConversion(canvasWidth, canvasHeight, sourceImage);
                    height = sourceImage.getHeight();
                    width = sourceImage.getWidth();
                } else {
                    //原图超过200KB压缩
                    sourceImage = ImageUtil.imgCompress(sourceImage, suffix, 200);
                    height = sourceImage.getHeight();
                    width = sourceImage.getWidth();
                    //服装轮播图 5-10张，宽高比例为3:4，宽>1340px，高>1785px，小于2M
                    sourceImage = CanvaUtils.imageConversion(canvasWidth, canvasHeight, sourceImage);
                    height = sourceImage.getHeight();
                    width = sourceImage.getWidth();
                }
            } else {
                //非服装的  宽高比1:1 切大于800px，小于2M
                int canvasWidth = 800;
                if (canvasWidth > width || height != width) {
                    //原图超过1MB压缩
                    sourceImage = ImageUtil.imgCompress(sourceImage, imgUrl.substring(imgUrl.lastIndexOf(".") + 1), 1024);
                    sourceImage = CanvaUtils.imageConversion(canvasWidth, canvasWidth, sourceImage);
                }
            }
            String imgType = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);
//            String imgBase64 = ImageUtil.imgConvertBase64(sourceImage, imgType);
//            try {
//                BufferedImage processedImage = imgCompress(sourceImage, "jpg", 1024); // 调用你的压缩方法
//                if (processedImage != null) {
//                    File outputFile = new File("output.jpg");
//                    ImageIO.write(processedImage, "jpg", outputFile);
//                    System.out.println("图片已保存至: " + outputFile.getAbsolutePath());
//                } else {
//                    System.out.println("处理后的图片为空");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(imgBase64);
            // 2. 直接保存为文件
            String ss = null;
            try {
//                byte[] imgArr = ImageService.processImage(imageData, suffix);
//                InputStream inputStreamForRead = new ByteArrayInputStream(imgArr);
//                BufferedImage image = ImgUtil.read(inputStreamForRead);
                ss = System.currentTimeMillis()+"1";
                saveImageToFile(sourceImage, suffix, "/output/images/result"+ss+"."+suffix);
                ss = ss+"2";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                imageData = TemuImageService.processImage(imageData,suffix);
                InputStream inputStreamForRead22 = new ByteArrayInputStream(imageData);
                BufferedImage image22 = ImgUtil.read(inputStreamForRead22);
                saveImageToFile(image22, suffix, "/output/images/result"+ss+"."+suffix);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * 保存图片到文件
     * @param image      要保存的图片
     * @param formatName 图片格式（如 "jpg", "png"）
     * @param outputPath 输出路径（如 "/tmp/output.jpg"）
     */
    public  void saveImageToFile( BufferedImage image,
                                        String formatName,
                                        String outputPath) {
        if (image == null || formatName == null || outputPath == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        // 处理JPEG兼容性问题（强制移除透明通道）
        if ("jpg".equalsIgnoreCase(formatName)) {
            formatName = "jpeg";
            if (image.getTransparency() != Transparency.OPAQUE) {
                BufferedImage rgbImage = new BufferedImage(
                        image.getWidth(),
                        image.getHeight(),
                        BufferedImage.TYPE_INT_RGB
                );
                Graphics2D g = rgbImage.createGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
                image = rgbImage;
            }
        }

        File outputFile = new File(outputPath);
        try {
            // 自动创建父目录
            Files.createDirectories(outputFile.getParentFile().toPath());
            // 保存图片
            if (!ImageIO.write(image, formatName, outputFile)) {
                throw new IllegalArgumentException("不支持的图片格式: " + formatName);
            }
            System.out.println("图片已保存至: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("保存失败: " + e.getMessage(), e);
        }
    }
    @Test
    void contextLoads() throws Exception {
        LambdaQueryWrapper<TbOrderBillPlatform> lqWrapper = Wrappers.<TbOrderBillPlatform>lambdaQuery();
        lqWrapper.eq(TbOrderBillPlatform::getOrderNo, "250519AQ62BNVJ");
        List<TbOrderBillPlatform> list = iTbOrderBillPlatformService.list(lqWrapper);

        TbOrderBillPlatform tbOrderBillPlatform001 = list.get(0);

        String respBody001 = tbOrderBillPlatform001.getResponseBody();
        for (TbOrderBillPlatform tbOrderBillPlatform1 : list) {
            if (tbOrderBillPlatform1.getBillType().equals(tbOrderBillPlatform001.getBillType())) {
                String responseBody = tbOrderBillPlatform1.getResponseBody();
                if (!compareHashesBody(respBody001, responseBody)) {
                    printJsonDiff(respBody001, responseBody);
                    respBody001 = responseBody;
                }
            }

        }

        System.out.println("GG");
        TbOrderBillPlatform tbOrderBillPlatform002 = list.get(1);
        String respBody002 = tbOrderBillPlatform002.getResponseBody();
        for (TbOrderBillPlatform temp : list) {
            if (temp.getBillType().equals(tbOrderBillPlatform002.getBillType())) {
                String responseBody = temp.getResponseBody();
                if (!compareHashesBody(respBody002, responseBody)) {
                    printJsonDiff(respBody002, responseBody);
                    respBody002 = responseBody;
                }
            }
        }
    }

    /**
     * 哈希值比对工具方法
     *
     * @return true-数据相同 false-数据不同或空值
     */
    public boolean compareHashesBody(String respBody, String responseBody) {
        respBody = deleteRequestId(respBody);
        responseBody = deleteRequestId(responseBody);

        String hash128Temp = MurmurHashUtil.murmur3_128HashString(respBody);
        String hash128 = MurmurHashUtil.murmur3_128HashString(responseBody);

        if (hash128Temp == null || hash128 == null) {
            return false;
        }
        return StringUtils.equals(hash128Temp, hash128);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 删除 JSON 字符串中的 RequestId 键
     */
    private static String deleteRequestId(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return jsonStr;
        }

        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            if (rootNode.isObject()) {
                ObjectNode objectNode = (ObjectNode) rootNode;
                objectNode.remove("requestId"); // 删除键
                objectNode.remove("request_id"); // 删除键
                objectNode.remove("pickup_done_time"); // 删除键
                objectNode.remove("order_status"); // 删除键
                objectNode.remove("update_time"); // 删除键
                objectNode.remove("package_list"); // 删除键


                return objectMapper.writeValueAsString(objectNode);
            }
            return jsonStr;
        } catch (Exception e) {
            // JSON 解析失败时返回原始字符串（或根据需求处理）
            return jsonStr;
        }
    }


    /**
     * 找出两个 JSON 字符串的差异（忽略 RequestId 后）
     */
    public static void printJsonDiff(String json1, String json2) {
        try {
            String processed1 = deleteRequestId(json1);
            String processed2 = deleteRequestId(json2);

            JsonNode node1 = objectMapper.readTree(processed1);
            JsonNode node2 = objectMapper.readTree(processed2);

            List<String> differences = new ArrayList<>();
            findDifferences("", node1, node2, differences);

            if (differences.isEmpty()) {
                System.out.println("✅ JSON 内容完全一致");
            } else {
                System.out.println("❌ 发现 " + differences.size() + " 处差异：");
                differences.forEach(System.out::println);
            }

        } catch (Exception e) {
            System.err.println("比较失败: " + e.getMessage());
        }
    }

    /**
     * 递归比较 JSON 节点
     */
    private static void findDifferences(String path, JsonNode node1, JsonNode node2, List<String> differences) {
        // 类型不同直接记录差异
        if (node1.getNodeType() != node2.getNodeType()) {
            differences.add(String.format("路径 [%s] 类型不同: %s vs %s",
                    path, node1.getNodeType(), node2.getNodeType()));
            return;
        }

        switch (node1.getNodeType()) {
            case OBJECT:
                Iterator<Map.Entry<String, JsonNode>> fields1 = node1.fields();
                while (fields1.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields1.next();
                    String field = entry.getKey();
                    JsonNode value1 = entry.getValue();
                    JsonNode value2 = node2.get(field);

                    String newPath = path.isEmpty() ? field : path + "." + field;

                    if (value2 == null) {
                        differences.add("路径 [" + newPath + "] 字段在第二个JSON中缺失");
                    } else {
                        findDifferences(newPath, value1, value2, differences);
                    }
                }

                // 检查第二个JSON是否有额外字段
                Iterator<Map.Entry<String, JsonNode>> fields2 = node2.fields();
                while (fields2.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields2.next();
                    if (!node1.has(entry.getKey())) {
                        differences.add("路径 [" + path + "." + entry.getKey() + "] 字段在第一个JSON中缺失");
                    }
                }
                break;

            case ARRAY:
                ArrayNode array1 = (ArrayNode) node1;
                ArrayNode array2 = (ArrayNode) node2;

                if (array1.size() != array2.size()) {
                    differences.add(String.format("路径 [%s] 数组长度不同: %d vs %d",
                            path, array1.size(), array2.size()));
                    return;
                }

                for (int i = 0; i < array1.size(); i++) {
                    findDifferences(path + "[" + i + "]", array1.get(i), array2.get(i), differences);
                }
                break;

            case STRING:
            case NUMBER:
            case BOOLEAN:
                if (!node1.equals(node2)) {
                    differences.add(String.format("路径 [%s] 值不同: %s vs %s",
                            path, node1.asText(), node2.asText()));
                }
                break;

            default:
                // 处理其他类型（如 null）
                if (!node1.equals(node2)) {
                    differences.add(String.format("路径 [%s] 值不同: %s vs %s",
                            path, node1, node2));
                }
        }
    }
}
