package com.eshop.code;

import com.eshop.util.generator.TemuVOGenerator;

public class TemuVOGenerator2Test {
    public static void main(String[] args) {
        //使用技巧
        //进去页面把api接口 拷贝出来 保存到json文件 一键生成json
        try {
            // 设置输入JSON文件路径
            String jsonFilePath = "F:\\json\\purchaseorderv2Get.json";
            // 设置生成的Java文件输出路径
            String outputPath = "src/test/java/com/eshop/code/vo/po2/Temu2PurchaseOrderV2DTO.java";
            // 设置包名
            String packageName = "com.eshop.code.vo.po2";
            // 设置类名
            String className = "Temu2PurchaseOrderV2DTO";

            String rootName = "Temu2PurchaseOrderV2";

            // 调用生成器生成VO类
            TemuVOGenerator.generateDTO(jsonFilePath, outputPath, packageName, className,rootName);
            System.out.println("VO类生成成功：" + outputPath);
        } catch (Exception e) {
            System.err.println("生成VO类时发生错误：" + e.getMessage());
            e.printStackTrace();
        }

        try {
            // 设置输入JSON文件路径
            // purchaseorderv2 -> Purchase Order (PO) V2：采购订单
            String jsonFilePath = "F:\\json\\purchaseorderv2Get.json";
            // 设置生成的Java文件输出路径
            String outputPath = "src/test/java/com/eshop/code/vo/po2/Temu2PurchaseOrderV2VO.java";
            // 设置包名
            String packageName = "com.eshop.code.vo.po2";
            // 设置类名
            String className = "Temu2PurchaseOrderV2VO";

            String rootName = "Temu2PurchaseOrderV2";
            // 调用生成器生成VO类
            TemuVOGenerator.generateVO(jsonFilePath, outputPath, packageName, className,rootName);
            System.out.println("VO类生成成功：" + outputPath);
        } catch (Exception e) {
            System.err.println("生成VO类时发生错误：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
