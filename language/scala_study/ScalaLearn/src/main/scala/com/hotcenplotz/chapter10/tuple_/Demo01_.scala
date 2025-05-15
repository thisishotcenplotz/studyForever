package com.hotcenplotz.chapter10.tuple_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-16 06:04 
 * @description: Scala中的Tuple
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 创建一个Tuple
        // 1. 这个Tuple的类型是Tuple4
        // 2. 为了高效的操作元组，编译器根据元素的个数不同，对应不同的元组类型
        // 分别是 Tuple1 ~ 22
        val tuple: (Int, String, String, Int) = (1, "2", "hello", 5)
        
        // 元组的访问
        //访问元组的第一个元素。
        println(tuple._1)
        println(tuple.productElement(0))
        
        // 元组的遍历 -> 需要调用迭代器
        for(i<- tuple.productIterator){
            println(i)
        }
        
        tuple.productIterator.foreach(println)
    }
}
