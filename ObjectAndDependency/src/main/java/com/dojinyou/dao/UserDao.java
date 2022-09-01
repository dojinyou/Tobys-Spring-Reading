package com.dojinyou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  private final ConnectionMaker connectionMaker;

  public UserDao() {
     connectionMaker = new NConnectionMaker();
  }


  public void add(User user) throws ClassNotFoundException, SQLException {
    Connection c = connectionMaker.makeConnection();

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
    Connection c = connectionMaker.makeConnection();

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

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    UserDao dao = new UserDao();

    User user = new User();
    user.setId("whiteship");
    user.setName("백기선");
    user.setPassword("married");

    dao.add(user);

    System.out.println(user.getId() + "등록 성공");

    User user2 = dao.get(user.getId());

    System.out.println(user2.getName());
    System.out.println(user2.getPassword());

    System.out.println(user2.getId() + "조회 성공");
  }
}
