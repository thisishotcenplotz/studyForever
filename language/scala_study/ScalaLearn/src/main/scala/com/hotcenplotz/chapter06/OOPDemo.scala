package com.hotcenplotz.chapter06

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 11:10 
 * @description:
 */


object OOPDemo {
    def main(args: Array[String]): Unit = {
        val cat: Cat = new Cat
        cat.name = "zhang san"
        cat.age = 10
        cat.color = "black"

    }
}


class Cat {
    var name:String = "" // 给初始值
    var age:Int = _ // _ 表示默认值，默认为0
    var color:String = _ // ""

}
