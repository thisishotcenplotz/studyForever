package com.hotcenplotz.chapter14.whyrecursive

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 11:18 
 * @description:
 * */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        val str: String = "abcdefghijklmnopqrstuvwxyz"
        
        def myReverse(xs:String):String = {
            if  (xs.length == 1) xs
            else  myReverse(xs.tail) + xs.head
        }
        
        def myFactorial(n: Int): BigInt = {
            if (n == 0) 1
            else n * myFactorial(n - 1)
        }
        
        println(myReverse(str))
        
        println(myFactorial(100))
    }
}
