package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 06:36 
 * @description: 模式匹配快速入门案例
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        val opr:String = "#"
        val n1:Int = 20
        val n2:Int = 10
        var res:Int = 0
        
        opr match {
            case "+" => res = n1 + n2
            case "-" => res = n1 - n2
            case "*" => res = n1 * n2
            case "/" => res = n1 / n2
            case _ => println("error...")
        }
        
        println(res)
    }
}
