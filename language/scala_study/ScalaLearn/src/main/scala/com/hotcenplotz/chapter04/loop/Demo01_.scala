package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 07:32 
 * @description: for loop
 */


object Demo01_ {
    def main(args: Array[String]): Unit = {
        for(i <- 1 to 10){
            println(s"Hello Scala : $i" )
        }

        for(j <- 0 until 10){
            println(s"Hello Spark $j")
        }
    }
}
