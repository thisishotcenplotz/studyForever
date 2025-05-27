package com.hotcenplotz.chapter17.decoratorpattern.coffee

import com.hotcenplotz.chapter17.decoratorpattern.Coffee

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:08 
 * @description:
 * */
class Latte extends Coffee{
    super.setDescription("Latte")
    super.setPrice(6.5)
}
