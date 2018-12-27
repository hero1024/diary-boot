package com.spj.diary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 启动应用程序。启动时将自动扫描注册 Beans，而不需设置 @ComponentScan 的 basePackages 属性
 */
@EnableAutoConfiguration
//@ComponentScan(basePackages = "diary")
//@MapperScan(basePackages  = "com.spj.diary.mapper")
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("服务器启动成功。。。");
    }
}



