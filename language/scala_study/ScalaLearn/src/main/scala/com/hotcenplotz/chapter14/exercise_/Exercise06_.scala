package com.hotcenplotz.chapter14.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-26 21:52 
 * @description:
 * */
object Exercise06_ {
    def main(args: Array[String]): Unit = {
        println(theMax((1 to 100).toList))
        println(factorial(10))
        println(largest(x => x + 1, (1 to 5).toList))
    }
    
    def theMax(list:List[Int]):Int = {
        list.reduce((a,b) => if(a >= b) a else b)
    }
    
    def factorial(n:Int):Int = (1 to n).toList.reduceLeft(_ * _)
    
    def largest(f:Int => Int,inputs:List[Int]):Int = {
        inputs.map(f).reduce((a,b) => if(a >= b) a else b)
    }
}
