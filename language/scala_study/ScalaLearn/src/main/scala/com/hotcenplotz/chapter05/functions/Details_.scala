package com.hotcenplotz.chapter05.functions

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-09 22:04 
 * @description:
 */


object Details_ {

    def main(args: Array[String]): Unit = {

        // 形参列表和返回值列表的数据类型可以使值类型和引用类型
        val tiger = new Tiger
        println(tiger.hashCode())
        println(test01(10, tiger).hashCode())

        // 如果不确定返回类型，可以设定返回值类型为Any
        println(test02(1, 2))

        // Scala中任何语法结构都可以嵌套，即函数中可以再定义函数，类中可以再声明类
        test03()

        // Scala函数支持可变参数
        println(test04(1, 2, 3, 4, 5, 6, 7))
    }

    def test01(n1: Int, tiger: Tiger): Tiger = {
        println(n1)
        tiger.name = "test"
        tiger
    }

    def test02(n1:Int,n2:Int):Any = {
        if ( n1 > n2 ) s"n1"
        else n2
    }

    def test03(): Unit = {
        def f1():Unit = {
            println("f1")
        }
        f1()
        println(s"test03")
    }

    def test04(args:Int*):Int = {
        val rst: Int = args.sum

        def example02(n:Int,args:Int*):Int = {
            n + args.sum
        }

        rst + example02(args(0),args(2))
    }
}


class Tiger {
    var name: String = ""
}