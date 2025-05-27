package com.hotcenplotz.chapter17.decoratorpattern

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:00 
 * @description:
 * */
abstract class Drink {
    var description: String = null
    private var price = 0.0
    
    def setDescription(description: String): Unit = {
        this.description = description
    }
    
    def getDescription(): String = {
        description + " 价格： " + this.getPrice()
    }
    
    def getPrice(): Double = price
    
    def setPrice(price: Double): Unit = {
        this.price = price
    }
    
    def cost(): Double
}
