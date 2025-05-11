package com.hotcenplotz.chapter07.package_.import_

import scala.collection.mutable


/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-11 07:05 
 * @description:
 */


class Demo_ {
    def main(args: Array[String]): Unit = {

    }

    def test():Unit = {
        import java.util.{HashMap => JavaHashMap}
        val map1 = new JavaHashMap()
    }

}

class User {
    // 此时BeanProperty 的作用域，仅在当前{} 中。
    import scala.beans.BeanProperty
    @BeanProperty var name:String = ""
}

class Dog {
    // _ 与java import 的 * 等价
    import scala.beans._
    @BeanProperty var name:String = ""
}