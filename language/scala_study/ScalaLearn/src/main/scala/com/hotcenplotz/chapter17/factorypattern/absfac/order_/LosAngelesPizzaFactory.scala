package com.hotcenplotz.chapter17.factorypattern.absfac.order_

import com.hotcenplotz.chapter17.factorypattern.absfac.pizza_.{LosAngelesCheesePizza, LosAngelesPepperPizza, Pizza}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:24 
 * @description:
 * */
class LosAngelesPizzaFactory extends PizzaFactory {
    
    override def createPizza(name: String): Pizza = {
        name.toLowerCase match {
            case "greek" => new LosAngelesCheesePizza("greek")
            case "pepper" => new LosAngelesPepperPizza("pepper")
            case "cheese" => new LosAngelesCheesePizza("cheese")
            case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
        }
    }
}
