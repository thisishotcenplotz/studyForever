package com.iamhotcenplotz.chapter25.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 21:51
 * @description:
 */


public class Intro03 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        String sql = "insert into demo.actor (name,gender,birthday,phone) "
                + " values "
                + " ('周慧敏','女','1950-01-01','13800138444') ";

        statement.executeUpdate(sql);

        connection.commit();

        statement.close();
        connection.close();
    }
}
