package com.hotcenplotz.chapter06.constructor_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 16:21 
 * @description:
 */


class PersonDemo(name: String, age: Int) {

    // 这里算主构造器，所以这里执行的语句会被按顺序执行
    println("step one ...")
    println("step two ...")
    println("step three ...")
    println("step four ...")

    def this(name:String){
        // 辅助构造器必须在第一行显示调用主构造器
        this(name,0)

        //然后可以干点别的
        "只有name的辅助构造器"
    }


    // 重写toString 方法
    override def toString: String = {
        s"name:${this.name} age:${this.age}"
    }
}
