package com.iamhotcenplotz.chapter25.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 21:58
 * @description:
 */


public class Intro04 {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/jdbc/mysql.properties"));

        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        String sql = "insert into demo.actor (name,gender,birthday,phone) "
                + " values "
                + " ('关之琳','女','1950-01-01','13800138555') ";

        statement.executeUpdate(sql);

        connection.commit();

        statement.close();
        connection.close();

    }
}
