package com.iamhotcenplotz.chapter25.pool.c3p0_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 15:58
 * @description: C3P0 连接池Demo
 */


public class Demo01_ {

    // 方法1：
    @Test
    public void test01() throws SQLException {
        // 1. 创建连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // 2. 设置连接池参数
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");

        comboPooledDataSource.setInitialPoolSize(50); // 初始化连接数
        comboPooledDataSource.setMaxPoolSize(100); // 最大连接数

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
//            System.out.println("链接成功");
            connection.close();
        }

        long end = System.currentTimeMillis();

        System.out.println("总耗时：" +(end - start));
    }

}
