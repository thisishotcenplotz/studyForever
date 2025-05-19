package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 20:26 
 * @description: scanLeft Demo
 * */
object scanDemo01_ {
    def main(args: Array[String]): Unit = {
        val data: List[Int] = (1 to 5).toList
        
        // (0,1) => 1
        // (1,2) => 3
        // (3,3) => 6
        // ...
        // ===> (0,1,3,6,10,15)
        val rst: List[Int] = data.scanLeft(0)((a, b) => a + b)
        println(rst.mkString(" "))
        
        
    }
}
