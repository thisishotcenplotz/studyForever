package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 07:10 
 * @description: 高阶函数示例代码
 * */
object HighOrderFuncDemo01_ {
    
    // 1. test 就是一个高阶函数
    // 2. f:Double => Double 表示一个函数，该函数接收一个Double，返回一个Double
    // 3. n1: Double 普通参数
    // 4. f(n1) 在test函数中，执行你传入的函数
    def test(f: Double => Double, n1: Double) = f(n1)
    
    def sum2(d: Double): Double = d + d
    
    def myPrint():Unit = println("Hello World")
    
    def main(args: Array[String]): Unit = {
        val rst: Double = test(sum2, 3.5)
        println(rst)
        
        // 在Scala中，可以直接把一个函数赋值给一个变量, 但是不执行这个函数
        // 加 _ 则是函数
        // 不加 _ 则是Unit
        val f1: Unit = myPrint
        val f2: () => Unit = myPrint _
    }
}
