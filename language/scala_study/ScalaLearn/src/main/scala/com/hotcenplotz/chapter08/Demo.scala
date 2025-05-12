package com.hotcenplotz.chapter08

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 21:13 
 * @description: 伴生对象Demo
 * */
object Demo {
    def main(args: Array[String]): Unit = {
        val c1: Child = new Child("白骨精")
        val c2: Child = new Child("蜘蛛精")
        val c3: Child = new Child("黄鼠狼精")
        
        Child.joinGame(c1)
        Child.joinGame(c2)
        Child.joinGame(c3)
        
        Child.showTotalChild()
        
        // apply
        val c4: Child = Child("唐僧")
        val c5: Child = Child()
        println(c5.name)
    }
}

class Child(
    var name: String
) {}

object Child {
    private var totalChild: Int = 0
    
    def joinGame(child: Child): Unit = {
        totalChild += 1
        println(s"${child.name} joined!")
    }
    
    def showTotalChild(): Unit = println(s"total children number is $totalChild")
    
    // apply 方法 : 用于实例化
    def apply(name: String): Child = {
        println("apply 方法被调用")
        new Child(name)
    }
    
    def apply(): Child = new Child("匿名的猪八戒")
}
