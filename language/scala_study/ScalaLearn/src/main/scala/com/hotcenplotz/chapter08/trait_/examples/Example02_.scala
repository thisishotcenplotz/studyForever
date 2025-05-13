package com.hotcenplotz.chapter08.trait_.examples

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 06:50 
 * @description: */
object Example02_ {
    def main(args: Array[String]): Unit = {
        val sheep = new Sheep
        
        sheep.sayHi()
        sheep.sayHello()
        
        println(sheep(1, 2, 3, 4, 5, 6, 7, 8, 1, 1))
    }
}

trait Trait02 {
    // 抽象方法
    def sayHi()
    
    // 具体方法
    def sayHello():Unit = println("say hello~")
}


class Sheep extends Trait02{
    override def sayHi(): Unit = println("Sheep say hi~")
    
    override def sayHello(): Unit = {
        print("Sheep ")
        super.sayHello()
    }
    
    def apply(args: Int*): Int = args.sum
}