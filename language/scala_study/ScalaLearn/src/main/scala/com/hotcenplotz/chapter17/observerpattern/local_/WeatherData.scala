package com.hotcenplotz.chapter17.observerpattern.local_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-27 20:13 
 * @description:
 * */
// 这个类可以理解为气象局维护的，提供天气情况数据的核心类
class WeatherData(
    private var temperature: Float = 0.0f, private var pressure: Float = 1013.25f, private var humidity: Float = 0.0f, private var currentConditions: CurrentConditions = null
) {
    def this(current: CurrentConditions) = {
        this
        this.currentConditions = current
    }
    
    def getTemperature: Float = temperature
    
    def getPressure: Float = pressure
    
    def getHumidity: Float = humidity
    
    def changeData(): Unit = {
        currentConditions.update(getTemperature, getPressure, getHumidity)
    }
    
    // 设置最新的天气情况的方法
    def setData(t:Float,p:Float,h:Float):Unit = {
        this.temperature = t
        this.pressure = p
        this.humidity = h
        
        // 修改公告板的update
        changeData()
    }
    
}
