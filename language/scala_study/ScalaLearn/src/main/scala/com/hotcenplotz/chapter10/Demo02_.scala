package com.hotcenplotz.chapter10

import java.util
import scala.collection.mutable.ArrayBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-16 05:48 
 * @description: Scala 数组与 Java 互换。
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        // Scala 集合和 Java 集合互相转换
        val arr: ArrayBuffer[String] = ArrayBuffer("1", "2", "3")
        val strJava: util.List[String] = arr.asInstanceOf[util.List[String]]
    }
    
}
