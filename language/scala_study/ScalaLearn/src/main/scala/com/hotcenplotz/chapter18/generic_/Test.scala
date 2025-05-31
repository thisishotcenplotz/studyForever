package com.hotcenplotz.chapter18.generic_

import com.hotcenplotz.chapter18.generic_.Season.Season

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 07:49 
 * @description:
 * */
object Test {
    def main(args: Array[String]): Unit = {
        // Case One
        println(new IntMessage[Int](19).getMessage)
        println(new StringMessage[String]("Hello World").getMessage)
        
        // case two
        val advancedClass = new SwimmingClass[Season, String, String](Season.Sprint, "Advanced Training", "freestyle")
        println(advancedClass)
        
        // case three
        println(getMidElement(List("Dog", "Cat", "Bird")))
        println(getMidElement(List(1, 2, 3, "bird")))
    }
    
    // case three
    def getMidElement[A](lst:List[A]):A = {
        lst(lst.length/2)
    }
}

class SwimmingClass[S,N,T](
    val classSeason:S,
    val className:N,
    val classType:T
){
    override def toString: String = s"$className -> $classType -> $classSeason"
}

object Season extends Enumeration {
    type Season = Value
    val Sprint,Summer,Autumn,Winter = Value
}