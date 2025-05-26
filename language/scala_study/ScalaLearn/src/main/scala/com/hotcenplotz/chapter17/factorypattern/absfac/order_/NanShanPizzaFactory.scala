package com.hotcenplotz.chapter17.factorypattern.absfac.order_

import com.hotcenplotz.chapter17.factorypattern.absfac.pizza_.{Pizza, NanShanCheesePizza, NanShanPepperPizza}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:24 
 * @description:
 * */
class NanShanPizzaFactory extends PizzaFactory {
    
    override def createPizza(name: String): Pizza = {
        name.toLowerCase match {
            case "greek" => new NanShanCheesePizza("greek")
            case "pepper" => new NanShanPepperPizza("pepper")
            case "cheese" => new NanShanCheesePizza("cheese")
            case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
        }
    }
}
