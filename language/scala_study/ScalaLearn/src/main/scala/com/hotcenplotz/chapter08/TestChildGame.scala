package com.hotcenplotz.chapter08

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-12 20:52 
 * @description:
 * */
object TestChildGame {
    def main(args: Array[String]): Unit = {
    
    }
}

// 说明：
// 1. 当在同一个文件中，有同名的class 和 object
// 2. 我们称之为伴生类，将非静态的内容放到该类中
// 3. 伴生对象时将静态的内容写入到该类中
// 4. 对于伴生对象的属性或方法，可以直接通过类名调用

class ScalaPerson {
    var name: String = _
}

object ScalaPerson {
    var gender: Boolean = true
    
    def sayHi(): Unit = println("Hi~~~")
}