package com.hotcenplotz.chapter17.decoratorpattern.coffee

import com.hotcenplotz.chapter17.decoratorpattern.Coffee

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:07 
 * @description:
 * */
class Americano extends Coffee{
    super.setDescription("Americano")
    super.setPrice(3.5)
}
