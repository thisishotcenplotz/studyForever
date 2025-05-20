package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 05:29 
 * @description: Stream Demo
 * */
object streamDemo01_ {
    def main(args: Array[String]): Unit = {
        def numsForm(n:BigInt):LazyList[BigInt] = n #:: numsForm(n +1)
        
        val lazyList:LazyList[BigInt] = numsForm(100)
        
        println(lazyList.head)
        println(lazyList.tail)
        println(lazyList)
    }
}
