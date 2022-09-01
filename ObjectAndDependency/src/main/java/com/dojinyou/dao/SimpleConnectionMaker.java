package com.dojinyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

  private static final String HOST_URI = "jdbc:mysql://localhost:33306/topring?useUnicode=true&serverTimezone=Asia/Seoul&useSSL=false";
  private static final String DB_USER_NAME = "root";
  private static final String DB_USER_PASSWORD = "mysql";
  private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

  public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER_CLASS_NAME);
    return DriverManager.getConnection(HOST_URI, DB_USER_NAME, DB_USER_PASSWORD);
  }
}
