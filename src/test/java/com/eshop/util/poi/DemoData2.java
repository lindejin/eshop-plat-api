package com.eshop.util.poi;


import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData2 {

    @ExcelProperty("中文简称")
    private String cnName;
    @ExcelProperty("英文简称")
    private String enName;
    @ExcelProperty("英文全称")
    private String engName;
    @ExcelProperty("两字母代码")
    private String alpha2;
    @ExcelProperty("三字母代码")
    private String alpha3;
    @ExcelProperty("数字代码")
    private String numeric;
    @ExcelProperty("备注")
    private String remark;
}