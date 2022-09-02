package com.dojinyou.dao;

public class MessageDao {

  private final ConnectionMaker connectionMaker;

  public MessageDao(ConnectionMaker connectionMaker) {
    this.connectionMaker = connectionMaker;
  }
}
