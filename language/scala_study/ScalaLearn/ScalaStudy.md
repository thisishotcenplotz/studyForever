# Scala 介绍

##### Scala语言的特点

Scala是一门以JVM为运行环境并将**面向对象**和**函数式编程**的最佳特性结合在一起的静态类型编程语言。
1. Scala是一门多范式(multi-paradigm)的编程语言，Scala支持面向对象和函数式编程。
2. Scala源代码会被编译成java字节码，然后运行与JVM之上，并可以调用现有的Java类库，实现两种语言的无缝对接。
3. Scala在设计时，作者是参考了Java的设计思想，可以说Scala源于Java，同时他也加入了自己的设计思想，将函数式编程语言的特点融合到Java中。

# 第一章：注释

单行注释
```shell 
// 
```

多行注释
```shell 
/* */
```

文档注释
```shell 
/**
*/

scaladoc -d target_path source.scala
```

# 第二章：变量

```scala
val a:Short = 1

val b:Byte = 1

val age:Int = 10

val c:Long = 10

// 在scala中，小数默认为double类型，整数默认为Int类型
var score:Float = 99.9f

val salary:Double = 10.0

val isPass:Boolean = true

val gender:Char = 'M'

val name:String = "zhang san"
```


变量声明基本语法：
- var | val 


注意事项：
- 声明变量时，类型可以省略（编译器自动推导，即类型推导）
- 类型确定后，就不能修改，说明Scala是强数据类型语言
- 在声明一个变量时，可以使用var或者val来修饰，var修饰可变变量，val修饰不可变变量
- val修饰的变量在编译后，等同于加上了final
- 变量声明时，需要初始值。这里与Java不同。


##### 数据类型
- Scala 与 Java 有着相同的数据类型，在Scala中数据类型都是对象，也就是说Scala中没有Java中的原生类型
- Scala数据类型分为两大类，他俩都是对象
  - AnyVal （值类型）
  - AnyRef  (引用类型)
- 相对于java的类型系统，Scala更复杂，也正是这复杂多变的类型系统才让面向对象和函数式完美的融合在了一起


Scala数据类型
Any <-> Nothing
- AnyVal
  - Unit
  - StringOps
  - Char
  - Boolean
  - Byte
  - Short
  - Int
  - Long
  - Float
  - Double
- AnyRef <-> Null <- Nothing
  - Scala collections
  - all java classes
  - Other Scala classes


小结：
- 在Scala中有一个根类型Any，他是所有类的父类
- Scala中一切皆为对象，分为两大类 AnyVal(值类型)，AnyRef(引用类型)，它们都是Any的子类
- Null 是scala的特别类型，它只有一个值 null，它是是一个bottom class，是所有AnyRef的类型的子类
- Nothing 类也是 bottom class， 它是所有类的子类，在开发中通常可以将Nothing类型的值返回给任意变量或者函数，是抛异常时使用较多。
- 在Scala中仍然遵守，低精度向高精度自动转换（implicit conversion 隐式转换）