package com.hotcenplotz.chapter07.oop_.extends_

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-11 16:12 
 * @description: */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        val student: Student = new Student
        student.name = "zhangsan"
        student.age = 10
        student.showInfo()
        student.study()
    }
}


class Person {
    var name: String = ""
    var age: Int = 0 // 添加默认值
    
    def showInfo(): Unit = {
        println(s"name: $name \t age: $age")
    }
}

class Student extends Person {
    
    override def showInfo(): Unit = {
        println(s"Student name: $name \t Student age: $age")
    }
    
    def study(): Unit = {
        println(s"$name is studying Scala")
    }
}