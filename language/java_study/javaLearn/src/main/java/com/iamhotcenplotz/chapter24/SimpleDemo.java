package com.iamhotcenplotz.chapter24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 10:34
 * @description:
 */


public class SimpleDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456");
        connection.setAutoCommit(false);
        // String sql = "create table goods.product (id int,name varchar(255),price double);";
        String sql = "insert into goods.product (id,name,price) values "
                + "(1,'iPhone',9999.99),"
                + "(2,'iPad',12999.99);";


        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);

        connection.commit();

        statement.close();
        connection.close();


    }
}
