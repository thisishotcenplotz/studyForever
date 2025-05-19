package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 20:00 
 * @description: reduceLeft
 * */
object reduceDemo01_ {
    def main(args: Array[String]): Unit = {
        val data: List[Int] = (1 to 100).toList
        
        // ((((1+2)+3)+4)+5)...
        val rst: Int = data.reduceLeft((a, b) => a + b)
        
        // ((((100 + 99) + 98）+ 97) + 96) + ...
        val rstt: Int = data.reduceRight((a, b) => a + b)
        println(rstt)
        
        val theMax: Int = data.reduceLeft((a, b) => if (a >= b) a else b)
        
        // reduce 就是 reduceLeft
        val theMin: Int = List(3, 4, 2, 67, 8, 12).reduce((a, b) => if (a >= b) b else a)
    }
}
