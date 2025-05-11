package com.hotcenplotz.chapter07.oop_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 05:26 
 * @description:
 * */
object Convert_ {
    def main(args: Array[String]): Unit = {
        
        // ClassOf 可以得到类名
        println(classOf[String])
        println("Hello".getClass.getName) // 使用反射机制
        
        // is/asInstanceOf
        var p: Person200 = new Person200
        var e: Employee200 = new Employee200
        
        val p1: Person200 = e.asInstanceOf[Person200]
        val e1: Employee200 = p.asInstanceOf[Employee200]
        
    }
}

class Person200 {
    var name:String = "zhang san"
    def printName():Unit = println(s"Person100 printName() $name")
    def sayHi():Unit = println("sayHi.")
}

class Employee200 extends Person200 {
    override def printName(): Unit = {
        println(s"Employee200 printName() $name")
        super.printName()
        sayHi()
    }
}