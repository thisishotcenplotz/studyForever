package com.hotcenplotz.chapter04.ifelse

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 06:26 
 * @description:
 */


object Demo02_ {
    def main(args: Array[String]): Unit = {
        val age:Int = 18

        if( age > 18){
            println("Greater than eighteen")
        } else {
            println("Less than eighteen")
        }
    }

    def exercise01(): Unit = {
        val num1:Int = 10
        val num2:Int = 2

        if (num1 % 3 == 0 && num2 % 5 == 0){
            println("good")
        } else {
            println("bad")
        }
    }

    // 判断闰年
    def isYear(year:Int): Unit = {
        if ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            println("true")
        } else {
            println("false")
        }
    }

}
