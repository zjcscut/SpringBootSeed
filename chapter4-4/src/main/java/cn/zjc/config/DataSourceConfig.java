package cn.zjc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author zhangjinci
 * @version 2016/9/23 10:00
 * @function
 */
@Configuration
public class DataSourceConfig {


    //配置主数据源
    @Bean(name = "primaryDataSource")
    @Qualifier(value = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    //配置从数据源
    @Bean(name = "secondaryDataSource")
    @Qualifier(value = "secondaryDataSource")
    @Primary   //如果有多个类同时实现一个接口,其中一个类必须指定此注解确定注入的Bean,否则会报错找不到注入的bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
