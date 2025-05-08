package com.hotcenplotz.chapter04.loop

import util.control.Breaks._

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 21:19 
 * @description: break inside a while demo
 *
 *               Scala 内置控制结构去掉了break和continue，是为了更好的使用函数化编程。
 *               推荐使用函数式的风格去解决break和continue的功能，而不是一个关键字
 */


object Demo08_ {
    def main(args: Array[String]): Unit = {
        var n: Int = 1

        breakable {
            do {
                println(n)
                if (n == 5) break()
                n += 1
            } while (true)
        }

        // method 2
        var loop: Boolean = true
        for (i <- 1 to 100 if loop) {
            println(i)
            if (i == 5) loop = false
        }

    }
}
