package com.hotcenplotz.chapter11


/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 05:55 
 * @description: 多核并行计算Demo
 * */
object parallelDemo01_ {
    def main(args: Array[String]): Unit = {
        
        // 我的Scala没找到对应并行计算的包就不写了。
        val rst1: IndexedSeq[String] = (0 to 100).map { case _ => Thread.currentThread().getName }
    }
}
