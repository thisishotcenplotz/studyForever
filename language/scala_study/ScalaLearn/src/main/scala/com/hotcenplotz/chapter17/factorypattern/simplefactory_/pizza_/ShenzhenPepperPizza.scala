package com.hotcenplotz.chapter17.factorypattern.simplefactory_.pizza_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:20 
 * @description:
 * */
class ShenzhenPepperPizza(name:String) extends Pizza(name){
    
    override def prepare(): Unit = println(this.name)
}
