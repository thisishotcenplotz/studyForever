package com.iamhotcenplotz.chapter25.pool.druid_;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 16:47
 * @description: 德鲁伊连接池
 */


public class Demo01_ {

    public static void main(String[] args) throws Exception {
        String conf = "src/main/java/com/iamhotcenplotz/chapter25/pool/druid_/druid.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(conf));

        // 创建连接池
        DataSource connections = DruidDataSourceFactory.createDataSource(properties);

        // 测试
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = connections.getConnection();
            connection.setAutoCommit(false);
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");


    }
}
