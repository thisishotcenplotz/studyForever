package com.hotcenplotz.chapter08.inner_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 07:26 
 * @description: 访问外部类的各种属性
 * */
object Demo02 {
    def main(args: Array[String]): Unit = {
        val outer = new Outer
        val inner = new outer.Inner
        
        inner.into()
        inner.show()
    }
}

class Outer {
    Temp =>  // 起别名，别名必须写在最前面 等价于 Outer.this
    val name: String = "zhang san"
    private val salary: Double = 35000.00
    
    class Inner {
        def into(): Unit = {
            println(s"name= ${Outer.this.name}; salary:${Outer.this.salary}")
        }
        
        def show():Unit = {
            println(s"Name = ${Temp.name}; Salary: ${Temp.salary}")
        }
    }
}