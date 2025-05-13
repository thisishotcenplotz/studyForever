package com.hotcenplotz.chapter08.mixin_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 21:22 
 * @description: */
object Demo03_ {
    def main(args: Array[String]): Unit = {
        val temp = new Temp with toOSS with toDB
        temp.insert(666)
    }
}

trait Test03{
    def insert(id:Int)
}

trait toDB extends Test03 {
    
    // 说明
    // 1. 如果我们在一个特质中重写/实现一个父特质的抽象方法，但是同时调用了super
    // 2. 这时我们的方法不是完全实现，因此需要声明为 abstract override
    // 3. 这时，super.insert(id) 的调用就和动态混入的顺序有密切的关系
    abstract override def insert(id: Int): Unit = {
        println("保存到数据库")
        super.insert(id)
    }
}

trait toOSS extends Test03{
    def insert(id: Int): Unit = {
        println("放进数据库")
    }
}

class Temp {}
