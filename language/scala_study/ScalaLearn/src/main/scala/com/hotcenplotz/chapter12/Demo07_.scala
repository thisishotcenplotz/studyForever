package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 05:51 
 * @description: 对象匹配
 * */
object Demo07_ {
    def main(args: Array[String]): Unit = {
        val number:Double = 36.0
        
        //模式匹配
        number match {
            // 说明：
            // 1. 当匹配到case Square(n)
            // 2. 调用Square 的unapply方法，值就是number
            // 3. 如果对象提取器unapply(z:Double) 返回的是Some(6)则表示匹配成功，
            //    同时把6赋给Square(n) 的  n
            case Square(n) => println(n)
            case _ => println("nothing matched")
        }
    }
}

object Square {
    def apply(z:Double):Double = z * z
    
    // unapply方法是对象提取器
    def unapply(z:Double):Option[Double] = Some(math.sqrt(z))
}