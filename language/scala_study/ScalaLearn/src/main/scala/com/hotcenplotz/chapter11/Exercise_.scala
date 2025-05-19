package com.hotcenplotz.chapter11

import scala.collection.mutable.ArrayBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 20:32 
 * @description:
 * */
object Exercise_ {
    
    def main(args: Array[String]): Unit = {
        exercise02()
    }
    
    def exercise01():Unit = {
        val str = "AAAAAAAAAAAAAAABBBBBBBBCCCCCCCCCCCCCDDDDDDDDD"
        val arrbuf: ArrayBuffer[Char] = new ArrayBuffer[Char]()
        
        def temp(arr:ArrayBuffer[Char],c:Char):ArrayBuffer[Char] = {
            arr.append(c)
            arr
        }
        
        str.foldLeft(arrbuf)(temp)
        
        println(arrbuf)
    }
    
    def exercise02():Unit = {
        val str = "AAAAAAAAAAAAAAABBBBBBBBCCCCCCCCCCCCCDDDDDDDDD"

        def temp(m:Map[Char,Int],c:Char):Map[Char,Int] = {
            m + (c -> (m.getOrElse(c,0) + 1))
        }
        
        println(str.foldLeft(Map[Char, Int]())(temp))
    }
    
}
