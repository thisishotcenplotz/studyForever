package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 20:51 
 * @description: zip demo
 * */
object zipDemo01_ {
    def main(args: Array[String]): Unit = {
        val a: List[Int] = List(1, 2, 3)
        val b: List[Int] = List(2, 3, 4)
        println(a.zip(b))
    }
}
