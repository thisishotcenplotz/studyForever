package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 09:30 
 * @description: 抽象控制
 * */
object Demo06_ {
    def main(args: Array[String]): Unit = {
        
        // 抽象控制demo
        
        // 1.输入是一个函数
        // 2. 输入的函数没有形参也没有返回值
        def myAbstractControlDemo(f: => Unit): Unit = {
            new Thread {
                override def run(): Unit = f
            }.start()
        }
        
        // 这玩意跑多线程很不错。
        // 使用案例
        
        (1 to 200).foreach{ _ =>
            myAbstractControlDemo {
                println("Hello World...")
                Thread.sleep(1000)
                println("Rock the JVM...")
            }
        }
    }
}
