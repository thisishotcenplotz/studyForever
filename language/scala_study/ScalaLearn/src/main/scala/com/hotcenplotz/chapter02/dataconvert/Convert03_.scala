package com.hotcenplotz.chapter02.dataconvert

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 06:39 
 * @description: Convert String to Basic data types
 */


object Convert03_ {
    def main(args: Array[String]): Unit = {
        val d: Double = 1.2
        val s1: String = d.toString

        // String to
        val s2: String = "12"
        val s21: Int = s2.toInt
        val s22: Byte = s2.toByte
        val s23: Double = s2.toDouble
        val s24: Long = s2.toLong


        // 这里要确保String 能转成对应的类型
        val s3: String = "hello"
        // s3.toInt  // 这不行
        // "12.5".toInt  // 这样也不行；因为Scala
        // "12.5".toDouble  // ok~

    }
}
