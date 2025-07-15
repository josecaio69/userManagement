package com.userHub.peopleManagement.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
    public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    @Value("${spring.datasource.url}")
    private String urlDataBase;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.hikari.poolName}")
    private String pollName;

    @Bean
    public HikariDataSource dataSource() {
//        try {
//            // Força o registro do driver manualmente
//            Class.forName(DRIVER_CLASS_NAME);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Driver MySQL não encontrado no classpath", e);
//        }
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(getUrlDataBase());
        config.setUsername(getUserName());
        config.setPassword(getPassword());
        config.setDriverClassName(DRIVER_CLASS_NAME);

        this.performanceOptimization(config);

        // Configurações do pool
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setPoolName(getPollName());

        return new HikariDataSource(config);
    }

    private void performanceOptimization(HikariConfig config) {
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
    }

    public String getUrlDataBase() {
        return urlDataBase;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPollName() {
        return pollName;
    }
}
