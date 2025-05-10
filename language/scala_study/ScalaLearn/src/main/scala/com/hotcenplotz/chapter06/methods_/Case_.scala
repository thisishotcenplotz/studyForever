package com.hotcenplotz.chapter06.methods_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 16:07 
 * @description:
 */


object Case_ {
    def main(args: Array[String]): Unit = {
        val dog: Dog = new Dog
        dog.say()
    }
}

class Dog {
    var name:String = ""
    var age:Int = 0
    var weight:Double = 0.0

    def say():Unit = {
        println(s" $name $age $weight")
    }
}


