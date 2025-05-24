package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 10:01 
 * @description: 抽象控制进阶 与 函数柯里化 的花式用法
 * */
object Demo07_ {
    def main(args: Array[String]): Unit = {
        // 传统写法
        var x: Int = 10
        while (x > 0) {
            x -= 1
            println(s"x = $x")
        }
        
        // 控制抽象写法
        def myUntil(condition: => Boolean)(block: => Unit): Unit = {
            if (condition) {
                block
                myUntil(condition)(block)
            }
        }
        
        var y = 100
        myUntil(y > 0) {
            y -= 1
            println(s"y = $y")
        }
    }
}
