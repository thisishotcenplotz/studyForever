package com.hotcenplotz.chapter17.singletonpattern

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:49 
 * @description:
 * */
private class EagerInitialization private(){
    
}

object EagerInitialization {
    val instance: EagerInitialization = new EagerInitialization
    
    def get():EagerInitialization = instance
}
