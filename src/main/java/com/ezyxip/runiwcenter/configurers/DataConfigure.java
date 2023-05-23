package com.ezyxip.runiwcenter.configurers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@Configuration
public class DataConfigure {
    @Value("${runiw.datasource.url}")
    protected String url;
    @Value("${runiw.datasource.username}")
    protected String username;
    @Value("${runiw.datasource.password}")
    protected String password;
    @Value("${runiw.datasource.driver}")
    protected String driver;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.password(password);
        dataSourceBuilder.username(username);
        dataSourceBuilder.url(url);

        return dataSourceBuilder.build();
    }
}
