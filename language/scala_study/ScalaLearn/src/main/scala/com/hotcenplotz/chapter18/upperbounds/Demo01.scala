package com.hotcenplotz.chapter18.upperbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 14:03 
 * @description: 使用传统方法和上界方法实现Int 和 Float 之间的 compare 方法
 * */
object Demo01 {
    def main(args: Array[String]): Unit = {
        println(new TheCompare(Integer.valueOf(10), Integer.valueOf(20)).greater)
        
        println(new TheCompare(java.lang.Float.valueOf(10.1f), java.lang.Float.valueOf(20.1f)).greater)
        
        println(new TheCompare[java.lang.Float](10.1f, 20.1f).greater)
    }
}


// 传统方法的问题，这只是Int的比较，如果需要Float则需要再写一个
class CompareInt(
    val n1: Int, n2: Int
) {
    def greater: Int = if (n1 >= n2) n1 else n2
}

// 上界的方式 简单灵活
class TheCompare[T <: Comparable[T]](a: T, b: T) {
    def greater: T = if (a.compareTo(b) > 0) a else b
}


