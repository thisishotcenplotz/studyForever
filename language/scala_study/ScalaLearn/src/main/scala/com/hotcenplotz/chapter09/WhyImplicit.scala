package com.hotcenplotz.chapter09

import scala.language.implicitConversions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 07:51 
 * @description: 为什么需要隐式转换的案例
 * */
object WhyImplicit {
    def main(args: Array[String]): Unit = {
        // val num:Int =3.5   // 不对！高精度 -> 低精度
        
        // Double -> Int 的隐式转换函数
        implicit def intToDouble(d:Double):Int = d.toInt
        implicit def floatToInt(f:Float):Int = f.toInt
        
        val num:Int = 3.5 // 这样就OK了。很方便，啥也不用操心。
        val num2:Int = 3.5f
    }
}
