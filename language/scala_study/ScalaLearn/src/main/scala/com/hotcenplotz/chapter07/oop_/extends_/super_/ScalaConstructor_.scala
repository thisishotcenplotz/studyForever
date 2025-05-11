package com.hotcenplotz.chapter07.oop_.extends_.super_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 06:06 
 * @description: */
object ScalaConstructor_ {
    def main(args: Array[String]): Unit = {
        val lisi: Lisi = new Lisi("lisi")
        
        val wangwu = new Wangwu("wangwu",5)
        
        
    }
}

class Zhangsan(var name: String) {
    println("zhang san ~~~")
    
    def this() {this("zhang san")}
}

class Lisi extends Zhangsan {
    
    println("Li si ~~~")
    
    def this(name: String) {
        this
        this.name = "Li si ~~~"
        println("Lisi辅助构造器")
    }
}

class Wangwu(name:String,var age: Int) extends Zhangsan(name) {
}