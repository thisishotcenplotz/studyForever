package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 08:00 
 * @description: 元组匹配
 * */
object Demo06_ {
    def main(args: Array[String]): Unit = {
        val products: Array[Product] = Array((0, 1), (1, 0), (1, 1), (2, 1), (1, 2, 3))
        
        for (i <- products) {
            val rst: String = i match {
                case (0, _) => "0,xx"
                case (_, 0) => "xx,0"
                case (a: Int, b: Int) if (a >= b) => "big,small"
                case (a, b, c) => "..."
                case _ => "......"
            }
            
            println(rst)
        }
    }
}
