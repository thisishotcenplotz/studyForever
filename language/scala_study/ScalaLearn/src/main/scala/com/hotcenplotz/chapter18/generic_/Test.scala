package com.hotcenplotz.chapter18.generic_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 07:49 
 * @description:
 * */
object Test {
    def main(args: Array[String]): Unit = {
        // Case One
        println(new IntMessage[Int](19).getMessage)
        println(new StringMessage[String]("Hello World").getMessage)
    }
}
