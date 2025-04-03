package com.eshop.util.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel读取工具类
 * 支持将Excel数据转换为指定的Java对象
 *
 * @author ldj
 * @date 2024/03/27
 */
public class ExcelReader {

    /**
     * 读取Excel文件并转换为指定类型的对象列表
     *
     * @param filePath Excel文件路径
     * @param clazz    目标类型
     * @param <T>      泛型类型
     * @return 对象列表
     * @throws Exception 异常信息
     */
    public static <T> List<T> readExcel(String filePath, Class<T> clazz) throws Exception {
        List<T> resultList = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook;
            try {
                // 尝试以XLSX格式读取
                workbook = new XSSFWorkbook(fis);
            } catch (org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException e) {
                // 如果是XLS格式，重新打开文件流
                fis.close();
                FileInputStream newFis = new FileInputStream(filePath);
                workbook = new HSSFWorkbook(new POIFSFileSystem(newFis));
                newFis.close();
            }
            
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            
            // 获取所有字段名
            int columnCount = headerRow.getLastCellNum();
            String[] fieldNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null) {
                    fieldNames[i] = convertToFieldName(cell.getStringCellValue());
                }
            }
            
            // 遍历数据行
            int rowCount = sheet.getLastRowNum();
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    T instance = clazz.getDeclaredConstructor().newInstance();
                    
                    // 遍历每一列并设置对象属性
                    for (int j = 0; j < columnCount; j++) {
                        if (fieldNames[j] != null) {
                            Cell cell = row.getCell(j);
                            if (cell != null) {
                                setFieldValue(instance, fieldNames[j], cell);
                            }
                        }
                    }
                    
                    resultList.add(instance);
                }
            }
        }
        
        return resultList;
    }
    
    /**
     * 将Excel表头转换为Java字段名（下划线转驼峰）
     *
     * @param headerName Excel表头名称
     * @return Java字段名
     */
    private static String convertToFieldName(String headerName) {
        if (StringUtils.isEmpty(headerName)) {
            return null;
        }
        
        // 将表头转换为小写
        headerName = headerName.toLowerCase().trim();
        
        // 将下划线格式转换为驼峰格式
        StringBuilder result = new StringBuilder();
        String[] parts = headerName.split("_");
        result.append(parts[0]);
        
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].length() > 0) {
                result.append(Character.toUpperCase(parts[i].charAt(0)))
                      .append(parts[i].substring(1));
            }
        }
        
        return result.toString();
    }
    
    /**
     * 设置对象字段值
     *
     * @param obj       目标对象
     * @param fieldName 字段名
     * @param cell      Excel单元格
     */
    private static void setFieldValue(Object obj, String fieldName, Cell cell) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        
        switch (cell.getCellType()) {
            case STRING:
                try {
                    field.set(obj, cell.getStringCellValue());
                } catch (IllegalArgumentException e) {
                    field.set(obj, Long.valueOf(cell.getStringCellValue()));
                }
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    field.set(obj, cell.getDateCellValue());
                } else {
                    Class<?> fieldType = field.getType();
                    if (fieldType == Long.class || fieldType == long.class) {
                        field.set(obj, (long) cell.getNumericCellValue());
                    } else if (fieldType == Integer.class || fieldType == int.class) {
                        field.set(obj, (int) cell.getNumericCellValue());
                    } else if (fieldType == Double.class || fieldType == double.class) {
                        field.set(obj, cell.getNumericCellValue());
                    } else if (fieldType == Float.class || fieldType == float.class) {
                        field.set(obj, (float) cell.getNumericCellValue());
                    } else if (fieldType == Byte.class || fieldType == byte.class) {
                        field.set(obj, (byte) cell.getNumericCellValue());
                    }
                }
                break;
            case BOOLEAN:
                field.set(obj, cell.getBooleanCellValue());
                break;
            case BLANK:
                field.set(obj, null);
                break;
            default:
                field.set(obj, null);
        }
    }
}