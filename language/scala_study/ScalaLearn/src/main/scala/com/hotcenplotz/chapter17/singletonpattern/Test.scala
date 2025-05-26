package com.hotcenplotz.chapter17.singletonpattern

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 07:53 
 * @description:
 * */
object Test {
    def main(args: Array[String]): Unit = {
        
        LazyInitialization.get()
        EagerInitialization.get()
    }
}
