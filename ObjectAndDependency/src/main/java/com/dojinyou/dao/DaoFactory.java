package com.dojinyou.dao;

public class DaoFactory {
  public UserDao userDao() {
    return new UserDao(new SimpleConnectionMaker());
  }

  public AccountDao accountDao() {
    return new AccountDao(new SimpleConnectionMaker());
  }

  public MessageDao messageDao() {
    return new MessageDao(new SimpleConnectionMaker());
  }
}
