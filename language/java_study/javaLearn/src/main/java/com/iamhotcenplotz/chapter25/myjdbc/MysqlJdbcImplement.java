package com.iamhotcenplotz.chapter25.myjdbc;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 20:59
 * @description: 模拟
 */


public class MysqlJdbcImplement implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("connected");
        return this;
    }

    @Override
    public void crud() {
        System.out.println("crud done.");
    }

    @Override
    public void close() {
        System.out.println("disconnected");
    }
}
