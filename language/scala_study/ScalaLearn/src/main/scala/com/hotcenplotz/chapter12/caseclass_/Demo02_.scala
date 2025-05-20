package com.hotcenplotz.chapter12.caseclass_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 07:14 
 * @description:
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        val amounts: Array[Amount] = Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)
        
        for(amt <- amounts){
            val rst: String = amt match {
                case Dollar(v) => "$" + v
                case Currency(u, v) => u + " " + v
                case NoAmount => ""
                case _ => "..."
            }
            println(s"${amt.toString}:  $rst")
        }
        
        
    
    }
}
