package com.dojinyou.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataFactory {

  private static final String HOST_URI = "jdbc:mysql://localhost:33306/topring?useUnicode=true&serverTimezone=Asia/Seoul&useSSL=false";
  private static final String DB_USER_NAME = "root";
  private static final String DB_USER_PASSWORD = "mysql";

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
    dataSource.setUrl(HOST_URI);
    dataSource.setUsername(DB_USER_NAME);
    dataSource.setPassword(DB_USER_PASSWORD);

    return dataSource;
  }

  @Bean
  public UserDao userDao() {
    return new UserDao(dataSource());
  }


}
