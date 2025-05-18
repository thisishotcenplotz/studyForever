package com.hotcenplotz.chapter10.set_

import scala.collection.mutable

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-18 09:41 
 * @description:
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 默认为不可变Set
        val s1: Set[Int] = Set(1, 2, 3)
        
        // 可变的Set
        val s2: mutable.Set[Int] = mutable.Set(1, 2, 3, 4, 5)
        s2.addOne(6)
        s2.remove(1)
        
        println(s2.head)
        println(s2.tail)
        println(s2.contains(5))
        s2.foreach(v => println(v))
        println(s2.mkString(";"))
        println(s2.max)
        println(s2.min)
        println(s2.sum)
        
    }
}
