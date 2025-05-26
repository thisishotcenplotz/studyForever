package com.hotcenplotz.chapter17.factorypattern.factory.pizza_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:42 
 * @description:
 * */
class ShenzhenCheesePizza(name:String) extends Pizza(name) {
    
    override def prepare(): Unit = {
        println(this.name)
    }
}
