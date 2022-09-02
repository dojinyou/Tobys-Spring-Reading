package com.dojinyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDao {

  private final DataSource dataSource;

  public UserDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection c = dataSource.getConnection();

    PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());

    try (
        c;
        ps
    ) {
      ps.executeUpdate();
    }
  }

  public User get(String id) throws ClassNotFoundException, SQLException {
    Connection c = dataSource.getConnection();

    PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();

    try (
        c;
        rs;
        ps
    ) {
      rs.next();

      User user = new User();
      user.setId(rs.getString("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));

      return user;
    }
  }
}
