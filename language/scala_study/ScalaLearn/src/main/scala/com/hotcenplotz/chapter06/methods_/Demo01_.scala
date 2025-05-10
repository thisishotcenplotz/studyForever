package com.hotcenplotz.chapter06.methods_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 15:55 
 * @description:
 */


object Demo01_ {
    def main(args: Array[String]): Unit = {
        val methods: Methods = new Methods

        methods.printRec()
    }
}

//class Dog {
//    private var sal:Dog = _
//    var food:String = _
//
//    def cal(n1:Int,n2:Int):Int = {
//        n1 + n2
//    }
//}

class Methods{
    val width:Int = 10
    val height:Int = 8

    def printRec():Unit = {
        (1 to height).foreach{col=>
            println((1 to width).map(_ => "*").mkString(""))
        }
    }

    def area(): Unit = println(this.width * this.height)
}