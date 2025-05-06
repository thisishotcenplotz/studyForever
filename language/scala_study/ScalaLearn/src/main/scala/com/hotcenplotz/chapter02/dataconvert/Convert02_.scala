package com.hotcenplotz.chapter02.dataconvert

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 06:01 
 * @description:
 */


object Convert02_ {
    def main(args: Array[String]): Unit = {
        val n1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt
        val n2: Int = (10 * 3.5 + 6 * 1.5).toInt
        println(s"n1:$n1 ; n2:$n2")
    }
}
