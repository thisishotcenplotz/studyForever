// 等价于：com.hotcenplotz.chapter07.package_.pack_

package com.hotcenplotz.chapter07.package_ {

    //  因为包中不能写 方法和变量，所以Scala 引入了包对象这个概念来解决这个问题
    // 下面这个包对象对应了 package pack_ 这个包
    // 每一个包都可以有且仅有一个包对象
    // 包对象的名称必须与包包吃一致
    // 包对象中可以定义变量和方法，就可以在包中使用
    package object pack_ {
        val name: String = "zhang san"
        def sayHi(): Unit = {
            println(s"zhang san: Hi~")
        }
    }


    package pack_ {

        class Person(val name: String) {

            def play(msg: String): Unit = {
                println(this.name + " " + msg)
            }
        }

        object Test {
            def main(args: Array[String]): Unit = {
                val zhangsan = new Person("zhangsan")
                zhangsan.play("溜溜球")



            }
        }
    }

}