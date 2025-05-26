package com.hotcenplotz.chapter17.factorypattern.absfac.order_

import com.hotcenplotz.chapter17.factorypattern.absfac.pizza_.Pizza

import scala.io.StdIn
import scala.util.control.Breaks.breakable

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:21 
 * @description:
 * */
class OrderPizza {
    
    def this(factory:PizzaFactory) = {
        this
        
        breakable {
            do {
                print("请输入:")
                val orderType:String = StdIn.readLine()
                
                val pizza:Pizza = factory.createPizza(orderType)
                
                pizza.prepare()
                pizza.bake()
                pizza.cut()
                pizza.box()
            } while (true)
        }
    }
    
}
