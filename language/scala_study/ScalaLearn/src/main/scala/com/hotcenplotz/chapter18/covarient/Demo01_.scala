package com.hotcenplotz.chapter18.covarient

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-06-01 10:37 
 * @description:
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 不变：
        val t1: Temp1[Sub] = new Temp1[Sub]("Hello") // ok
        // val t2: Temp1[Sub] = new Temp1[Super]("Hello") // bad!!
        // val t2: Temp1[Super] = new Temp1[Sub]("Hello") // bad!!
        
        
        //协变：
        val t2: Temp2[Super] = new Temp2[Sub]("Hello") // ok
        
        // 逆变：
        val t3: Temp3[Sub] = new Temp3[Super]("Hello") // bad!!
    }
}

// 不变
class Temp1[A](title:String) {
    override def toString: String = title
}

// 协变
class Temp2[+A](title:String) {
    override def toString: String = title
}

// 逆变
class Temp3[-A](title:String) {
    override def toString: String = title
}

// 父类
class Super

// 子类
class Sub extends Super

