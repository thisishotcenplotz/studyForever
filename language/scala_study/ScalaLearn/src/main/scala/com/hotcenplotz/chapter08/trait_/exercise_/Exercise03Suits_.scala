package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:20 
 * @description: */
object Exercise03Suits_ extends Enumeration {
    type Exercise03Suits_ = Value
    
    val Spade = Value("♠")
    val Club = Value("♣")
    val Heart = Value("♥")
    val Diamond = Value("♦")
    
    override def toString(): String = {
        Exercise03Suits_.values.mkString(",")
    }
}
