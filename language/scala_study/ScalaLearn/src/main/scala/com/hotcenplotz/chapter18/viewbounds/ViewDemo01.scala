package com.hotcenplotz.chapter18.viewbounds

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-31 15:08 
 * @description: 视图界定案例
 * */
object ViewDemo01 {
    def main(args: Array[String]): Unit = {
        // 这样可以跑通  因为使用了隐式转换
        println(new ViewCompareDemo(1, 20).greater)
    }
}

// 说明：
// T <% Comparable[T] 与 T <: Comparable[T]  的区别是，前者支持隐式转换
class ViewCompareDemo[T <% Comparable[T]](obj1: T, obj2: T) {
    def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}