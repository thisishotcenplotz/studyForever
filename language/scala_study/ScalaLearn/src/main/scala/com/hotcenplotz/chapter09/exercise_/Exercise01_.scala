package com.hotcenplotz.chapter09.exercise_

import java.awt.geom.Ellipse2D

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-15 05:59 
 * @description: 使用trait来扩展一个类，再使用混入的方式来增加功能
 * */
object Exercise01_ {
    def main(args: Array[String]): Unit = {
        val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
        println(s"${egg.x} -> ${egg.y}")
        
        egg.translate(10, -10)
        println(s"${egg.x} -> ${egg.y}")
        
        egg.grow(5, -5)
        println(s"${egg.x} -> ${egg.y}")
        
    }
}

trait RectangleLike { // 自身类型写法
    this: Ellipse2D.Double =>
    
    def translate(x: Double, y: Double): Unit = {
        this.x = x
        this.y = y
    }
    
    def grow(x: Double, y: Double): Unit = {
        this.x += x
        this.y += y
    }
}


// 传统写法
trait RectangleLike2 extends Ellipse2D.Double {
    
    def translate(x: Double, y: Double): Unit = {
        this.x = x
        this.y = y
    }
    
    def grow(x: Double, y: Double): Unit = {
        this.x += x
        this.y += y
    }
}