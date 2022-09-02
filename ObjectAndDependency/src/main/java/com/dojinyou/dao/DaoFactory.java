package com.dojinyou.dao;

public class DaoFactory {
  public UserDao userDao() {
    return new UserDao(getConnectionMaker());
  }


  public AccountDao accountDao() {
    return new AccountDao(getConnectionMaker());
  }

  public MessageDao messageDao() {
    return new MessageDao(getConnectionMaker());
  }

  private static SimpleConnectionMaker getConnectionMaker() {
    return new SimpleConnectionMaker();
  }

}
