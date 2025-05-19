package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 19:49 
 * @description:
 * */


object filterDemo01_ {
    def main(args: Array[String]): Unit = {
        val str: List[String] = List("Alice", "Bob", "Jack")
        str.filter((_: String).startsWith("A")).foreach(println)
    }
}
