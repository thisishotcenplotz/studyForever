package com.hotcenplotz.chapter07.oop_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 05:37 
 * @description: */
object ConvertBestPractice_ {
    def main(args: Array[String]): Unit = {
        val p = new Person300
        val e = new Employee300
        val s = new Student300
        
        test(p)
        test(e)
        test(s)
        
    }
    
    def test(p:Person300):Unit = {
        if(p.isInstanceOf[Employee300]) p.asInstanceOf[Employee300].showInfo()
        else if (p.isInstanceOf[Student300]) p.asInstanceOf[Student300].cry()
        else p.printName()
    }
}

class Person300 {
    var name:String = "zhang san"
    def printName():Unit = println(s"Person300 printName() $name")
    def sayOk():Unit = println("sayOk.")
}

class Student300 extends Person300 {
    private val stuId:Int = 100
    override def printName(): Unit = {
        println(s"Student300 printName() $name")
        super.printName()
        sayOk()
    }
    
    def cry():Unit = println(s"Student ID: $stuId")
}

class Employee300 extends Person300 {
    private val EmpID:Int = 200
    
    override def printName(): Unit = {
        println(s"Employee300 printName() $name")
        super.printName()
        sayOk()
    }
    
    def showInfo():Unit = println(s"Employee ID: $EmpID")
    
}
