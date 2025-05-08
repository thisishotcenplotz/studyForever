package com.hotcenplotz.chapter03

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 06:06 
 * @description:
 */


object Demo04_ {
    def main(args: Array[String]): Unit = {
        val num: Int = if (5 > 4) 5 else 4

        // 求两个数的最大值
        val n1: Int = 100
        val n2: Int = 200
        val res: Int = if (n1 > n2) n1 else n2
        val res2: Int = n1 max n2
        val res3: Int = n1.max(n2)
        println(res)
        println(res2)
        println(res3)
    }

}
