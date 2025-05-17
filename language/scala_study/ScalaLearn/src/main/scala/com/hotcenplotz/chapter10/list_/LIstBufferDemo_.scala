package com.hotcenplotz.chapter10.list_

import scala.collection.mutable.ListBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-17 08:30 
 * @description:
 * ListBuffer: 是可变的list集合，可以添加和删除元素，ListBuffer属于序列。
 * */
object LIstBufferDemo_ {
    def main(args: Array[String]): Unit = {
        // ListBuffer 就是 长度可变的List
        
        val listBuffer: ListBuffer[Int] = ListBuffer[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        
        // 增加元素
        (11 to 20).foreach(i => listBuffer.addOne(i))
        (21 to 30).foreach(i => listBuffer += i)
        println(listBuffer)
        
        listBuffer ++= (31 to 40).toList
        println(listBuffer)
        println("~~~~~~~~~~~~~~~~~~~~~~")
        // 删除元素
        listBuffer.remove(0) // 删除第一个元素
        listBuffer.remove(listBuffer.size -1) // 删除最后一个元素 时间复杂度最优
        println(listBuffer)
        
        println(listBuffer.dropRight(1)) // 返回一个新的ListBuffer 有内存开销
    }
}
