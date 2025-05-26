package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:19 
 * @description:
 * */
object Exercise02_ {
    def main(args: Array[String]): Unit = {
        println(swap(Array("1", "2", "Hello")).mkString(";"))
    }
    
    def swap(arr: Array[Any]): Array[Any] = {
        arr match {
            case Array(a, b, rest@_*) => Array(b, a) ++ rest
            case _ => arr
        }
    }
}
