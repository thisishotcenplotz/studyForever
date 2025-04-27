package com.iamhotcenplotz.chapter25.myjdbc;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-27 20:57
 * @description:
 */


public interface JdbcInterface {

    // 链接
    public Object getConnection();

    //crud
    public void crud();

    //关闭链接
    public void close();
}
