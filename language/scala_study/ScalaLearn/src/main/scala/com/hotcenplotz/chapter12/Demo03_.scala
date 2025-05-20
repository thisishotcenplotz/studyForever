package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 06:59 
 * @description: Match 中的变量
 * */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        val c:Char = 'V'
        
        c match {
            case '+' => println("ok")
            
            // 将c 赋值给myChar
            case myChar => println("ok~ " + myChar)
            case _ => println("ok")
        }
        
        // 在scala中match 可以有返回值
        val rst: Any = c match {
            case '+' => c + "Hello"
            case _ => println("ojbk")
        }
        
        println(rst)
    }
}
