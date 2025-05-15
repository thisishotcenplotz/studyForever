package com.hotcenplotz.chapter10

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-15 07:58 
 * @description: 变长数组
 * */
object ArrayBufferDemo01_ {
    def main(args: Array[String]): Unit = {
        // 创建泛型为Any的ArrayBuffer，并给初始值1，2，3
        val arr: ArrayBuffer[Any] = ArrayBuffer[Any](1,2,3)
        
        // 追加；
        // 每次增加后，实际上进行了扩容，返回一个新的ArrayBuffer，效率不高
        arr.addOne(1)
        println(arr.hashCode())
        arr.addAll(List(1,2,3,4,5))
        println(arr.hashCode())
        
        // 删除：
        arr.remove(0)
        arr.remove(0,2) // 从0开始，删2个
        
        // 修改
        arr(0) = -1
        
        // 改成定长数组
        val fixArr: Array[Any] = arr.toArray
        
        //改回变长数组
        val backToArr: mutable.Buffer[Any] = fixArr.toBuffer
        
        println(arr.mkString("; "))
    }
}
