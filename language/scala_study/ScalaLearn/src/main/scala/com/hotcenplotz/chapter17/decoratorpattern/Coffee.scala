package com.hotcenplotz.chapter17.decoratorpattern

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:04 
 * @description:
 * */
class Coffee extends Drink {
    
    override def cost(): Double = super.getPrice()
}
