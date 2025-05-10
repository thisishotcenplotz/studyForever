package com.hotcenplotz.chapter06.exercise

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 11:51 
 * @description: 计算一个字符串中每一个字符的Unicode 的成绩
 */


object Exercise01_ {
    def main(args: Array[String]): Unit = {
        val data: String = "Hello,World"

        var rst:Long = 1
        data.foreach{ rst *= _.toLong}

        println(rst)

        println(recursiveSolution(data))

        println(recursiveSum((1 to 100000).toList))
    }

    def recursiveSolution(s:String):Long ={
        if(s.length == 1) s.charAt(0).toLong
        else s.take(1).charAt(0).toLong * recursiveSolution(s.drop(1))
    }

    def recursiveSum(i:List[Int],acc:Int = 0):Int = {
        if (i.isEmpty) acc
        else if  (i.length == 1) i.head
        else i.head + recursiveSum(i.tail,acc + i.head)
    }
}
