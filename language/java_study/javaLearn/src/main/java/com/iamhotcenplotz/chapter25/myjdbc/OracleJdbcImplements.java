package com.iamhotcenplotz.chapter25.myjdbc;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 21:03
 * @description:
 */


public class OracleJdbcImplements implements JdbcInterface {
    @Override
    public Object getConnection() {
        return this;
    }

    @Override
    public void crud() {

    }

    @Override
    public void close() {

    }
}
