package com.hotcenplotz.chapter07.oop_.fieldoverride_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 06:54 
 * @description: */
object ScalaOverride_ {
    def main(args: Array[String]): Unit = {
        val b: B = new B
        val b1: A = new B
        
        // 都是20
        println(b.age)
        println(b1.age)
    }
}

class A {
    val age: Int = 10 // 会生成public age()
    def salary(): Int = 100
    
}

class B extends A {
    override val age: Int = 20 // 也会生成public age()  实际上是方法的覆写
    
    override def salary(): Int = 200 // 可以覆写一个不带参数的def
}

//抽象字段
// 1. 抽象字段就是没有初始化的字段
// 2. 当一个类含有抽象属性时，则该类也必须是abstract的
// 3. 对于抽象的属性，在底层不会生成对应的属性声明，而是生成两个对应抽象方法（name，name_$eq() ）
abstract class AA {
    var name:String // 抽象属性
    var age:Int
}

class BB extends AA {
    // 1. 如果在子类中重写父类的抽象属性，本质上是实现了抽象方法
    // 2. 因此在这里可以写或不写 override 关键字
    override var name: String = ""
    var age:Int = 20
}