package com.hotcenplotz.chapter05

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-09 05:52 
 * @description: 方法和函数之间的转换示例
 */


object Method2FunctionDemo {

    def main(args: Array[String]): Unit = {

        // 使用方法：传统方法
        val dog: Dog = new Dog
        println(dog.sum(1, 2))

        // 方法转函数
        val f1: (Int, Int) => Int = dog.sum _
        println(f1(2, 3))

        //函数
        val f2 = (a:Int,b:Int) => a + b
    }

}

class Dog {

    def sum(a:Int,b:Int):Int = a + b
}
