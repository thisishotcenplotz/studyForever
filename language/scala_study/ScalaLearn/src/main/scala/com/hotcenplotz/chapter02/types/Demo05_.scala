package com.hotcenplotz.chapter02.types

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 05:20 
 * @description: Unit, Null, and Nothing
 */


object Demo05_ {
    def main(args: Array[String]): Unit = {
        val rst: Unit = sayHello()
        println(rst) // 返回一对小括号


        // Null
        val dog: Dog = null
        // val c1: Char = null // 这里会报错，说不能用隐式转换把null转成char
        println("OK~~~")

        println("hello".head)
        println("hello".reverse.head)

    }

    // Unit 等价于Java中的void
    // 只有一个实例值，就是()
    def sayHello(): Unit = {

    }


    // Nothing 类是所有类的子类
    // 比如开发中，有一个方法，就会异常中断，这时就可以返回Nothing
    // 当用Nothing做返回值时，就是明确说明该方法没有正常返回值
    private def sayHelloAgain:Nothing = {
        throw new Exception("抛出异常")
    }


}


class Dog {

}