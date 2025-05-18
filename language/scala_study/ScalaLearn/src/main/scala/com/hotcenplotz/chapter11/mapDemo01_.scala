package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 07:00 
 * @description:
 * */
object mapDemo01_ {
    def main(args: Array[String]): Unit = {
        val list: IndexedSeq[Int] = (1 to 10).map(_ * 2).map(_ + 1)
        
        val list2 = (1 to 10).map(i => (i to 3 * i).toList).flatten
        
        println(list2)
    }
    
}
