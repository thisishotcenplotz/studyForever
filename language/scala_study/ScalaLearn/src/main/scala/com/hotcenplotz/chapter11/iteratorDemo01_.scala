package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 05:18 
 * @description:
 * */
object iteratorDemo01_ {
    def main(args: Array[String]): Unit = {
        val iterator: Iterator[Int] = (1 to 100).toList.iterator
        
        // while
        while (iterator.hasNext){
            println(iterator.next())
        }
        
        // for
        val iterator1: Iterator[Int] = (1 to 100).toList.iterator
        for( num <- iterator1) println(num)
        
    }
}
