package com.hotcenplotz.chapter03

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 05:51 
 * @description:
 */


object Demo03_ {
    def main(args: Array[String]): Unit = {
        var num: Int = 2
        println(num << 1) // num * 2
        println(num << 2) // num * 2 * 2
        println(num >> 1) // num / 2
        println(num >> 2) // num / 2 / 2

        // Scala 中支持代码块赋值
        val res: Int = {
            if (num << 4 > 100) 100 else 200
        }

        // swap
        var a: Int = 100
        var b: Int = 200
        a = a + b // a = 300, b = 200
        b = a - b // a = 300, b = 100
        a = a - b // a = 200, b = 100

        // swap 2 : 位运算
        var c: Int = 100
        var d: Int = 200

        a = a ^ b
        b = a ^ b
        a = a ^ b

    }
}
