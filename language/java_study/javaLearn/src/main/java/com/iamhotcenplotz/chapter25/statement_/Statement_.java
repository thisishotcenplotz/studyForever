package com.iamhotcenplotz.chapter25.statement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 09:15
 * @description: 演示Statement 注入问题
 */


public class Statement_ {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/jdbc/mysql.properties"));
        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );

        Statement statement = connection.createStatement();
//        String name = "刘德华";
//        String gender = "男";
        String name = "' or";
        String gender = "or '1' = '1";
        String sql = "select * from demo.actor where name = '"+ name +"' and gender = '" +gender+ "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String theName = resultSet.getString("name");
            String theGender = resultSet.getString("gender");
            Date date = resultSet.getDate("birthday");
            System.out.println(id + " " + theName + " " + theGender + " " + date);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
