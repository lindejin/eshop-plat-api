package com.eshop.util.generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemuVOGenerator {

    private static final String TEMPLATE_PATH = "/templates/shopee_order_detail_template.btl";

    private static HashMap<String,String> objMap = new HashMap<>();
    public static void generateDTO(String jsonFilePath, String outputPath, String packageName, String className,String rootName) throws Exception {
        // 读取JSON文件
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject jsonObject = JSON.parseObject(jsonContent);
        JSONObject resultJson = jsonObject.getJSONObject("result");
        JSONObject interfaceDocumentJson = resultJson.getJSONObject("interfaceDocument");
        JSONArray requestParamJson = interfaceDocumentJson.getJSONArray("requestParam");

        // 准备模板数据
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package_name", packageName);
        templateData.put("class_name", className);

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, Object>> innerClasses = new ArrayList<>();

        // 解析response_params
        for (int i = 0; i < requestParamJson.size(); i++) {
            JSONObject param = requestParamJson.getJSONObject(i);
            processParam(rootName,className,"",param, fields, innerClasses, "");
        }

        templateData.put("fields", fields);
        templateData.put("inner_classes", innerClasses);

        // 初始化Beetl模板引擎
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

        // 获取模板并渲染
        Template template = gt.getTemplate(TEMPLATE_PATH);
        template.binding(templateData);

        // 确保输出目录存在
        File outputDir = new File(outputPath).getParentFile();
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // 写入生成的代码
        try (FileWriter writer = new FileWriter(outputPath)) {
            template.renderTo(writer);
        }
    }
    public static void generateVO(String jsonFilePath, String outputPath, String packageName, String className,String rootName) throws Exception {
        // 读取JSON文件
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject jsonObject = JSON.parseObject(jsonContent);
        JSONObject resultJson = jsonObject.getJSONObject("result");
        JSONObject interfaceDocumentJson = resultJson.getJSONObject("interfaceDocument");
        JSONArray requestParamJson = interfaceDocumentJson.getJSONArray("responseParam");

        // 准备模板数据
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package_name", packageName);
        templateData.put("class_name", className);

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, Object>> innerClasses = new ArrayList<>();

        // 解析response_params
        for (int i = 0; i < requestParamJson.size(); i++) {
            JSONObject param = requestParamJson.getJSONObject(i);
            processParam(rootName,className,"",param, fields, innerClasses, "");
        }

        templateData.put("fields", fields);
        templateData.put("inner_classes", innerClasses);

        // 初始化Beetl模板引擎
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

        // 获取模板并渲染
        Template template = gt.getTemplate(TEMPLATE_PATH);
        template.binding(templateData);

        // 确保输出目录存在
        File outputDir = new File(outputPath).getParentFile();
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // 写入生成的代码
        try (FileWriter writer = new FileWriter(outputPath)) {
            template.renderTo(writer);
        }
    }

    private static void processParam(String rootName,String parentName,String pName,JSONObject param, List<Map<String, Object>> fields,
            List<Map<String, Object>> innerClasses, String prefix) {
        Integer paramType = param.getInteger("paramType");
        String paramName = param.getString("paramName");
        Boolean required = param.getBoolean("required");
        String desc = param.getString("desc");
        JSONArray openParamList = param.getJSONArray("openParamList");
        String type = getParamTypeName(paramType);

//        if ("$item".equals(paramName)) {
//            paramName = capitalize2(parentName);
//        }
//        if(type.equals("object")){
//            paramName = capitalize(parentName) +capitalize(paramName);
//        }

        StringBuilder sb = new StringBuilder();
        sb.append("说明:"+desc).append("\n");
        sb.append("是否必填:"+required).append("\n");
        sb.append("类型标识:"+paramType+"，类型:"+getParamTypeName(paramType)).append("\n");
        String name = paramName;
        String description = sb.toString();


        if (paramType.equals(8)) {
            // 处理数组类型
            String baseType = getBaseType(openParamList);
            if (baseType.equals("object")) {
                // 对象数组
                String innerClassName = capitalize(name) + "Item";

                Map<String, Object> field = new HashMap<>();
                field.put("type", "List<" + innerClassName + ">");
                field.put("name", name);
                field.put("description", description);
                fields.add(field);

                // 创建内部类
                Map<String, Object> innerClass = new HashMap<>();
                innerClass.put("name", innerClassName);
                List<Map<String, Object>> innerFields = new ArrayList<>();
                innerClass.put("fields", innerFields);
                innerClasses.add(innerClass);

                pName = name;

                // 处理子字段
                JSONArray children = param.getJSONArray("openParamList");
                if (children != null) {
                    for (int i = 0; i < children.size(); i++) {
                        processParam(rootName,innerClassName,pName,children.getJSONObject(i), innerFields, innerClasses,
                                prefix + innerClassName + ".");
                    }
                }
            } else if (baseType.equals("list")) {
              throw new RuntimeException("未实现");
            }else {
                // 基本类型数组
                Map<String, Object> field = new HashMap<>();
                field.put("type", "List<" + capitalize(baseType) + ">");
                field.put("name", name);
                field.put("description", description);
                fields.add(field);
            }
        } else if (type.equals("object") && "$item".equals(name)) {
            // 处理对象类型
//            String innerClassName = capitalize(name);
            // 处理对象类型
//            if ("processTypeVO".equals(name)){
//                System.out.println(11);
//            }
//            String innerClassName = capitalize(rootName)+capitalize(pName)+capitalize(name);
//            Map<String, Object> field = new HashMap<>();
//            field.put("type", innerClassName);
//            field.put("name", name);
//            field.put("description", description);
//            fields.add(field);

            // 创建内部类 lastMap
            Map<String, Object> innerClass =   innerClasses.get(innerClasses.size() - 1);
            List<Map<String, Object>> innerFields = (List<Map<String, Object>>)innerClass.get("fields");

            pName = name;
            String innerClassName = name;
            // 处理子字段
            JSONArray children = param.getJSONArray("openParamList");
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    processParam(rootName,innerClassName,pName,children.getJSONObject(i), innerFields, innerClasses,
                            prefix + innerClassName + ".");
                }
            }
        } else if (type.equals("object")) {
            // 处理对象类型
//            String innerClassName = capitalize(name);
            // 处理对象类型
            if ("processTypeVO".equals(name)){
                System.out.println(11);
            }
            String innerClassName = capitalize(rootName)+capitalize(pName)+capitalize(name);
            Map<String, Object> field = new HashMap<>();
            field.put("type", innerClassName);
            field.put("name", name);
            field.put("description", description);
            fields.add(field);

            // 创建内部类
            Map<String, Object> innerClass = new HashMap<>();
            innerClass.put("name", innerClassName);
            List<Map<String, Object>> innerFields = new ArrayList<>();
            innerClass.put("fields", innerFields);
            innerClasses.add(innerClass);

            pName = name;

            // 处理子字段
            JSONArray children = param.getJSONArray("openParamList");
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    processParam(rootName,innerClassName,pName,children.getJSONObject(i), innerFields, innerClasses,
                            prefix + innerClassName + ".");
                }
            }
        } else {
            // 处理基本类型
            Map<String, Object> field = new HashMap<>();
            field.put("type", capitalize(type));
            field.put("name", name);
            field.put("description", description);
            fields.add(field);
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if ("$item".equals(str)){
            return "";
        }

        if (str.equals("string")) return "String";
        if (str.equals("integer")) return "Long";
        if (str.equals("boolean")) return "Boolean";
        if (str.equals("float")) return "BigDecimal";
        if (str.equals("double")) return "BigDecimal";
        if (str.equals("long")) return "Long";
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String capitalize2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        if (str.equals("string")) return "String";
        if (str.equals("integer")) return "Long";
        if (str.equals("boolean")) return "Boolean";
        if (str.equals("float")) return "BigDecimal";
        if (str.equals("double")) return "BigDecimal";
        if (str.equals("long")) return "Long";
        str= str.substring(0, 1).toUpperCase() + str.substring(1);
        return str.replace("List","");
    }

    private static String getParamTypeName(Integer paramType) {
        String name = "";
        switch (paramType) {
            case 1:
                name =  "long";
                break;
            case 4:
                name =  "string";
                break;
            case 5:
                name =  "boolean";
                break;
            case 6:
                name =  "object";
                break;
            case 8:
                name =  "list";
                break;
            default:
                throw new RuntimeException("无法识别paramType:"+paramType);
        }
        return name;
    }

    private static String getBaseType(JSONArray openParamList) {
        String name = "";
        JSONObject jsonObject = openParamList.getJSONObject(0);
        Integer paramType = jsonObject.getInteger("paramType");
        switch (paramType) {
            case 1:
                name =  "long";
                break;
            case 4:
                name =  "string";
                break;
            case 5:
                name =  "boolean";
                break;
            case 6:
                name =  "object";
                break;
            case 8:
                name =  "list";
                break;
            default:
                throw new RuntimeException("无法识别paramType:"+paramType);
        }
        return name;
    }
}