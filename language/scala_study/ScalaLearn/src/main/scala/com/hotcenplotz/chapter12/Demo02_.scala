package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 06:43 
 * @description: 条件守卫
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        for(c <- "-*/="){
            var sign:Int = 0
            var digit:Int = 0
            
            c match {
                case '+' => sign = 1
                case '-' => sign = -1
                // case 守卫
                case _ if c.toString.equals("3") => digit = 3
                case _ if c > 10 => println("ch > 10")
                case _ => sign = 2
            }
            println(s"$c $sign $digit")
        }
    }
}
