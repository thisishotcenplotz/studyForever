package com.hotcenplotz.chapter17.decoratorpattern.recipe

import com.hotcenplotz.chapter17.decoratorpattern.Drink

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:14 
 * @description:
 * */
class Recipe extends Drink {
    private var coffee: Drink = null
    
    def this(coffee: Drink) {
        this
        this.coffee = coffee
    }
    
    
    override def cost(): Double = super.getPrice() + coffee.cost()
    
    override def getDescription(): String = super.getDescription() + " && " + coffee.getDescription()
}
