package com.dojinyou.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

public class CountingConnectionMaker implements ConnectionMaker {
  int counter = 0;
  private ConnectionMaker realConnectionMaker;

  public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
    this.realConnectionMaker = realConnectionMaker;
  }

  @Override
  public Connection makeConnection() throws ClassNotFoundException, SQLException {
    counter++;
    return realConnectionMaker.makeConnection();
  }

  public int getCounter() {
    return counter;
  }
}
