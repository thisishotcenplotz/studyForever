package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 07:39 
 * @description: loop guard
 */


object Demo02_ {
    def main(args: Array[String]): Unit = {

        // 因为马丁认为 continue 和 break 既不是函数式 也不是面向对象，
        // 所以在Scala中是没有这两个关键字的。
        // 所以，scala中使用了循环守卫实现了类似于break continue 的效果
        for(i <- 1 to 200 if i%4 != 0){
            println(s"Hello Flink $i")
        }
    }
}
