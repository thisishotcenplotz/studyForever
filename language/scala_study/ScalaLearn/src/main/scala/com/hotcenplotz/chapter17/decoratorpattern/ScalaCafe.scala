package com.hotcenplotz.chapter17.decoratorpattern

import com.hotcenplotz.chapter17.decoratorpattern.coffee.{Americano, DeCaf}
import com.hotcenplotz.chapter17.decoratorpattern.recipe.{Chocolate, Milk, Soy}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:23 
 * @description:
 * */
object ScalaCafe {
    def main(args: Array[String]): Unit = {
        
        // Order 1
        val order1: DeCaf = new DeCaf
        
        // Order 2
        val order2 = new Chocolate(new Soy(new Milk(new Americano)))
        
        println(order1.getDescription())
        println(order1.cost())
        
        println(order2.getDescription())
        println(order2.cost())
    }
}
