package com.iamhotcenplotz.chapter25.dao_.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 09:43
 * @description:
 */


public class ConnectionPool {

    private static volatile ConnectionPool instance;
    private static DruidDataSource dataSource;

    private ConnectionPool() throws Exception {
        String conf = "src/main/java/com/iamhotcenplotz/chapter25/pool/druid_/druid.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(conf));
        dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    }
    public static Connection getConnection() throws Exception {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return dataSource.getConnection();
    }

    public void close() {
        if(dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    public void printPoolStats() {
        System.out.println("====== 连接池状态 ======");
        System.out.println("活跃连接数: " + dataSource.getActiveCount());
        System.out.println("空闲连接数: " + dataSource.getPoolingCount());
        System.out.println("创建的总连接数: " + dataSource.getCreateCount());
        System.out.println("销毁的总连接数: " + dataSource.getDestroyCount());
        System.out.println("等待获取连接的线程数: " + dataSource.getWaitThreadCount());
        System.out.println("=========================");
    }

}
