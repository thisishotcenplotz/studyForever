package com.hotcenplotz.chapter09

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 20:53 
 * @description: 隐式值
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        implicit val str:String = "Zhang san"
        hello
    }
    
    def hello(implicit name:String):Unit = println(s"Name: $name")
}
