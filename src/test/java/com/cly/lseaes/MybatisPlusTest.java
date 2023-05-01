package com.cly.lseaes;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class MybatisPlusTest {
    public static void main(String[] args) {
        /**                   数据连接  记得改成你的数据库，用户名和密码                */
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/lseaes?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true", "root", "c5971415")
                .globalConfig(builder -> {
                    builder.author("cly") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 释放执行就会覆盖已生成文件
                            //鼠标右击蓝色java目录，选择Copy Path... 选择 Absolute Path 即可复制路径，粘贴到下面即可
                            .outputDir("D:\\lseaes\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.cly.lseaes") // 设置父包名
//                            .moduleName("") // 设置父包模块名  需要你就设置
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\lseaes\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//
//                    builder.addInclude("user").addInclude("book")// 设置需要生成的表名
//                    builder.addTablePrefix("t_", "c_"). // 设置过滤表前缀  卡尼的表是否存在前缀
                    builder
//                            .addInclude("admin")
//                            .addInclude("course")
//                            .addInclude("chapter")
//                            .addInclude("lesson")
//                            .addInclude("exam")
//                            .addInclude("notice")
//                            .addInclude("problem")
//                            .addInclude("rule")
//                            .addInclude("user")
//                            .addInclude("user_exam")
//                            .addInclude("exam_problem")
//                            .addInclude("user_exam_option")
                            .addInclude("question")
                            .addInclude("question_answer")
                            .addInclude("question_repository")
                            .addInclude("repository")
                            .addInclude("repository_exam")
                            .addInclude("paper")
                            .addInclude("paper_question")
                            .addInclude("paper_question_answer")
                            .addInclude("exam_course")

                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
