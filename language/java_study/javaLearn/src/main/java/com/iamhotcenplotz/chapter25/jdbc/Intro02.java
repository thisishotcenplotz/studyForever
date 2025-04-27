package com.iamhotcenplotz.chapter25.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 21:44
 * @description: connect mysql using DriverManager
 */


public class Intro02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "123456";

        // 1. set driver and driver manager
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);

        // 2. execute sql
        String sql = "insert into demo.actor (name,gender,birthday,phone) "
                + " values "
                + " ('邓紫棋','女','1990-01-01','13800138333') ";
        System.out.println(connection.createStatement().executeUpdate(sql) > 0 ? "Success" : "Failed");

        // 3. release resource
        connection.commit();
        connection.close();

    }
}
