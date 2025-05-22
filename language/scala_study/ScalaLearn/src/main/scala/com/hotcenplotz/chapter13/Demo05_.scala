package com.hotcenplotz.chapter13

import java.util.StringTokenizer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-23 07:24 
 * @description: 函数的柯里化
 * */
object Demo05_ {
    def main(args: Array[String]): Unit = {
        
        def addSome(x: Int, y: Int, z: Int): Int = x + y + z
        
        // 柯里化
        def addSomeCurry(x: Int)(y: Int)(z: Int): Int = x + y + z
        
        println(addSome(1, 2, 3))
        println(addSomeCurry(1)(2)(3))
        
        aComplicatedDemo()
    }
    
    def aComplicatedDemo(): Unit = {
        
        // 创建一个隐式类
        // 相当于临时给String 添加了一个方法叫做 checkEq
        implicit class MyClass(s: String) {
            def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
                f(s.toLowerCase, ss.toLowerCase)
            }
        }
        
        def myEq(s1: String, s2: String): Boolean = s1.equals(s2)
        
        val s:String = "Hello"
        println(s.checkEq("HelLO")(myEq))
        println(s.checkEq("hELlo")(_.equals(_)))
    }
}
