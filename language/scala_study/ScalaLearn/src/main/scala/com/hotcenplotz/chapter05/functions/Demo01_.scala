package com.hotcenplotz.chapter05.functions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-09 06:26 
 * @description: 定义函数
 */


object Demo01_ {
    def main(args: Array[String]): Unit = {
        println(getResult(10, 20, '+'))
    }

    def getResult(n1: Int, n2: Int, opr: Char): Any = {
        if (opr == '+') n1 + n2
        else if (opr == '-') n1 - n2
        else null
    }

    def getResultTwo(n1: Int, n2: Int): Int = {
        n1 + n2
    }
}
