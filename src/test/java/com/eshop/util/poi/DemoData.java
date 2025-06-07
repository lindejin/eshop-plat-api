package com.eshop.util.poi;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    @ExcelProperty("ENTITY")
    private String entity;
    @ExcelProperty("Currency")
    private String currency;
    @ExcelProperty("Alphabetic Code")
    private String alphabeticCode;
    @ExcelProperty("Numeric Code")
    private String numericCode;
    @ExcelProperty("Minor unit")
    private String minor;
}
