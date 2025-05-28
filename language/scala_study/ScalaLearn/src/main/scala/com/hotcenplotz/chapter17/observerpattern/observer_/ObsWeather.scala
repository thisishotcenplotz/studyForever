package com.hotcenplotz.chapter17.observerpattern.observer_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 06:32 
 * @description:
 * */
object ObsWeather {
    def main(args: Array[String]): Unit = {
        val conditions = new ObsCurConditions()
        val data = new ObsWeatherData()
        
        data.register(conditions)
        data.register(new ObsCurConditions())
        
        data.setData(10,20,30)
    }
}
