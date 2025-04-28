package com.iamhotcenplotz.chapter25.preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 09:43
 * @description: 防范sql注入
 */


public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/jdbc/mysql.properties"));
        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );

        String name = "刘德华";
        String gender = "男";
//        String name = "' or";
//        String gender = "or '1' = '1";

        String sql = "select * from demo.actor where name = ? and gender = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, gender);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String theName = resultSet.getString("name");
            String theGender = resultSet.getString("gender");
            Date date = resultSet.getDate("birthday");
            System.out.println(id + " " + theName + " " + theGender + " " + date);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
