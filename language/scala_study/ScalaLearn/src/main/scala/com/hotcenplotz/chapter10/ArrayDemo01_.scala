package com.hotcenplotz.chapter10

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-15 07:46 
 * @description: 定长数组
 * */
object ArrayDemo01_ {
    def main(args: Array[String]): Unit = {
        // 第一种方式：
        // [Int] 表示只可以存储Int类型的元素
        // [Any] 表示可以存放任意类型元素的数组
        val arr01: Array[Int] = new Array[Int](4)
        println(arr01.length)
        
        // 赋值
        for (i <- 1 to arr01.length) {
            arr01(i - 1) = i
        }
        
        arr01.foreach(println)
        
        // 第二种方式：
        // 说明：
        // 1. 底层使用了apply方法
        // 2. 直接初始化数组，泛型给的Any
        val arr02: Array[Any] = Array(1, 2, '3', "4", 5.0f)
        println(arr02.mkString(" "))
        
    }
}
