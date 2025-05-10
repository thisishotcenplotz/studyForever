package com.hotcenplotz.chapter06.constructor_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 17:35 
 * @description:
 */


class PrivateDemo private(name:String,age:Int) {

    def this(name:String) {
        this(name,10)
        println(s"Hello $name")
    }
}
