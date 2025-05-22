package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-23 06:13 
 * @description: 匿名函数
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        // 匿名函数1
        val triple = (x:Double) => x * 3
        (1 to 100).map(triple(_)).foreach(println)
        
        val f1: (Int, Int) => Int = (x: Int, y: Int) => {
            println(s"(x:$x, y:$y)")
            x + y
        }
        
        println((1 to 100).reduce((a, b) => f1(a, b)))
    }
}
