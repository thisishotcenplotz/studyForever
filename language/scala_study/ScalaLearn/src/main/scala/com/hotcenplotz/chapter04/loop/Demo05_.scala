package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 08:30 
 * @description: loop 中 括号的使用
 *
 * 在Scala中 for循环的 ()  和 {}  是完全等价的。
 */


object Demo05_ {
    def main(args: Array[String]): Unit = {

        // 下面两种写法是等价的

        // 1.
        val one: IndexedSeq[Int] = for (i <- 1 to 100) yield i

        // 2.
        for {
            i <- 1 to 100
        } yield i
    }
}
