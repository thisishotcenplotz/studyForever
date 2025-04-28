package com.iamhotcenplotz.chapter25.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 11:28
 * @description: data insertion batch process demo
 */


public class BatchProcess_ {

    public static void  normalProcess() throws SQLException {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306",
            "root",
            "123456"
        );

        String sql = "insert into demo.batch_test (usr,pwd) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            preparedStatement.setString(1,"usr" + i);
            preparedStatement.setString(2,"pwd" + i);
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        preparedStatement.close();
        connection.close();

    }

    public static void batchProcess() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306",
                "root",
                "123456"
        );
        connection.setAutoCommit(false);

        String sql = "insert into demo.batch_test (usr,pwd) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            preparedStatement.setString(1,"usr" + i);
            preparedStatement.setString(2,"pwd" + i);
            preparedStatement.addBatch();

            if( (i+1) % 2000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
                connection.commit();
                System.out.println("batch number: " + (i / 2000 + 1));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        connection.commit();
        preparedStatement.close();
        connection.close();

    }

    public static void main(String[] args) throws SQLException {
        batchProcess();
    }
}
