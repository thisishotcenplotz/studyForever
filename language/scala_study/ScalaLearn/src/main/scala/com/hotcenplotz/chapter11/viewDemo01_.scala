package com.hotcenplotz.chapter11

import scala.collection.View

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 05:36 
 * @description: view Demo
 * 1. view 可以产生一个总是被懒执行的集合
 * 2. view 不会缓存数据，每次都会重新计算
 *
 * */

object viewDemo01_ {
    def main(args: Array[String]): Unit = {
        // 没使用view
        val oddNumsNormal: List[Int] = (1 to 1000).toList.filter(num => num.toString.equals(num.toString.reverse))
        
        // 使用view
        val oddNumsView: View[Int] = (1 to 1000).view.filter(num => num.toString.equals(num.toString.reverse))
        println(oddNumsView) // 懒加载了
        oddNumsView.foreach(println)
    }
}
