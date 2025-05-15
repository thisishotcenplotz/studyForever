package com.hotcenplotz.chapter10.list_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-16 06:43 
 * @description:
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 默认List是scala.collection.immutable.List
        // List 在scala 包中也做了定义和说明，所以不需要单独导包
        // Nil 代表一个空集合 即 List()
        val list: List[Any] = List("1", 2, "Hello")
        val l: List[Any] = Nil
        
        // List元素访问
        println(list(0))
        println(list(1))
        
        // 元素的追加
        val list1: List[Any] = list :+ 3
        val list2: List[Any] = "Hello" +: list1
        println(list1)
        println(list2)
        
        // 向集合增加集合中的元素
        // :: -> 向空List中一次添加元素，顺序是从右向左
        val list3: List[Any] = list1 :: list2 // List(List(1, 2, Hello, 3), Hello, 1, 2, Hello, 3)
        println(list3)
        
        // 合并两个结合； 顺序也是从右向左
        val list4: List[Any] = list1 ::: list2 // List(1, 2, Hello, 3, Hello, 1, 2, Hello, 3)
        println(list4)
        
    }
}
