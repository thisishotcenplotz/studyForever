package com.hotcenplotz.chapter13

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-23 06:58 
 * @description: 闭包
 * */
object Demo04_ {
    def main(args: Array[String]): Unit = {
        def aFunc(x: Int): Int => Int = (y: Int) => x + y
        
        // f 就是闭包
        // 函数[(y:Int) => x -y] + 外部变量x[20] 构成了一个闭包
        val f: Int => Int = aFunc(20)
        
        /* 小结
        1. （y:Int） => x + y 返回的是一个匿名函数，因为该函数引用到函数外的x，那么该函数和x整体形成一个闭包
        2. 可以这样理解，返回函数是一个对象，而x就是该对象的一个字段，他们共同形成一个闭包
        3. 当多次调用f时，发现使用的是同一个x，所以x不变
        4. 在使用闭包时，主要搞清楚函数引用了函数外的哪些变量，因为他们会组合成一个整体（实体），形成一个闭包
        */
        
        println(f(5))
        
        // 最佳实践案例
        exercise()
        
    }
    
    // 闭包最佳实践案例
    private def exercise(): Unit = {
        def makeSuffix(suffix: String): String => String = {
            (fileName: String) => {
                if (fileName.endsWith(suffix)) fileName else fileName + "." + suffix
            }
        }
        
        val sql = makeSuffix("sql")
        val csv = makeSuffix("csv")
        
        println(sql("aaa.sql"))
        println(sql("bbb"))
        println(csv("aaa.csv"))
        println(csv("bbb"))
    }
    
}
