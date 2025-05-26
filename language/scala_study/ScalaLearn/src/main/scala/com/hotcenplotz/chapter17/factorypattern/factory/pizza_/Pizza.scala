package com.hotcenplotz.chapter17.factorypattern.factory.pizza_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 06:08 
 * @description:
 * */

abstract class Pizza(
    val name:String
) {
    def prepare():Unit
    
    def cut():Unit = {
        println(s"${this.name} cutting...")
    }
    
    def bake():Unit = {
        println(s"${this.name} baking...")
    }
    
    def box():Unit = {
        println(s"${this.name} + boxing...")
    }
}
