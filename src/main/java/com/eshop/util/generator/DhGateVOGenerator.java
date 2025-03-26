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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DhGateVOGenerator {

    private static final String TEMPLATE_PATH = "/templates/dh_order_detail_template.btl";

    public static void generateVO(String jsonFilePath, String outputPath, String packageName, String className) throws Exception {
        // 读取JSON文件
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject jsonObject = JSON.parseObject(jsonContent);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray responseParams = data.getJSONArray("responseParams");


        // 准备模板数据
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package_name", packageName);
        templateData.put("class_name", className);

        List<Map<String, Object>> fields = new ArrayList<>();
        List<Map<String, Object>> innerClasses = new ArrayList<>();

        // 解析response_params
        for (int i = 0; i < responseParams.size(); i++) {
            JSONObject param = responseParams.getJSONObject(i);
            processParam(param, fields, innerClasses, "");
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

    private static void processParam(JSONObject param, List<Map<String, Object>> fields,
                                     List<Map<String, Object>> innerClasses, String prefix) {
        String fieldType = param.getString("fieldType");

        String type = param.getString("fieldTypeDetail");
        String name = param.getString("fieldName");
        //说明
        String description1 = param.getString("fieldKey");
        //例子
        String description2 = param.getString("fieldValueKey");
        String description = description1 + "\n" + description2;

        if ("3".equals(fieldType)) {
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

            // 处理子字段
            JSONArray childField = param.getJSONArray("childField");
            if (childField != null) {
                for (int i = 0; i < childField.size(); i++) {
                    processParam(childField.getJSONObject(i), innerFields, innerClasses,
                            prefix + innerClassName + ".");
                }
            }

        } else if ("1".equals(fieldType)) {
            // 处理对象类型
            String innerClassName = capitalize(name);
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

            // 处理子字段
            JSONArray children = param.getJSONArray("childField");
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    processParam(children.getJSONObject(i), innerFields, innerClasses,
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
        if (str.equals("string")) return "String";
        if (str.equals("integer")) return "Integer";
        if (str.equals("boolean")) return "Boolean";
        if (str.equals("double")) return "Double";
        if (str.equals("long")) return "Long";
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}