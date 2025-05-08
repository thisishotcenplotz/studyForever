package com.hotcenplotz.chapter05.functions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-09 06:51 
 * @description:
 *
 * 递归：是一种解决复杂问题的方法
 * 1. 将一个复杂问题拆解成多个解决方法一致的小问题，从而简化问题
 * 2. 定义一个解决小问题的方法，然后在这个方法内再去嵌套调用自身方法
 * 3. 定义方法时需要注意：
 * 3.1 明确递归调用方法的结束条件，不然会无限递归
 * 4. 运行机制：
 * 4.1 将方法按照递归调用条件依序压入栈中去执行方法
 */


object RecursiveDemo {
    def main(args: Array[String]): Unit = {
        println(fibo(30))
        println(calc(5))
        println(peach(1))
    }

    def test(n: Int): Unit = {
        if (n > 2) test(n - 1)
        println(s"n = $n")
    }

    def test2(n: Int): Unit = {
        if (n > 2) test2(n - 1)
        else println(s"n = $n")
    }

    // exercise 01
    def fibo(n: Int): Int = {

        if (n == 1 || n == 2) 1
        else fibo(n - 1) + fibo(n - 2)
    }

    // exercise02
    def calc(n: Int): Int = {
        if (n == 1) 3
        else 2 * calc(n - 1) + 1
    }

    // exercise03 猴子吃桃
    // day10 = 1
    // day9 = (day10 + 1) * 2  ==> 4
    // day8 = (day9 + 1) * 2  ==> 10
    // ...
    def peach(day: Int): Int = {
        if (day == 10) 1
        else (peach(day + 1) + 1) * 2
    }

}
