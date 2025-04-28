package com.iamhotcenplotz.chapter25.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 10:45
 * @description: mysql 工具类
 */


public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;

    static {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter25/utils/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(ResultSet set, Statement stmt, Connection conn) throws SQLException {
        if (set != null) {
            set.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

}
