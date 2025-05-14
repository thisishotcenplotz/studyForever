package com.hotcenplotz.chapter09

import scala.language.implicitConversions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 20:43 
 * @description: 利用隐式转换给一个类增加MySQL 的 delete方法
 * */

class Demo01_ {
    implicit def addDelete(m:MySQL):DB = new DB
    
    def main(args: Array[String]): Unit = {
        val mysql: MySQL = new MySQL
        mysql.insert()
        mysql.delete()
    }
}

class MySQL {
    def insert():Unit = {}
}

class DB {
    def delete():Unit = {}
}