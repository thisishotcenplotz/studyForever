package com.hotcenplotz.chapter17.factorypattern.factory.order_
import com.hotcenplotz.chapter17.factorypattern.factory.pizza_.{Pizza, ShenzhenCheesePizza, ShenzhenPepperPizza}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:07 
 * @description:
 * */
class ShenzhenOrderPizza extends OrderPizza {
    
    override def createPizza(name: String): Pizza = {
        name.toLowerCase match {
            case "greek" => new ShenzhenCheesePizza("greek")
            case "pepper" => new ShenzhenPepperPizza("pepper")
            case "cheese" => new ShenzhenCheesePizza("cheese")
            case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
        }
    }
}
