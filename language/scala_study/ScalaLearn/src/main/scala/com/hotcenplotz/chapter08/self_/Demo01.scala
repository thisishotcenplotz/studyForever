package com.hotcenplotz.chapter08.self_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 06:44
 * @description: 特质的自身类型示例代码
 * 特质的自身类型主要是为了解决特质的循环依赖问题。
 * */

object Demo01 {
    
}

// Logger就是自身类型特质，当做了自身类型后，
// 那么 trait Logger extends Exception，要求混入该特质的类也是Exception子类
trait Logger {
    // 明确告诉编译器，我就是Exception，如果没有这句话，下面的getMessage不能调用
    this: Exception =>
    
    def log():Unit = {
        // 既然我就是Exception，那么就可以调用其中的方法
        println(getMessage)
    }
}

// 不对！！！
// class Console extends Logger{}

// 对。
class Consoles extends Exception with Logger