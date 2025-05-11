package com.hotcenplotz.chapter07.oop_.abstract_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 07:27 
 * @description:
 * */
object Demo_ {
    def main(args: Array[String]): Unit = {
        // 动态实例化Animal
        // 默认情况下抽象类是不能实例化时，
        // 但是实例化时，动态实现了所有的抽象方法，也是可以的。
        val animal: Animal = new Animal {
            override var name: String = "Li si"
            override var age: Int = 10
            
            override def cry(): Unit = println(s"动态实例化抽象类")
        }
        
        animal.cry()
        println(animal.color)
        
        // 匿名子类
        val dog: Animal = new Animal {
            override var name: String = "dog"
            override var age: Int = 10
            
            override def cry(): Unit = s"小狗旺旺叫~~~"
        }
        
        dog.cry()
    }
}

abstract class Animal {
    var name: String
    var age: Int
    var color: String = "black" // 普通字段
    
    def cry(): Unit //不需要标记abstract 关键字
}

class Dog extends Animal {
    override var name: String = "Zhang san"
    override var age: Int = 10
    
    override def cry(): Unit = println(s"小狗[$name]: 旺旺旺~~~")
}