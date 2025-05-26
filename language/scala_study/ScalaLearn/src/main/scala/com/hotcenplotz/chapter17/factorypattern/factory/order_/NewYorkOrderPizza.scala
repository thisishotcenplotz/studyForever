package com.hotcenplotz.chapter17.factorypattern.factory.order_

import com.hotcenplotz.chapter17.factorypattern.factory.pizza_.{NewYorkCheesePizza, NewYorkPepperPizza, Pizza, ShenzhenCheesePizza, ShenzhenPepperPizza}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:07 
 * @description:
 * */
class NewYorkOrderPizza extends OrderPizza {
    
    override def createPizza(name: String): Pizza = {
        name.toLowerCase match {
            case "greek" => new NewYorkCheesePizza("greek")
            case "pepper" => new NewYorkPepperPizza("pepper")
            case "cheese" => new NewYorkCheesePizza("cheese")
            case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
        }
    }
}
