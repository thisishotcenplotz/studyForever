package com.hotcenplotz.chapter06.constructor_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 16:22 
 * @description:
 */


object Test {
    def main(args: Array[String]): Unit = {
        val zhangsan: PersonDemo = new PersonDemo("张三", 20)
        val lisi:PersonDemo = new PersonDemo("李四")
        println(zhangsan)
        println(lisi)

        // 为什么scala要搞一个主构造器，主要是为了继承的时候，调用父类构造器
        // println("AA~~~~")
        // println("Hello~~")
        // println("BB ~~~~~ constructor this(name:String)")
        // val bb = new BB("bbb")

        // val zhangsan1 = new PrivateDemo("zhangsan")

        val car:Car = new Car("bmw", "black")
    }

}

class AA {
    println("AA~~~~")
}

class BB extends AA {
    println("Hello~~")
    def this(name:String){
        this
        println("BB ~~~~~ constructor this(name:String)")
    }
}
