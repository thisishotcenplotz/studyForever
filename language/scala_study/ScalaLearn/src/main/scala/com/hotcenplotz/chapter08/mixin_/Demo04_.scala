package com.hotcenplotz.chapter08.mixin_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 21:41 
 * @description: 特质中的字段
 * */
object Demo04_ {
    def main(args: Array[String]): Unit = {
        val test = new Mysql04 with DB04 {
            override val ts: Int = 100
        }
        println(test.operation)
    }
}

trait DB04 {
    val ts:Int
    val operation:String = "insert"
    def insert():Unit = {}
}

class Mysql04 {}