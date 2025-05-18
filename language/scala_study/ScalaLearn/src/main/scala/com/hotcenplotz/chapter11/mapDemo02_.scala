package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 07:25 
 * @description:
 * */
object mapDemo02_ {
    def main(args: Array[String]): Unit = {
        val list: List[Int] = List(3, 5, 7)
        
        // 说明：
        // 1. 将list这个集合的元素依次遍历
        // 2. 将各个元素船体给multiple这个函数，得到一个新的 Int
        // 3. 将得到新的Int，放入到一个新的集合并返回。
        // 4. 因此multiple这个函数会被调用三次。
        val list2: List[Int] = list.map(multiple)
        
        val demo: Demo = Demo()
        val ints: List[Int] = demo.map(_ + 1)
        println(ints)
        
        List("zhang san","Li si","wang ermazi").map(_.toUpperCase).foreach(println)
    }
    
    def multiple(n: Int): Int = {
        println("call multiple")
        2 * n
    }
}

// 模拟map 映射机制
class Demo {
    private val list1: List[Int] = List(1, 2, 3, 4)
    private var list2: List[Int] = List[Int]()
    
    def map(f: Int => Int): List[Int] = {
        for (item <- this.list1) {
            list2 = list2 :+ f(item)
        }
        list2
    }
}

object Demo {
    def apply(): Demo = new Demo()
}