package com.hotcenplotz.chapter08.mixin_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-14 06:03 
 * @description: */
object Demo05_ {
    def main(args: Array[String]): Unit = {
        
        // 静态方式
        // 1. 首先调用超类构造器 E...
        // 2. 然后从左往右找第一个特质的C的超类构造器，找到C，发现C的超类构造器是B，
        //    然后B的超类构造器是A，所以执行A...
        // 3. B...然后 C...
        // 4. 执行完C后找D，然后又寻根溯源找到A，B，但是发现都执行过就跳过了。 直接执行D...
        // 5. 最后执行自己 F...
        val ff: FF = new FF()
        
        println("~~~~~~~~~~~~")
        
        // 动态混入
        // 这里先创建KK,然后再混入
        // 1. 调用当前类的超类构造器
        // 2. 当前类构造器
        // 3. 第一个特质构造器的父构造器
        // 4. 第一个特质构造器
        // 5. 第二特构造器的父构造器，如果已经执行，就不再执行
        // 6. 第二个特质构造器
        // 7. 重复...
        // 8. 当前构造器
        // E...
        // K...
        // A...
        // B...
        // C...
        // D...
        val kk:KK = new KK() with C with D
    }
}

// traits ...
trait A {
    println("A...")
}

trait B extends A {
    println("B...")
}

trait C extends B {
    println("C...")
}

trait D extends B {
    println("D...")
}

// classes ...

class EE {
    println("E...")
}

class FF extends EE with C with D {
    println("F...")
}

class KK extends EE {
    println("K...")
}

