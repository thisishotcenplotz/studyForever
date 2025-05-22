package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-23 06:28 
 * @description: 高阶函数
 * */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        // demo 1
        // 可以传 1个或多个函数
        def test(f: Double => Double, ff: Double => Int, n1: Double): Double = f(ff(n1))
        
        def mod(d: Double): Int = d.toInt % 2
        
        def sum(d: Double): Double = d + d
        
        println(test(sum, mod, 5.0))
        
        // demo 2
        def minusxy(x: Int): Int => Int = {
            (y: Int) => x - y
        }
        
        println(minusxy(10)(5))
        
        val f1: Int => Int = minusxy(3) // 固定x为3
        
        println(f1(1))
        println(f1(2))
        println(f1(3))
        
        
        
    }
}
