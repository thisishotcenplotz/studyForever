package com.hotcenplotz.chapter05.exceptions_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 09:35 
 * @description: scala try-catch demo
 */


object ScalaExceptions_ {
    def main(args: Array[String]): Unit = {

        // Scala 中只有一个catch
        // 一个catch中可以由多个case，每个case捕获一个异常
        // => 表示后面为该异常的处理代码，可以是代码块
        try {
            val r = 10 / 0
        } catch {
            case e: ArithmeticException => println("Arithmetic exception")
            case e: RuntimeException => println("Runtime Exception")
            case e: Exception => {
                // this is a code block
                println("Exception")
            }
        } finally {
            println("Done")
        }
    }
}
