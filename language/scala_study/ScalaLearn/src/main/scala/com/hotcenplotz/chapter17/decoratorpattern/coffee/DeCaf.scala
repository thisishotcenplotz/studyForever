package com.hotcenplotz.chapter17.decoratorpattern.coffee

import com.hotcenplotz.chapter17.decoratorpattern.Coffee

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 19:06 
 * @description:
 * */
class DeCaf extends Coffee{
    super.setDescription("DeCaf")
    super.setPrice(3.0)
}
