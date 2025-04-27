package com.iamhotcenplotz.chapter25.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 21:18
 * @description: First JDBC demo
 */


public class Intro01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        // 1. 注册驱动
        Driver driver = new Driver();

        // 2. 得到连接
        Connection connected = driver.connect(url, properties);
        connected.setAutoCommit(false);

        // 3. 执行sql
        String sql = "insert into demo.actor (name,gender,birthday,phone) "
                + " values "
                + " ('周星驰','男','1961-01-01','13800138222') ";

        Statement statement = connected.createStatement();
        int row = statement.executeUpdate(sql);
        System.out.println(row > 0 ? "成功" : "失败");
        connected.commit();

        // 4. 关闭连接
        statement.close();
        connected.close();
    }
}
