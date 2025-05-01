package com.hotcenplotz.chapter02.types

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-02 07:30 
 * @description: 演示Nothing抛异常
 */


object Demo02_ {
    def main(args: Array[String]): Unit = {
        println(sayHello)
    }

    // Nothing 类是所有类的子类
    // 比如开发中，有一个方法，就会异常中断，这时就可以返回Nothing
    // 当用Nothing做返回值时，就是明确说明该方法没有正常返回值
    private def sayHello:Nothing = {
        throw new Exception("抛出异常")
    }
}


