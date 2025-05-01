package com.hotcenplotz.chapter02.variables

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-01 14:11 
 * @description:
 */


object Variables02_ {
    def main(args: Array[String]): Unit = {
        // 类型推导
        val num = 10 // 此时这里是Int

        val num2 = 10
        // 判断一下即可
        println(num2.isInstanceOf[Int])

        /**
         * 为什么Scala要设计可变和不可变的类型？
         * (1) 在实际需求中，更多的需求是在获取/创建一个对象后，
         * 读取该对象的属性，或者修改对象的属性值,
         * 但是很少去改变这个对象本身。
         * (2) 这时就可以使用val，因为val没有线程安全问题，因此效率高！
         * (3) 如果对象需要变化，则使用var
         */

        val dog: Dog = new Dog()
    }
}

class Dog {
    // 声明一个age
    var age:Int = 0
    // 声明name
    var name:String = ""
}
