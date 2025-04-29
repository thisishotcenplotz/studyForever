package com.iamhotcenplotz.chapter26.restaurant.dao;

import com.iamhotcenplotz.chapter25.dao_.utils.ConnectionPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 09:39
 * @description:
 */


public class BasicDao<T>  {

    private QueryRunner qr = new QueryRunner();

    // common dml
    // update
    public int update(String sql,Object...parameters) throws Exception {
        Connection conn = null;
        try {
            conn = ConnectionPool.getConnection();
            return qr.update(conn, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }

    // 返回多行对象
    public List<T> queryList(String sql,Class<T> cls,Object...parameters) throws Exception {
        Connection conn = null;

        try {
            conn = ConnectionPool.getConnection();
            return qr.query(conn, sql, new BeanListHandler<T>(cls),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }

    // 返回单行
    public T query(String sql,Class<T> cls,Object ... parameters) throws SQLException {
        Connection conn = null;

        try {
            conn = ConnectionPool.getConnection();
            return qr.query(conn, sql, new BeanHandler<T>(cls),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }

    // 返回单值
    public Object queryValue(String sql,Object ... parameters) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionPool.getConnection();
            return qr.query(conn, sql, new ScalarHandler<>(),parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
    }
}
