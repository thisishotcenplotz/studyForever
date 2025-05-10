package com.hotcenplotz.chapter06.constructor_

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 17:54 
 * @description:
 */


// 如果主构造器的形参没有使用任何修饰符，
// 那么这个参数就是一个局部变量，范围就是主构造器中。
class ConstructorParamsDemo01(name: String) {

}

// 如果主构造器的形参用val修饰
// 那么这个形参会成为这个类的只读的私有属性 即 private final String name
// 实例化后可以直接访问这个属性
class ConstructorParamsDemo02(val name: String) {

}


// 如果主构造器的形参用var修饰
// 那么这个参数就是一个private 可读写的属性
class ConstructorParamsDemo03(var name: String) {

}

// BeanProperty 类似Java 的 Getter Setter 方法

class Car(
          @BeanProperty val car: String,
          @BeanProperty val color: String
         ) {

}
