package com.hotcenplotz.chapter03

import scala.io.StdIn

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 06:11 
 * @description: 对标Java Scanner 在Scala中的使用方法
 */


object Demo05_ {
    def main(args: Array[String]): Unit = {
        print("请输入姓名:")
        val name: String = StdIn.readLine()

        print("请输入年龄:")
        val age: Int = StdIn.readInt()
    }
}
