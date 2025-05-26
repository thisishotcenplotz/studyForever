package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:17 
 * @description:
 * */
object Exercise01_ {
    def main(args: Array[String]): Unit = {
        println(swap("1,", "b"))
        println(swap(10, 20))
    }
    
    def swap[S, T](tup: (S, T)): (T, S) = {
        tup match {
            case (a, b) => (b, a)
        }
    }
}
