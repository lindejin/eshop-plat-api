package com.eshop.util.excel;

import com.eshop.entity.file.TbImg;
import com.eshop.entity.order.TbOrderProducts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * Excel读取工具类测试
 *
 * @author ldj
 * @date 2024/03/27
 */
public class ExcelReaderTest {

    @Test
    public void testReadExcelToTbImg() throws Exception {
        String filePath = "F:\\20250401.xls"; // 测试时替换为实际的Excel文件路径
        
        // 调用ExcelReader读取Excel文件并转换为TbImg对象列表
        List<TbImg> imgList = ExcelReader.readExcel(filePath, TbImg.class);
        
        // 验证结果不为空
        Assertions.assertNotNull(imgList);
        Assertions.assertFalse(imgList.isEmpty());
        
        // 验证第一个对象的属性（根据实际数据调整断言）
        TbImg firstImg = imgList.get(0);
        Assertions.assertNotNull(firstImg);
        
        // 打印读取到的数据，方便调试
        System.out.println("读取到的数据条数: " + imgList.size());
        System.out.println("第一条数据: " + firstImg);
    }



    @Test
    public void testReadExcelToOp() throws Exception {
        String filePath = "F:\\op.xls"; // 测试时替换为实际的Excel文件路径

        // 调用ExcelReader读取Excel文件并转换为TbImg对象列表
        List<TbOrderProducts> imgList = ExcelReader.readExcel(filePath, TbOrderProducts.class);

        // 验证结果不为空
        Assertions.assertNotNull(imgList);
        Assertions.assertFalse(imgList.isEmpty());

        // 验证第一个对象的属性（根据实际数据调整断言）
        TbOrderProducts firstImg = imgList.get(0);
        Assertions.assertNotNull(firstImg);

        // 打印读取到的数据，方便调试
        System.out.println("读取到的数据条数: " + imgList.size());
        System.out.println("第一条数据: " + firstImg);
        System.out.println();
    }
}