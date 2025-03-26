package com.eshop.code;

import com.eshop.util.generator.DhGateVOGenerator;

public class DhGateVOGeneratorTest {
    public static void main(String[] args) {
        //使用技巧
        //进去页面把api接口 拷贝出来 保存到json文件 一键生成json
        //https://open.shopee.com/documents/v2/v2.order.get_order_detail?module=94&type=1
        try {
            // 设置输入JSON文件路径
            String jsonFilePath = "F:\\dhOrderList.json";
            // 设置生成的Java文件输出路径
            String outputPath = "src/test/java/com/eshop/code/vo/ol/DhOrderListRespVO.java";
            // 设置包名
            String packageName = "com.eshop.code.vo.ol";
            // 设置类名
            String className = "DhOrderListRespVO";

            // 调用生成器生成VO类
            DhGateVOGenerator.generateVO(jsonFilePath, outputPath, packageName, className);
            System.out.println("VO类生成成功：" + outputPath);
        } catch (Exception e) {
            System.err.println("生成VO类时发生错误：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
