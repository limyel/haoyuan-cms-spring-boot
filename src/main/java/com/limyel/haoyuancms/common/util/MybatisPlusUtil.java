package com.limyel.haoyuancms.common.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusUtil {

    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/haoyuan?useSSL=false&serverTimezone=UTC&characterEncoding=UTF8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("limyel") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\workspace"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.limyel") // 设置父包名
                            .moduleName("haoyuancms") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\workspace")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("cms_file") // 设置需要生成的表名
                            .addInclude("cms_log")
                            .addInclude("cms_permission")
                            .addInclude("cms_role")
                            .addInclude("cms_role_permission")
                            .addInclude("cms_user")
                            .addInclude("cms_user_identity")
                            .addInclude("cms_user_role");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
