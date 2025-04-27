package com.iamhotcenplotz.chapter25.myjdbc;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 20:57
 * @description: 模拟 jdbc
 */


public class Demo {
    public static void main(String[] args) {
        //
        MysqlJdbcImplement mysqlJdbcImplement = new MysqlJdbcImplement();
        Object connection = mysqlJdbcImplement.getConnection();
        mysqlJdbcImplement.crud();
        mysqlJdbcImplement.close();

        //
        OracleJdbcImplements oracleJdbcImplements = new OracleJdbcImplements();
        Object connection1 = oracleJdbcImplements.getConnection();
        oracleJdbcImplements.close();
        oracleJdbcImplements.close();
    }
}
