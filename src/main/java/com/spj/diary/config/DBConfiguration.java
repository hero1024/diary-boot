package com.spj.diary.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    @Resource
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "hikari.datasource")
    public DataSource dataSource() {
        return new HikariDataSource();
    }

}
