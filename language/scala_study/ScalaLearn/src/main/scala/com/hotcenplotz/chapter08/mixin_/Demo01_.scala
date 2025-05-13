package com.hotcenplotz.chapter08.mixin_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 20:33 
 * @description: 动态混入示例代码
 *
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = { // 在不修改类的定义基础上，让它们使用trait里面的方法
        
        val sqlServer: SqlServer with Operate3 = new SqlServer with Operate3 {}
        val pSql: PostgreSQL with Operate3 = new PostgreSQL with Operate3 {}
        val mysql: MySQL with Operate3 = new MySQL with Operate3 {
            override def say(): Unit = println("Hello MySQL")
        }
        
        sqlServer.insert(1)
        pSql.insert(2)
        mysql.insert(3)
        mysql.say()
    }
}

trait Operate3 {
    def insert(id: Int) = println(s"插入数据 = $id")
}

class SqlServer {}

abstract class PostgreSQL {}

abstract class MySQL {
    def say()
}