package com.hotcenplotz.chapter10

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-15 08:23 
 * @description:多维数组示例代码
 * */
object MultiDimArrayDemo01_ {
    def main(args: Array[String]): Unit = {
        val array: Array[Array[Double]] = Array.ofDim[Double](2, 2)
        array(0)(0) = 1
        array(0)(1) = 2
        array(1)(0) = 3
        array(1)(1) = 4
        
        // iteration
        for (i <- 0 until array.length) {
            for (j <- 0 until array(i).length) {
                print(s"($i,$j)")
            }
            println()
        }
        
        // iteration 2
        val str: String = array.indices.map { i =>
            array(i).indices.map { j =>
                s"($i,$j)"
            }.mkString(" ")
        }.mkString("\n")
        
        println(str)
    }
}
