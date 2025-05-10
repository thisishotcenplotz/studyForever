package com.hotcenplotz.chapter06

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 11:40 
 * @description:
 */


object CreateObject {
    def main(args: Array[String]): Unit = {
        val emp = new Employee

        // 如果希望将一个子类的对象交给一个父类对象引用，这时就需要协商类型
        val emp2: Person = new Employee
    }
}


class Person {}

class Employee extends Person {}