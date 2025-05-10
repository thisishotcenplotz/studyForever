package com.hotcenplotz.chapter05.lazy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 08:10 
 * @description: Scala lazy demo
 */


object ScalaLazy {
    def main(args: Array[String]): Unit = {
        lazy val rst: Int = sum(10, 20) // 在使用rst时，才会被触发执行
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        println(s"rst = $rst")
    }

    def sum(n1: Int, n2: Int): Int = {
        println("sum executed!")
        n1 + n2
    }
}
