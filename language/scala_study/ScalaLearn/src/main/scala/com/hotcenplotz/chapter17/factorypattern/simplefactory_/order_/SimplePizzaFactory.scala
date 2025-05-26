package com.hotcenplotz.chapter17.factorypattern.simplefactory_.order_

import com.hotcenplotz.chapter17.factorypattern.simplefactory_.pizza_.{CheesePizza, GreekPizza, PepperPizza, Pizza}

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:35 
 * @description:
 * */

object SimplePizzaFactory {
    def createPizza(name:String):Pizza  = name.toLowerCase match {
        case "greek" => new GreekPizza(name)
        case "pepper" => new PepperPizza("pepper")
        case "cheese" => new CheesePizza("cheese")
        case _ => throw new IllegalArgumentException(s"Invalid pizza type $name")
    }
}
