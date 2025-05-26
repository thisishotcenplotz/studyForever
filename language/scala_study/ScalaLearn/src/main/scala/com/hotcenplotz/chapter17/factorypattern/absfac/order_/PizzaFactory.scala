package com.hotcenplotz.chapter17.factorypattern.absfac.order_

import com.hotcenplotz.chapter17.factorypattern.absfac.pizza_.Pizza

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:23 
 * @description:
 * */

trait PizzaFactory {
    def createPizza(name:String):Pizza
}
