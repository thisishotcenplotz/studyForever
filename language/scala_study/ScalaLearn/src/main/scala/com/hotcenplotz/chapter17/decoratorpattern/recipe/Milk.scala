package com.hotcenplotz.chapter17.decoratorpattern.recipe

import com.hotcenplotz.chapter17.decoratorpattern.Drink

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:20 
 * @description:
 * */
class Milk(coffee:Drink) extends Recipe (coffee){
    super.setDescription("Coffee")
    super.setPrice(2.0)
}
