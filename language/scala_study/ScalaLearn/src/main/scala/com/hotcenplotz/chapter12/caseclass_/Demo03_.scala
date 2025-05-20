package com.hotcenplotz.chapter12.caseclass_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 07:26 
 * @description: case class copy demo
 * */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        val currency: Currency = Currency(3000, "RMB")
        
        val cur2: Currency = currency.copy(unit = "USD")
        
        println(cur2)
        println(currency)
    }
}
