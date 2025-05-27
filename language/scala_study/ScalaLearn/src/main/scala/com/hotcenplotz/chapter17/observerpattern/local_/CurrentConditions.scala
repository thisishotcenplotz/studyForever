package com.hotcenplotz.chapter17.observerpattern.local_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 20:22 
 * @description:
 * */
class CurrentConditions(
    private var temperature: Float = 0.0f, private var pressure: Float = 1013.25f, private var humidity: Float = 0.0f
) {
    
    def display(): Unit = {
        println(s"***Today temperature: $temperature ***")
        println(s"***Today pressure: $pressure ***")
        println(s"***Today humidity: $humidity ***")
    }
    
    def update(t: Float, p: Float, h: Float): Unit = {
        this.temperature = t
        this.pressure = p
        this.humidity = h
        
        this.display()
    }
}
