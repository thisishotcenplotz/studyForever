package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 19:46 
 * @description:
 * */
object flatMapDemo01_ {
    def main(args: Array[String]): Unit = {
        val str: List[String] = List("zhang san", "li si", "wang ermazi", "zhao liu")
        
        val rst: List[Char] = str.flatMap(_.toUpperCase)
        println(rst)
    }
    
}
