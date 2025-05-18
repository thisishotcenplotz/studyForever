package com.hotcenplotz.chapter11

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-19 07:21 
 * @description:
 * */
object HighOrderFuncDemo02_ {
    
    // 这是一个高阶函数，可以接收一个，没有输入，返回为Unit的函数
    def test(f:() => Unit):Unit = f()
    
    def sayOk():Unit = println("Ok~~")
    
    def main(args: Array[String]): Unit = {
        test(sayOk)
    }
}
