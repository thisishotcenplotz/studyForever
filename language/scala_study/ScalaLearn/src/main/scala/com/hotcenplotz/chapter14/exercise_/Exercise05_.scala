package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:42 
 * @description:
 * */
object Exercise05_ {
    def main(args: Array[String]): Unit = {
        println(values(x => x + 100, 10, 20))
        println(values(x => x * 2, 10, 20))
        println(values(x => x * x, 10, 20))
        println(values(x => x, 10, 20))
    }
    
    def values(func: Int => Int, low: Int, high: Int): List[(Int, Int)] = {
        var newList: List[(Int, Int)] = Nil
        (low to high).foreach { x =>
            newList = (x, func(x)) :: newList
        }
        newList.reverse
    }
}
