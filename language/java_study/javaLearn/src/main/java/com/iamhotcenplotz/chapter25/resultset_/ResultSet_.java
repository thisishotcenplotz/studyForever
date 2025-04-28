package com.iamhotcenplotz.chapter25.resultset_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 07:45
 * @description: 展示获取查询结果
 */


public class ResultSet_ {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/jdbc/mysql.properties"));
        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );

        Statement statement = connection.createStatement();

        String sql = "select * from demo.actor;";

        ResultSet resultSet = statement.executeQuery(sql);

        // 取出数据
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            Date date = resultSet.getDate("birthday");
            String phone = resultSet.getString("phone");

            System.out.println(id + "\t" + name + "\t" + gender + "\t" + date + "\t" + phone);
        }

        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
