package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 07:05 
 * @description: 类型匹配
 * */
object Demo04_ {
    def main(args: Array[String]): Unit = {
        val i: Any = 1
        
        i match {
            case a: Int => println("Int")
            case b: Map[String, Int] => println("Map[String,Int]")
            case c: Array[String] => println("Array[String]")
            case d: BigInt => println("BigInt")
            case _ => println("Hello World")
        }
    }
}
