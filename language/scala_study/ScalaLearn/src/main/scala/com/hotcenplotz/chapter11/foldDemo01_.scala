package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 20:15 
 * @description: foldLeft demo
 * fold 就是带初始值的reduce
 * */
object foldDemo01_ {
    def main(args: Array[String]): Unit = {
        val data: List[Int] = (1 to 100).toList
        
        // (((((0+1) + 2) + 3) + 4) + 5) ....
        val rst: Int = data.foldLeft(0)((a, b) => a + b)
        
        println(data.foldLeft(5050)((a, b) => a - b))
        
    }
}
