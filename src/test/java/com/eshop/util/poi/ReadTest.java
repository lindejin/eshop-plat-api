package com.eshop.util.poi;

 import cn.idev.excel.FastExcel;
 import cn.idev.excel.read.listener.PageReadListener;
 import com.alibaba.fastjson.JSON;
 import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadTest {
     public static void main(String[] args) {
//         String fileName = "D:\\temp\\货币 - 副本.xlsx"; // Replace with actual path
//         // Read Excel file
//         FastExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//             for (DemoData demoData : dataList) {
//                 log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//             }
//         })).sheet().doRead();


//         String fileName = "D:\\temp\\国家代码.xlsx"; // Replace with actual path
//         // Read Excel file
//         FastExcel.read(fileName, DemoData2.class, new PageReadListener<DemoData2>(dataList -> {
//             for (DemoData2 demoData : dataList) {
//                 log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//             }
//         })).sheet().doRead();

         String fileName = "D:\\temp\\货币代码.xlsx"; // Replace with actual path
         // Read Excel file
         FastExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
             for (DemoData demoData : dataList) {
                 log.info("读取到一条数据{}", JSON.toJSONString(demoData));
             }
         })).sheet().doRead();
     }
 }