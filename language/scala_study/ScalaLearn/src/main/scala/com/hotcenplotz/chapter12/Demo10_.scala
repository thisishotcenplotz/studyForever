package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 07:31 
 * @description:
 * */
object Demo10_ {
    def main(args: Array[String]): Unit = {
        
        List(1,3,5,9) match {
            case first :: second :: rest => println(s"$first --> $second --> ${rest.length}")
            case _ => println("no matched")
        }
    }
}
