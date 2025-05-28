package com.hotcenplotz.chapter17.observerpattern.local_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 05:51 
 * @description:
 * */
object Weather {
    def main(args: Array[String]): Unit = {
        val currentConditions = new CurrentConditions()
        val weatherData = new WeatherData(currentConditions)
        weatherData.setData(30,150,40)
    }
}
