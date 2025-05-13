package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:17 
 * @description:
 * */

object Exercise03HelloWorld_ extends App {
    private val reverse: Array[String] = args.reverse
    println(reverse.map((arg: String) => arg.toString).mkString(" "))
}
