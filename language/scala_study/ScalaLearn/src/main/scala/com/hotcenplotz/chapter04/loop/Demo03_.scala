package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 07:43 
 * @description:
 */


object Demo03_ {
    def main(args: Array[String]): Unit = {

        // for 循环中引入变量
        for (i <- 1 to 100; j = i + 1) {
            println(s"i:$i -> j:$j")
        }

        // nested loop
        for (i <- 1 to 100; j <- i to 100){
            println(s"i:$i -> j:$j")
        }
    }
}
