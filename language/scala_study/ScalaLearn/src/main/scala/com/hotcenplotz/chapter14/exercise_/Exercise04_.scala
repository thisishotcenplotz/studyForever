package com.hotcenplotz.chapter14.exercise_

import scala.math.sqrt

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:31 
 * @description:
 * */
object Exercise04_ {
    def main(args: Array[String]): Unit = {
        println(h(f, g)(0))
        println(h(f, g)(1))
        println(h(f, g)(2))
        
        val q: Double => Option[Double] = h(g, f)
        println(q(3))
    }
    
    def f(x: Double): Option[Double] = if (x > 0) Some(sqrt(x)) else None
    def g(x:Double):Option[Double] = if(x != 1) Some(1 / (x - 1)) else None
    
    def h(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = { (x: Double) =>
        if (f(x) == None || g(x) == None) None else g(x)
    }
 }
