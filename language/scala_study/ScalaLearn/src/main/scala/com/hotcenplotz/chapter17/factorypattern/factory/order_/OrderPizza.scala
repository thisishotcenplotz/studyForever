package com.hotcenplotz.chapter17.factorypattern.factory.order_

import com.hotcenplotz.chapter17.factorypattern.factory.pizza_
import com.hotcenplotz.chapter17.factorypattern.factory.pizza_.Pizza

import scala.io.StdIn
import scala.util.control.Breaks.breakable

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:21 
 * @description:
 * */
abstract class OrderPizza(
    var orderType: String = "", var pizza: pizza_.Pizza = null
) {
    breakable {
        do {
            print("请输入:")
            orderType = StdIn.readLine()
            
            pizza = this.createPizza(orderType)
            
            pizza.prepare()
            pizza.bake()
            pizza.cut()
            pizza.box()
        } while (true)
    }
    
    def createPizza(name:String):Pizza
}
