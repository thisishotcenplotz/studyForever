package com.iamhotcenplotz.chapter25.preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 09:56
 * @description:
 */


public class PreparedStatementUpdate_ {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/jdbc/mysql.properties"));
        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );

        String sql = "insert into demo.actor (name,gender,birthday,phone) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"朱茵");
        preparedStatement.setString(2,"女");
        preparedStatement.setDate(3, java.sql.Date.valueOf("1960-01-01"));
        preparedStatement.setString(4,"13800138666");

//        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
