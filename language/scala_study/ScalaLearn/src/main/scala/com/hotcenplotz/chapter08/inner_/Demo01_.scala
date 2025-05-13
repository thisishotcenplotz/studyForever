package com.hotcenplotz.chapter08.inner_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 07:20 
 * @description: */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        val outer1: ScalaOuterClass = new ScalaOuterClass
        val outer2: ScalaOuterClass = new ScalaOuterClass
        
        // 创建成员内部类
        val inner1 = new outer1.ScalaInnerClass
        val inner2 = new outer2.ScalaInnerClass
        
        // 创建静态内部类
        val staticInner1 = new ScalaOuterClass.ScalaStaticInnerClass
    }
}

// 外部类
class ScalaOuterClass {
    // 成员内部类
    class ScalaInnerClass {}
}

object ScalaOuterClass {
    // 静态内部类
    class ScalaStaticInnerClass{}
}