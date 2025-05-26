package com.hotcenplotz.chapter17.factorypattern.simplefactory_.order_

import com.hotcenplotz.chapter17.factorypattern.simplefactory_.pizza_.{GreekPizza, PepperPizza, Pizza}

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:21 
 * @description:
 * */
class OrderPizza(
    var orderType: String = "", var pizza: Pizza = null
) {
    breakable {
        do {
            print("请输入:")
            orderType = StdIn.readLine()
            
            pizza = SimplePizzaFactory.createPizza(orderType)
            
            pizza.prepare()
            pizza.bake()
            pizza.cut()
            pizza.box()
        } while (true)
    }
}
