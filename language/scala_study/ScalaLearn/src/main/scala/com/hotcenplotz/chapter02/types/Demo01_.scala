package com.hotcenplotz.chapter02.types

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-02 07:03 
 * @description:
 */


object Demo01_ {
    def main(args: Array[String]): Unit = {
        var num1:Int = 10
        val isPass:Boolean = true

        // 因为Int是类，因此Int的一个实例就可以使用很多方法
        // 在scala中，如果一个方法没有形参，则可以省略()
        num1.toByte
        num1.toDouble
        num1.toString

        isPass.toString
    }

    private def sayHi():Unit = println("say hi")
}
