package org.example;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class CodeGenerator {

    public static void main(String[] args) {
        // 1. 数据源配置 (使用新版Builder模式)
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai",
                "root",
                "root"
        )
//                .addConnectionProperty("remarks", "true")       // 获取表注释
//                .addConnectionProperty("useInformationSchema", "true") // MySQL获取注释
                .addConnectionProperty("allowPublicKeyRetrieval", "true")
                .build();

        // 2. 全局配置 (使用Builder模式)
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir("C:\\project\\springboot-demo\\springboot-demo" + "/src/main/java")
                .author("Dorothy")
                .disableOpenDir()                              // 生成后不打开目录
                .enableSpringdoc()                               // 开启swagger注解
                .dateType(DateType.TIME_PACK)                  // 使用java8时间类型
                .commentDate("yyyy-MM-dd HH:mm")               // 自定义注释日期格式
                .build();

        // 3. 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("org.example")
                .entity("pojo")
                .mapper("mapper")
                .service("service")
                .serviceImpl("service.impl")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"))
                .build();

        // 4. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude("order")                           // 需要生成的表
                .addTablePrefix("t_")                          // 过滤表前缀
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel) // 实体类命名规则
                .columnNaming(NamingStrategy.underline_to_camel)
                .enableLombok()                            // 使用lombok
                .enableChainModel()                        // 链式调用
                .enableRemoveIsPrefix()                    // 去除is前缀
                .versionColumnName("version")              // 乐观锁字段
                .logicDeleteColumnName("is_deleted")       // 逻辑删除字段
                .controllerBuilder()
                .enableRestStyle()                         // @RestController
                .enableHyphenStyle()                       // URL驼峰转连字符
                .mapperBuilder()
                .enableMapperAnnotation()                  // @Mapper
                .build();

        // 5. 模板配置（可选）
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)                 // 禁用默认实体模板
                .entity("/templates/entity.java")              // 自定义实体模板路径
                .build();

        // 6. 注入自定义配置（可选）
        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> {
                    // 自定义前置处理
                })
                .customMap(Collections.singletonMap("test", "value"))
                .build();

        // 7. 创建代码生成器
        AutoGenerator generator = new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .template(templateConfig)
                .injection(injectionConfig);
//                .template(new FreemarkerTemplateEngine());

        // 8. 执行生成
        generator.execute();
    }
}