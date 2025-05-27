package com.hotcenplotz.chapter17.singletonpattern

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:50 
 * @description:
 * */
class LazyInitialization private() {
    
}

object LazyInitialization {
    private var instance:LazyInitialization = null
    
    def get():LazyInitialization = {
        if(instance == null){
            instance = new LazyInitialization()
        }
        instance
    }
}