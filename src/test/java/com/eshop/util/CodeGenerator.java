package com.eshop.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    public static String path = "C:\\zit\\workspacetest\\eshop-plat-api\\src\\main\\java";
    public static String pathXml = "C:\\zit\\workspacetest\\eshop-plat-api\\src\\main\\resources\\mapper";
    public static String  packagePath = "com.eshop";
    public static void main(String[] args) {
        create("log");
    }

    public static void create(String db) {
        String url = "jdbc:mysql://192.168.10.136:3306/eshop_" + db + "?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&useSSL=false";
        String username = "eshop";
        String password = "eshop123";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("ren_chun_hui") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(path); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent(packagePath) // 设置父包名
//                                .moduleName() // 设置父包模块名
                                .entity("entity."+db) // 设置实体类包名
                                .controller("controller."+db) // 设置实体类包名
                                .mapper("mapper."+db) // 设置实体类包名
                                .service("service."+db) // 设置实体类包名
                                .serviceImpl("service."+db+".impl")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, pathXml+"\\"+db)) // 设置mapperXml生成路径
                )
//                .strategyConfig(builder ->
//                        builder.addInclude("t_simple") // 设置需要生成的表名
//                              //  .addTablePrefix("t_", "c_") // 设置过滤表前缀
//                )
                .templateEngine(new BeetlTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
