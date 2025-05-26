package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:28 
 * @description:
 * */
object Exercise03_ {
    def main(args: Array[String]): Unit = {
        println(sum(List(Option(1), Option(2), None)))
    }
    def sum(lst:List[Option[Int]]) = lst.map(_.getOrElse(0)).sum
}
