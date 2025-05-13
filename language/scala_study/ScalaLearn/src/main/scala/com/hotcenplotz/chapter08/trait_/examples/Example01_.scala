package com.hotcenplotz.chapter08.trait_.examples

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 06:43 
 * @description: trait 基本示例代码
 *
 * */
object Example01_ {
    
}
// trait
trait Trait01 {
    // 定义一个规范
    def getConnect()
    
}


// 六个案例类关系
class A {}
class B extends A {}
class C extends A with Trait01 {
    override def getConnect(): Unit = println("MySQL Connected")
}

class D {}
class E extends D {}
class F extends D with Trait01 {
    override def getConnect(): Unit = println("PostgreSQL Connected")
}