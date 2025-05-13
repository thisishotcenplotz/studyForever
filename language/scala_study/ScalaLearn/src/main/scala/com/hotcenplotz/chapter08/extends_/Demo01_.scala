package com.hotcenplotz.chapter08.extends_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 06:28 
 * @description:
 * */

object Demo01_ {
    
}

// 说明：
// 1. LoggedException 继承了Exception
// 2. LoggedException 特质就可以 使用Exception 的功能
trait LoggedException extends Exception {
    def log():Unit = {
        println(getMessage) // 这个方法来自Exception 类
    }
}

// 因为UnhappyException 继承了LoggedException
// 而LoggedException继承了Exception
// UnhappyException 就成了Exception的子类
class UnhappyException extends LoggedException {
    // 是Exception的子类所以可以重写Exception的方法
    override def getMessage: String = "错误信息"
}

// 如果混入特质的类，已经继承了另一个类（A类）,
// 则要求A类是特质超类的子类，否则就会出现了多继承现象，发生错误。
class GoodHappyException extends IndexOutOfBoundsException with LoggedException {}

// 错误！
class CCC {}

// 这样不对。不行。 CCC 不是Exception 的子类
// class BadHappyException extends CCC with LoggedException{}
