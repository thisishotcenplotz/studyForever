package com.hotcenplotz.web;

import com.hotcenplotz.web.com.hotcenplotz.web.model.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-07 06:54
 * @description:
 */


public class JdbcTest {
    
    /**
     * JDBC demo
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/the_db";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        
        // 3. 获取SQL执行语句
        Statement statement = connection.createStatement();
        
        // 4. 执行SQL
        int execute = statement.executeUpdate("update the_db.user set age = 18 where id = 1");
        System.out.println("SQL语句执行完毕影响记录数据量为：" + execute);
        
        // 5. 释放资源
        connection.commit();
        statement.close();
        connection.close();
    }
    
    @Test
    public void testQuery() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/the_db";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        
        // 3. 获取SQL执行语句
        String sql = "select * from the_db.user where age = ? and id > ?"; // 预编译SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, 20);
        statement.setInt(2, 1);
        
        // 4. 执行SQL
        ResultSet resultSet = statement.executeQuery();
        
        // 5. 处理并封装返回数据
        while (resultSet.next()) {
            User user = new User(
                resultSet.getInt("id")
                , resultSet.getString("username")
                , resultSet.getString("password")
                , resultSet.getString("name")
                , resultSet.getInt("age")
                , resultSet.getTimestamp("last_update").toLocalDateTime()
            );
            
            System.out.println(user);
        }
        
        
        // 5. 释放资源
        connection.commit();
        statement.close();
        connection.close();
    }
}
