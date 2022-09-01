package com.dojinyou.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class KUserDao extends UserDao {
  @Override
  public Connection getConnection() throws SQLException, ClassNotFoundException {
    // K사의 DB Connection 생성코드
    return null;
  }
}
