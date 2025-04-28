package com.iamhotcenplotz.chapter25.apachedbutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.iamhotcenplotz.chapter25.apachedbutils.model.Actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-28 19:24
 * @description: 使用apache-dbutils + druid 完成CRUD
 */


public class DbUtils01_ {

    @Test
    public void testQueryMany() throws Exception {

        // 1. 得到一个链接: Druid
        String conf = "src/main/java/com/iamhotcenplotz/chapter25/pool/druid_/druid.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(conf));
        DataSource connections = DruidDataSourceFactory.createDataSource(properties);

        // 2. 使用Dbutils
        QueryRunner queryRunner = new QueryRunner();

        // 3. 查询
        Connection conn = connections.getConnection();
        List<Actor> result = queryRunner.query(conn, "select * from demo.actor", new BeanListHandler<>(Actor.class));
        conn.close();
        result.forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 4. 返回单行记录
        Connection conn2 = connections.getConnection();
        Actor result2 = queryRunner.query(conn2, "select * from demo.actor where id = ?", new BeanHandler<>(Actor.class), 1);
        conn2.close();
        System.out.println(result2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 5. 返回单行单列
        Connection conn3 = connections.getConnection();
        Object result3 = queryRunner.query(conn3, "select name from demo.actor where id = ?", new ScalarHandler<>(),1);
        conn3.close();
        System.out.println(result3);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 6. Update Insert Delete Demo
        Connection conn4 = connections.getConnection();
        conn4.setAutoCommit(false);
        int insert = queryRunner.update(conn4, "update demo.actor set phone = '13800520521' where id =  ?", 5);
        System.out.println(insert > 0 ? "ok~" : "no effect~");

        int update = queryRunner.update(conn4, "insert into demo.actor (name,gender,birthday,phone) values (?,?,?,?)", "林青霞", "女", "1966-01-01", "1383811233");
        System.out.println(update > 0 ? "ok~" : "no effect~");

        int delete = queryRunner.update(conn4, "delete from demo.actor where id = ?", 1);
        System.out.println(delete > 0 ? "ok~" : "no effect~");


        conn4.commit();
        conn4.close();

    }
}
