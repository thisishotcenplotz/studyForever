package com.hotcenplotz.chapter08.mixin_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 20:43 
 * @description: 叠加特质实例代码
 * */
object Demo02_ {
    def main(args: Array[String]): Unit = {
        // 说明：
        // 1. 创建doris实例时，动态混入了NoSQL 和 Blob
        
        // 研究一个问题，当创建一个动态混入对象时，其顺序是怎么样的？
        // Scala 在叠加特质的时候，首先会从后面的特质开始执行（即从左往右）
        // 1. DatabaseDDL。。。
        // 2. Data
        // 3. NoSQL
        // 4. OSS
        
        val doris = new Doris with NoSQL with Blob with toFile {
        
        }
        
        // 研究第二个问题：当执行一个动态混入的方法时，其执行顺序是怎样的?
        // 顺序是从右到左执行。这地方是个栈。当执行到左边的时候，实际上是super的左边的类。
        // 如果左边没有特质了，则super才是父特质。
        // 1. to blob
        // 2. to mongo
        // 3. insert into ...
        doris.insert(100)
    }
}

trait DatabaseDDL {
    println("DatabaseDDL。。。")
    def insert(id: Int)
}

// 实现了DatabaseDDL
trait Data extends DatabaseDDL {
    println("Data")
    override def insert(id: Int): Unit = println(s"insert into ... $id")
}

// 重写了Data
trait NoSQL extends Data {
    println("NoSQL")
    
    override def insert(id: Int): Unit = {
        println("to mongo")
        
        // 这里的super在动态混入时，不一定是父类
        super.insert(id)
    }
}

trait Blob extends Data {
    println("OSS")
    
    override def insert(id: Int): Unit = {
        println("to blob")
        super.insert(id)
    }
}

trait toFile extends Data {
    println("to local file")
    override def insert(id: Int): Unit = super[Data].insert(id)
}

class Doris {}