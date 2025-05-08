package com.hotcenplotz.chapter05.functions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-09 06:33 
 * @description:
 */


object FuncTheorem {

    // 1. 先把main入栈
    // 2. 再把sum 入栈
    def main(args: Array[String]): Unit = {
        val a: Int = 10
        val b: Int = 20

        println(sum(a, b))
    }

    def sum(n1: Int, n2: Int): Int = n1 * n2 + n1 + n2
}
