package com.hotcenplotz.chapter17.decoratorpattern.recipe

import com.hotcenplotz.chapter17.decoratorpattern.Drink

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:21 
 * @description:
 * */
class Soy(coffee: Drink) extends Recipe(coffee) {
    super.setDescription("Milk")
    super.setPrice(1.5)
}
