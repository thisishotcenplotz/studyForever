package com.hotcenplotz.chapter17.observerpattern.observer_

import com.hotcenplotz.chapter17.observerpattern.local_.CurrentConditions

import scala.collection.mutable.ListBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 06:15 
 * @description:
 * */
class ObsWeatherData(
    private var temperature: Float = 0.0f, private var pressure: Float = 1013.25f, private var humidity: Float = 0.0f
) extends Subject {
    
    
    private val observers: ListBuffer[ObjectServer] = ListBuffer()
    
    def getTemperature: Float = temperature
    
    def getPressure: Float = pressure
    
    def getHumidity: Float = humidity
    
    def changeData(): Unit = {
        notifyObserver()
    }
    
    // 设置最新的天气情况的方法
    def setData(t:Float,p:Float,h:Float):Unit = {
        this.temperature = t
        this.pressure = p
        this.humidity = h
        
        // 修改公告板的update
        changeData()
    }
    
    override def register(o: ObjectServer): Unit = {
        observers.addOne(o)
    }
    
    override def remove(o: ObjectServer): Unit = {
        if(observers.contains(o)) observers -= o
    }
    
    override def notifyObserver():Unit = {
        observers.foreach{o =>
            o.update(getTemperature,getPressure,getHumidity)
        }
    }
    
    
}
